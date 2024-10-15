package com.cib.icarus.core.module.sensitive.dto;

import com.cib.icarus.core.module.desensitize.annotation.internals.IdCardDesensitize;
import com.cib.icarus.core.module.desensitize.annotation.internals.MobileDesensitize;

public class Person {

    private String name;

    @MobileDesensitize
    private String mobileNo;

    @IdCardDesensitize
    private String idCard;

    public Person() {
    }

    public Person(String name, String mobileNo, String idCard) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
