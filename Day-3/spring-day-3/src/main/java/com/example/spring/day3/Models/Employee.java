package com.example.spring.day3.Models;

public class Employee {
    private int userid;
    private String name;
    private String job;

    public Employee(int userid, String name, String job) {
        this.userid = userid;
        this.name = name;
        this.job = job;
    }

    public int getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }
}