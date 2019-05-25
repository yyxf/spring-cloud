package com.pxz.provider.model;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * TODO
 *
 * @ClassName User
 * @Package com.pxz.produce.model
 * @Author 潘形忠
 * @Date 2019/5/20 12:40
 */

public class User {
    private Long id;
    private Date date;

    public User() {
    }

    public User(Long id) {
        this.id = id;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
