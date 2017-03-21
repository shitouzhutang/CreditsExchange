package com.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.interceptor.LoginService;

import com.utils.*;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
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


    @RequestMapping(value = "/userLogin")
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

    @RequestMapping(value = "/loginCheck")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) throws Exception {
        JSONObject result = new JSONObject();
        byte[] en_result=HexUtil.hexStringToBytes(password);
        PrivateKey privateKey=RSAUtil.getKeyPair().getPrivate();
        byte[] de_result = RSAUtil.decrypt(privateKey, en_result);
        StringBuilder sb = new StringBuilder();
        sb.append(new String(de_result));
        String pwd = sb.reverse().toString();
        if("admin".equals(username)&&"1234".equals(pwd)){
            return "redirect:/exchangeIndex";
        }
        return "";
//        result.put("result", "0");
//        result.put("desc", "Login failed");
//        return "/index";
    }









}
