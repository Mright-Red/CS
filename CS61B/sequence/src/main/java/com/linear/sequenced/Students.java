package com.linear.sequenced;

//学生类
public class Students {

    private String id;// 学号
    private String name;// 姓名
    private String gender;// 性别
    private int age;// 年龄

    public Students() {

    }

    public Students(String sid, String name, String gender, int age) {
        this.id = sid;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "学号：" + this.getId() + " 姓名：" + this.getName() + " 性别：" + this.getGender() + " 年龄:" + this.getAge();
    }

}
