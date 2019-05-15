package com.knoldus.knolbucks.model.requestModels;

public class AddUser {
    public String name;
    public String empId;
    public String email;

    public AddUser(String name, String empId, String email) {
        this.name = name;
        this.empId = empId;
        this.email = email;
    }
}
