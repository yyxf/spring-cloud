package com.pxz.consumer.model.response;

/**
 * @author YangSheng
 * @Package com.qckj.core.response
 * @date 2018/10/19 15:27
 */
public class ResponsePageBean<T> extends ResponseBean {
   private int count;

    public ResponsePageBean setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getCount() {
        return count;
    }
}
