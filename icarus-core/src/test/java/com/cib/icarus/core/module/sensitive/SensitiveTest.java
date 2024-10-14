package com.cib.icarus.core.module.sensitive;

import com.cib.icarus.core.module.sensitive.core.DefaultWrapper;

public class SensitiveTest {


    public static void main(String[] args) {
        SensitiveDTO sensitiveDTO = new SensitiveDTO("张三", "13000000000", "610202199409182814");
        SensitiveSubDTO sensitiveSubDTO = new SensitiveSubDTO("李四", "13000000000", "610202199409182814");
        sensitiveDTO.setDto(sensitiveSubDTO);

        DefaultWrapper wrapper = new DefaultWrapper();
        Object dto2 =  wrapper.sensitive(sensitiveDTO);

        System.out.println(dto2);
        System.out.println(sensitiveDTO);
    }


}
