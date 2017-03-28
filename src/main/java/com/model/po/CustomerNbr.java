package com.model.po;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public class CustomerNbr {
    private List<Customer> items;
//    private Ref next;

    public List<Customer> getItems() {
        return items;
    }

    public void setItems(List<Customer> items) {
        this.items = items;
    }

//    public Ref getNext() {
//        return next;
//    }
//
//    public void setNext(Ref next) {
//        this.next = next;
//    }


    @Override
    public String toString() {
        return "CustomerNbr{" +
                "items=" + items +
                '}';
    }
}
