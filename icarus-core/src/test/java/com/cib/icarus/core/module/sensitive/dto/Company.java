package com.cib.icarus.core.module.sensitive.dto;

import java.util.Arrays;
import java.util.List;

public class Company {

    private Person boss;

    private List<Person> employees;


    private Person[] others;


    public Person getBoss() {
        return boss;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public Person[] getOthers() {
        return others;
    }

    public void setBoss(Person boss) {
        this.boss = boss;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    public void setOthers(Person[] others) {
        this.others = others;
    }


    @Override
    public String toString() {
        return "Company{" +
                "boss=" + boss +
                ", employees=" + employees +
                ", others=" + Arrays.toString(others) +
                '}';
    }
}
