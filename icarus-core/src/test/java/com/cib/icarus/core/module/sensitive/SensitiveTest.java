package com.cib.icarus.core.module.sensitive;

import com.cib.icarus.core.module.desensitize.ObjectWrapper;
import com.cib.icarus.core.module.sensitive.dto.Company;
import com.cib.icarus.core.module.sensitive.dto.Person;
import org.junit.Test;

import java.util.Arrays;

public class SensitiveTest {

    @Test
    public void dealObject() {
        Company company = getCompany();
        ObjectWrapper wrapper = new ObjectWrapper();
        System.out.println(wrapper.desensitize(company));
        System.out.println(company);
    }

    @Test
    public void dealList() throws Exception {
        Company company = getCompany();
        ObjectWrapper wrapper = new ObjectWrapper();
        System.out.println(wrapper.desensitize(company.getEmployees()));
        System.out.println(company.getEmployees());
    }


    @Test
    public void dealArray() {
        Company company = getCompany();
        ObjectWrapper wrapper = new ObjectWrapper();
        Person[] peoples = (Person[]) wrapper.desensitize(company.getOthers());
        System.out.println(Arrays.toString(peoples));
        System.out.println(Arrays.toString(company.getOthers()));
    }


    private Company getCompany() {
        Company company = new Company();

        Person person = new Person("张三", "18392480273", "610202199409172589");
        Person person2 = new Person("李四", "18392480273", "610202199409172589");
        Person person3 = new Person("王五", "18392480273", "610202199409172589");
        Person person4 = new Person("赵六", "18392480273", "610202199409172589");
        Person person5 = new Person("拉姆达", "18392480273", "610202199409172589");

        company.setBoss(person);

        company.setEmployees(Arrays.asList(person2, person3, person4, person5));

        company.setOthers(new Person[]{
                new Person("其他一", "18392480273", "610202199409172589"),
                new Person("其他二", "18392480273", "610202199409172589")});
        return company;
    }


}
