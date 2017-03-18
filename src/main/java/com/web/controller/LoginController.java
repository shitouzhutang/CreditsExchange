package com.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.interceptor.LoginService;

import com.utils.*;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Created by Administrator on 2017/3/14.
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/loginIndex")
    public String loginIndex(){
        return "/login";
    }

    @RequestMapping(value = "/login")
    public String login(String username,String password){
        System.err.println(username);
        System.err.println(password);
        return "redirect:/exchangeIndex";
    }


    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    @ResponseBody
    public Object login(HttpServletRequest request) throws Exception {
        JSONObject result = new JSONObject();
        KeyPair kp = RSAUtil.generateKeyPair();
        RSAPublicKey pubk = (RSAPublicKey) kp.getPublic();// 生成公钥
        RSAPrivateKey prik = (RSAPrivateKey) kp.getPrivate();// 生成私钥
        String publicKeyExponent = pubk.getPublicExponent().toString(16);// 16进制
        String publicKeyModulus = pubk.getModulus().toString(16);// 16进制
        request.getSession().setAttribute("prik", prik);
        result.put("pubexponent", publicKeyExponent);
        result.put("pubmodules", publicKeyModulus);
        return result;
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request) throws Exception {
        JSONObject result = new JSONObject();
        byte[] en_result = new BigInteger(password, 16).toByteArray();
        byte[] de_result = RSAUtil.decrypt(RSAUtil.getKeyPair().getPrivate(), en_result);
        StringBuffer sb = new StringBuffer();
        sb.append(new String(de_result));
        String pwd = sb.reverse().toString();
        if("12345".equals(pwd)){

            return "/success";
        }
//        List<User> user = acountManageService.getUserByName(username);
//        if (user != null && user.get(0).getPassword().equals(pwd.toString())) {
//            request.getSession().setAttribute("user", user.get(0));
//            result.put("result", "1");
//            result.put("desc", "Login success");
//            return result;
//        }
        result.put("result", "0");
        result.put("desc", "Login failed");
        return "/index";
    }









}
