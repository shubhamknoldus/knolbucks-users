package com.knoldus.knolbucks.model.requestModels;

public class AddUser {
    public String name;
    public String empId;
    public String email;
    public String dateOfBirth;
    public String role;


    public AddUser(String name, String empId, String email, String dateOfBirth, String role) {
        this.name = name;
        this.empId = empId;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }
}
