package com.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.custom.DxExchangeListMapper;
import com.model.po.DxExchangeList;
import com.service.interceptor.ExchangeService;
import org.springframework.transaction.annotation.Transactional;

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
}
