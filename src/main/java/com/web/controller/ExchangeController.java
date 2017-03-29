package com.web.controller;

import com.model.po.*;
import com.model.vo.ExchangeVo;
import com.service.serviceImpl.CreatePointOrderWs;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public  ModelAndView select(@RequestParam(value = "phone",required = false) String phone){
        ModelAndView modelAndView=new ModelAndView();
        ExchangeVo exchangeVo=new ExchangeVo();
        //根据设备号（手机号码）查询客户号
        String customNum= GetCustomerNbrWs.getCustomerNbr(phone);
        exchangeVo.setCustomNo(customNum);
        exchangeVo.setSerialNo(phone);
       //根据客户编号查询是否在积分兑换黑名单内 返回0  是无兑换权限的客户， 返回1 是有兑换权限的客户
       if(!"".equals(customNum)){
           String wsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=GetPointLimitCrmid&ServiceVer=1.0&Consumer=ZZSLPT";
           GetPointLimitCrmidReq req=new GetPointLimitCrmidReq();
           req.setCrmId(customNum);
           GetPointLimitCrmidResp  resp= GetPointLimitCrmidWs.GetPointLimitCrmid(req,wsAddress);
           String limitNo=resp.getMultiRef();                                  //是否在黑名单内
           exchangeVo.setLimitNo(limitNo);
           if ("1".equals(limitNo)){
               //获取用户积分余额
               String pointsWsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=SearchRestPoints&ServiceVer=1.0&Consumer=ZZSLPT";
               SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
               String date=simpleDateFormat.format(new Date()).toString();
               SearchRestPointsReq pointsReq=new SearchRestPointsReq();
              // pointsReq.setCrmId("202123319237");
               pointsReq.setCrmId(customNum);
               pointsReq.setEndDate(date);
               pointsReq.setStartDate(date);
               pointsReq.setSource("ZZSLPT");
               SearchRestPointsResp  pointsResp= SearchRestPointsWs.searchRestPoints(pointsReq,pointsWsAddress);
               //用户积分余额
               String points="";
               if(pointsResp!=null){
                   points=pointsResp.getPoints();
               }
               exchangeVo.setRestPoints(points);
           }
       }
        List<Gift> giftList=exchangeService.getAllGift();
        exchangeVo.setGiftList(giftList);
        modelAndView.addObject("dxExchange",exchangeVo);
        modelAndView.setViewName("/exchangeIndex");
        return modelAndView;
    }

    /**
     * 客户积分兑换
     * @param request
     */
    @RequestMapping("/exchange")
    public  ModelAndView exchange(HttpServletRequest request,@RequestParam(value = "customNo",required = false)String customNo,@RequestParam("giftId")String giftId,@RequestParam("serialNo")String serialNo){
        ModelAndView modelAndView=new ModelAndView();
        String resultMsg="";
        //获取礼品对象
        Gift gift=exchangeService.getGiftById(giftId);
        //调用积分订单创建接口
        CreatePointOrderReq req=new CreatePointOrderReq();
        String wsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=CreatePointOrder&ServiceVer=1.0&Consumer=ZZSLPT";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        req.setRequestTime(sdf.format(new Date()));
        req.setOrderTotal("2");
        req.setSender("积分平台");
        req.setReciver("XX配送商");
        req.setActiveCode("0991");
        req.setCrmId(customNo);
        req.setAccount("zhangjiming");
        req.setAddress("北京西路819号");
        req.setBrand("1");
        req.setCardID("12345");
        req.setCustomerArea("金山");
        req.setCustomerName("张计明");
        req.setCustRemark("客户留言:sdfasfasf");
        req.setDeadLineDate("2009-03-16");
        req.setChannel("ZZSLPT");
        req.setExpressValue("250");
        req.setFirstContact("mobile");
        req.setOrderType("2");
        req.setTotalScore("6200");
        req.setTelephone("18917880176");
        req.setEmail("aa@sohu.com");
        req.setPostCode("200120");
        //礼品信息
        req.setGiftId1(gift.getGiftId());
        req.setGiftName1(gift.getGiftName());
        req.setChangeNumber1(gift.getChangeNumber());
        req.setScoreValue1(gift.getScoreValue());
        if ("H0001".equals(giftId)){
            req.setGiftId2("H0002");
            req.setGiftName2("咖啡杯");
            req.setChangeNumber2("1");
            req.setScoreValue2("200");
        }else if ("H0002".equals(giftId)){
            req.setGiftId2("H0001");
            req.setGiftName2("UFO不锈水杯");
            req.setChangeNumber2("1");
            req.setScoreValue2("5000");
        }
        CreatePointOrderResp  resp= CreatePointOrderWs.CreatePointOrder(req,wsAddress);
        //订单创建结果插入数据库
        DxExchangeList dxExchangeList=new DxExchangeList();
        //流水号
        dxExchangeList.setSerialNo("111111");
        //设备号 （就是电话号码）
        dxExchangeList.setEquiNum(serialNo);
        //操作员
        dxExchangeList.setOperator("admin");
        //接口请求失败的反馈信息
        dxExchangeList.setErrCode(resp.getErrCode());
        dxExchangeList.setErrDesc(resp.getErrDesc());
        dxExchangeList.setFaultCode(resp.getFaultcode());
        dxExchangeList.setFaultString(resp.getFaultstring());
        //兑换结果
        dxExchangeList.setResultCode(resp.getActiveCode());
        dxExchangeList.setTime( sdf.format(new Date()));
        exchangeService.insertOrder(dxExchangeList);
        if ("success".equals(resp.getDescription())){
            resultMsg="兑换成功";
        }else{
            resultMsg="兑换失败";
        }
        modelAndView.addObject("resultMsg",resultMsg);
        modelAndView.setViewName("/exchangeIndex");
        return modelAndView;

    }



}
