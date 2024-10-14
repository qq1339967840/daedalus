package com.cib.icarus.core.module.sensitive;

import com.cib.icarus.core.module.sensitive.annotation.internals.DefaultIdCardSensitive;
import com.cib.icarus.core.module.sensitive.annotation.internals.DefaultMobileSensitive;

import java.io.Serializable;

public class SensitiveSubDTO  {

    private String name;

    @DefaultMobileSensitive
    private String mobileNo;


    @DefaultIdCardSensitive
    private String idCard;


    public SensitiveSubDTO() {
    }

    public SensitiveSubDTO(String name, String mobileNo, String idCard) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.idCard = idCard;
    }


    @Override
    public String toString() {
        return "SensitiveSubDTO{" +
                "name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
