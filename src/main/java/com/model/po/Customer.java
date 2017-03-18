package com.model.po;

/**
 * Created by Administrator on 2017/3/16.
 */
public class Customer {
    private String  cust_number;

    public String getCust_number() {
        return cust_number;
    }

    public void setCust_number(String cust_number) {
        this.cust_number = cust_number;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "cust_number='" + cust_number + '\'' +
                '}';
    }
}
