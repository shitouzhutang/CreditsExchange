package com.service.serviceImpl;

import com.model.po.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.custom.DxExchangeListMapper;
import com.model.po.DxExchangeList;
import com.service.interceptor.ExchangeService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    private DxExchangeListMapper dxExchangeListMapper;

    public DxExchangeList selectByphoneNo(String phoneNo) {
        DxExchangeList exchangeList=new DxExchangeList();
         exchangeList=dxExchangeListMapper.selectByphoneNo(phoneNo);
        return exchangeList;
    }

    /**
     * 订单创建
     *
     * @param dxExchangeList
     */
    @Override
    public void insertOrder(DxExchangeList dxExchangeList) {
        dxExchangeListMapper.insertOrder(dxExchangeList);
    }

    /**
     * 返回所有的可兑换的礼品
     * @return
     */
     public   List<Gift> getAllGift(){
        List<Gift> giftList=new ArrayList<>();
        Gift gift1=new Gift();
        gift1.setGiftId("H0001");
        gift1.setChangeNumber("1");
        gift1.setScoreValue("5000");
        gift1.setGiftName("UFO不锈水杯");
        giftList.add(gift1);
        Gift gift2=new Gift();
        gift2.setGiftId("H0002");
        gift2.setChangeNumber("1");
        gift2.setScoreValue("200");
        gift2.setGiftName("咖啡杯");
        giftList.add(gift2);
        return giftList;
    }

    /**
     * 根据Id查询礼品
     *
     * @param giftId
     * @return
     */
    @Override
    public Gift getGiftById(String giftId) {
        Gift gift=new Gift();
        List<Gift> giftList=getAllGift();
        for (int i = 0; i < giftList.size(); i++) {
            if (gift.equals(giftList.get(i).getGiftId())){
                gift=giftList.get(i);
                break;
            }
        }
        return gift;
    }
}
