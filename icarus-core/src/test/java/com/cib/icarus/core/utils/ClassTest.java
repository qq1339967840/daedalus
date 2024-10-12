package com.cib.icarus.core.utils;

import java.lang.reflect.Field;

public class ClassTest {


    public static void main(String[] args) {
        DTO dto = new DTO();
        dto.name = "test";

        Data data = new Data();
        data.name = "zhengyi";
        data.age = 12;
        data.age2 = 18;
        data.dto = dto;

        Field[] fields = data.getClass().getDeclaredFields();

        for (Field field: fields) {
            System.out.println(field.getName() + " " + field.getType().isPrimitive());
        }


    }


    static class Data {

        private String name;

        private int age;

        private Integer age2;

        private DTO dto;


    }

    static class DTO {
        private String name;
    }

}
