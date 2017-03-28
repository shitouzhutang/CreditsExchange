package com.service.interceptor;

import com.model.po.DxExchangeList;
import com.model.po.Gift;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
public interface ExchangeService {
    DxExchangeList selectByphoneNo(String phoneNo);

    /**
     * 订单创建
     *
     * @param dxExchangeList
     */
    public void insertOrder(DxExchangeList dxExchangeList);

    /**
     * 返回所有的可兑换的礼品
     * @return
     */
    List<Gift> getAllGift();

    /**
     * 根据Id查询礼品
     * @param giftId
     * @return
     */
    Gift getGiftById(String giftId);

}
