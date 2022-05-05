package com.formacion.bosonit.BS0.domain.entity;

public class User {

    private String name;
    private String city;
    private Integer age;

    //CONSTRUCTOR
    public User(String name, String city, Integer age){
        this.name = name;
        this.city = city;
        this.age = age;
    }

    // GETTERS

    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public String getCity() {
        return city;
    }

    // SETTERS
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setName(String name) {
        this.name = name;
    }

}
