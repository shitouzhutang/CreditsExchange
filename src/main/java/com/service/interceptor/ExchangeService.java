package com.service.interceptor;

import com.model.po.DxExchangeList;

/**
 * Created by Administrator on 2017/3/15.
 */
public interface ExchangeService {
    DxExchangeList selectByphoneNo(String phoneNo);
}
