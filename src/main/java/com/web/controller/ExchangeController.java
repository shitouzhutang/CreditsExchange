package com.web.controller;

import com.model.po.*;
import com.model.vo.ExchangeVo;
import com.service.serviceImpl.GetCustomerNbrWs;
import com.service.serviceImpl.GetPointLimitCrmidWs;
import com.service.serviceImpl.SearchRestPointsWs;
import com.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.service.interceptor.ExchangeService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     * @param
     * @return
     */
    @RequestMapping(value = "/select")
    public  ModelAndView select(String phone){
        ModelAndView modelAndView=new ModelAndView();
        //根据设备号（手机号码）查询客户号
       String customNum= GetCustomerNbrWs.getCustomerNbr(phone);
       //根据客户编号查询是否在积分兑换黑名单内 返回0  是无兑换权限的客户， 返回1 是有兑换权限的客户
        String wsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=GetPointLimitCrmid&ServiceVer=1.0&Consumer=ZZSLPT";
        GetPointLimitCrmidResp resp= new GetPointLimitCrmidResp();
        GetPointLimitCrmidReq req=new GetPointLimitCrmidReq();
        req.setCrmId("202110249226");
        resp= GetPointLimitCrmidWs.GetPointLimitCrmid(req,wsAddress);
        String limitNo=resp.getMultiRef();                                  //是否在黑名单内
        //获取用户积分余额
        String pointsWsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=SearchRestPoints&ServiceVer=1.0&Consumer=ZZSLPT";
        SearchRestPointsResp pointsResp=new SearchRestPointsResp();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date=simpleDateFormat.format(new Date()).toString();
        SearchRestPointsReq pointsReq=new SearchRestPointsReq();
        pointsReq.setCrmId("202123319237");
       // req.setCrmId("202110249226");
        pointsReq.setEndDate(date);
        pointsReq.setStartDate(date);
        pointsReq.setSource("ZZSLPT");
        pointsResp= SearchRestPointsWs.searchRestPoints(pointsReq,pointsWsAddress);
        //用户积分余额
        String points="";
        if(pointsResp!=null){
            points=pointsResp.getPoints();
        }


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
    public  ModelAndView exchange(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        //调用积分订单创建接口

        //订单创建结果插入数据库
        DxExchangeList dxExchangeList=new DxExchangeList();
        dxExchangeList.setSerialNo("111111");
        dxExchangeList.setEquiNum("22");
        dxExchangeList.setOperator("admin");
        dxExchangeList.setPhone("13600000000");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        dxExchangeList.setTime( sdf.format(new Date()));
        exchangeService.insertOrder(dxExchangeList);
        modelAndView.addObject("success","兑换成功");
        modelAndView.setViewName("/exchangeIndex");
        return modelAndView;

    }



}
