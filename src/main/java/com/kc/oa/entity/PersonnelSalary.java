package com.kc.oa.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonnelSalary implements Serializable {
    private String id;
    private String day;
    private String dayPrice;
    private String userName;
    private int userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date years;
    private String accountsPayable;
    private int actualPayment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(String dayPrice) {
        this.dayPrice = dayPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getYears() {
        return years;
    }

    public void setYears(Date years) {
        this.years = years;
    }

    public String getAccountsPayable() {
        return accountsPayable;
    }

    public void setAccountsPayable(String accountsPayable) {
        this.accountsPayable = accountsPayable;
    }

    public int getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(int actualPayment) {
        this.actualPayment = actualPayment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  updateTime;

}
