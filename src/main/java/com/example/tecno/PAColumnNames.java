package com.example.tecno;

public class PAColumnNames {
    DBConnection connection = new DBConnection();

    private String id;
    private String name;
    private String age;
    private String gender;
    private String roomno;


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

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }



    public PAColumnNames(String id, String name, String age, String gender, String roomno) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.roomno = roomno;

    }
}

