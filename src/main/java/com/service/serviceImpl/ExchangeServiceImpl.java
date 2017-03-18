package com.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.custom.DxExchangeListMapper;
import com.model.po.DxExchangeList;
import com.service.interceptor.ExchangeService;

/**
 * Created by Administrator on 2017/3/15.
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    private DxExchangeListMapper dxExchangeListMapper;

    public DxExchangeList selectByphoneNo(String phoneNo) {

        return dxExchangeListMapper.selectByphoneNo(phoneNo);
    }
}
