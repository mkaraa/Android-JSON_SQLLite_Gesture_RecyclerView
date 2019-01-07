package com.metehankara.metehankara_termproject_487;

public class Customers {
    public static String name,surname;
    public static String email,password,confirmPassword;
    public static String age,city,profession;

    public Customers(String name,String surname,String email,String password, String conf, String age, String city, String pro) {
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.password=password;
        this.confirmPassword = conf;
        this.age=age;
        this.city=city;
        this.profession=pro;
    }

    public Customers() {

    }


    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Customers.name = name;
    }

    public static String getSurname() {
        return surname;
    }

    public static void setSurname(String surname) {
        Customers.surname = surname;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Customers.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Customers.password = password;
    }

    public static String getConfirmPassword() {
        return confirmPassword;
    }

    public static void setConfirmPassword(String confirmPassword) {
        Customers.confirmPassword = confirmPassword;
    }

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        Customers.age = age;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        Customers.city = city;
    }

    public static String getProfession() {
        return profession;
    }

    public static void setProfession(String profession) {
        Customers.profession = profession;
    }
}
