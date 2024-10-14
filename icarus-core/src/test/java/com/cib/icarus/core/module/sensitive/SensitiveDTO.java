package com.cib.icarus.core.module.sensitive;

import com.cib.icarus.core.module.sensitive.annotation.internals.DefaultMobileSensitive;

import java.io.Serializable;
import java.util.List;

public class SensitiveDTO{

    private String name;

    @DefaultMobileSensitive
    private String mobileNo;

    private String idCard;

    private SensitiveSubDTO dto;

    private List<String> a;


    public SensitiveDTO() {
    }

    public SensitiveDTO(String name, String mobileNo, String idCard) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.idCard = idCard;
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

    public void setDto(SensitiveSubDTO dto) {
        this.dto = dto;
    }

    @Override
    public String toString() {
        return "SensitiveDTO{" +
                "name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", idCard='" + idCard + '\'' +
                ", dto=" + dto +
                '}';
    }
}
