package com.knoldus.knolbucks.model.dbModels;

public class User {
    private String id;
    private String name;
    private String empId;
    private String email;

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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String id, String name, String empId, String email) {
        this.id = id;
        this.name = name;
        this.empId = empId;
        this.email = email;
    }
}
