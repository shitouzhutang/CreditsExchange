package com.dao.custom;


import com.model.po.DxExchangeList;

/**
 * Created by Administrator on 2017/3/15.
 */
public interface DxExchangeListMapper {
    DxExchangeList selectByphoneNo(String phoneNo);
}
