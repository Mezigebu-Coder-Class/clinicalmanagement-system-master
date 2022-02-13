package com.example.tecno;

public class REColumnNames {
        DBConnection connection = new DBConnection();
        private String date;
        private String id;
        private String name;
        private String age;
        private String gender;
        private String phoneno;
        private String address;
        private String username;
        private String password;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public REColumnNames(String date, String id, String name, String age, String gender, String phoneno, String address, String username, String password) {
        this.date = date;
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneno = phoneno;
        this.address = address;
        this.username = username;
        this.password = password;
    }
}