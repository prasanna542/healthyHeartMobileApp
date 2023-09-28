package com.example.healthyheartfinal;

public class Users {

    String userName,name, age,sex, cigperday, cholesterol, diabities, glucose;

    public Users() {

    }

    public Users(String userName, String name, String age, String sex, String cigperday, String cholesterol, String diabities, String glucose) {
        this.userName = userName;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.cigperday = cigperday;
        this.cholesterol = cholesterol;
        this.diabities = diabities;
        this.glucose = glucose;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCigperday() {
        return cigperday;
    }

    public void setCigperday(String cigperday) {
        this.cigperday = cigperday;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getDiabities() {
        return diabities;
    }

    public void setDiabities(String diabities) {
        this.diabities = diabities;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }
}
