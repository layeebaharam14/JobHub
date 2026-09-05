package com.jobhub;

public abstract class Person {

    // Encapsulated data members
    private int id;
    private String name;
    private String email;
    private String phone;

    // Static member
    private static int personCount = 0;

    // Constructor
    public Person(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;

        personCount++;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Static method
    public static int getPersonCount() {
        return personCount;
    }

    // Abstract method
    public abstract void displayDetails();
}