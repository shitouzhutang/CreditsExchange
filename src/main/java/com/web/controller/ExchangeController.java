package com.web.controller;

import com.model.vo.ExchangeVo;
import com.service.serviceImpl.GetCustomerNbrWs;
import com.service.serviceImpl.GetPointLimitCrmidWs;
import com.service.serviceImpl.SearchRestPointsWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.model.po.DxExchangeList;
import com.service.interceptor.ExchangeService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/3/15.
 */
@Controller
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @RequestMapping(value = "/exchangeIndex")
    public ModelAndView exchangeIndex(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/exchangeIndex");
        return  modelAndView;
    }

    /**
     * 客户相关信息查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/select")
    public  ModelAndView select(String phone){
        ModelAndView modelAndView=new ModelAndView();
       //DxExchangeList dxExchangeList= exchangeService.selectByphoneNo(phone);
        //根据设备号（手机号码）查询客户号
       String customNum= GetCustomerNbrWs.getCustomerNbr(phone);
       //根据客户编号查询是否在积分兑换黑名单内 返回0  是无兑换权限的客户， 返回1 是有兑换权限的客户
        String limitNo= GetPointLimitCrmidWs.getPointLimitByCustomNo(customNum);
        //获取用户积分余额
        String points=SearchRestPointsWs.getRestPoints(customNum,phone);

        ExchangeVo exchangeVo=new ExchangeVo();
        exchangeVo.setCustomNo(customNum);
        exchangeVo.setSerialNo(phone);
        exchangeVo.setLimitNo(limitNo);
        exchangeVo.setRestPoints(points);
        modelAndView.addObject("dxExchange",exchangeVo);
        modelAndView.setViewName("/exchangeIndex");
        System.err.println(phone);
        return modelAndView;
    }

    /**
     * 客户积分兑换
     * @param request
     */
    @RequestMapping("/exchange")
    public  void exchange(HttpServletRequest request){
        //调用订单创建接口


    }



}
