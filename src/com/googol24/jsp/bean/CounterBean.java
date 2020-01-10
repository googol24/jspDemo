package com.googol24.jsp.bean;

import java.io.Serializable;

/**
 * JSP Beam 测试
 */
public class CounterBean implements Serializable{
    private int count = 0;

    public CounterBean() {

    }

    public int getCount() {
        count++;
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
