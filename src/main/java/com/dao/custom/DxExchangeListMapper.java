package com.dao.custom;


import com.model.po.DxExchangeList;

/**
 * Created by Administrator on 2017/3/15.
 */
public interface DxExchangeListMapper {

    /**
     * 订单创建
     * @param dxExchangeList
     */
    void insertOrder(DxExchangeList dxExchangeList);
}
