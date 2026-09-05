package com.jobhub;

public class Company {

    private int companyId;
    private String name;
    private String location;
    private String industry;

    // Constructor
    public Company(int companyId, String name, String location, String industry) {
        this.companyId = companyId;
        this.name = name;
        this.location = location;
        this.industry = industry;
    }

    // Getters
    public int getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getIndustry() {
        return industry;
    }

    // Method to display company details
    public void displayCompanyDetails() {

        System.out.println("\n--- Company Details ---");
        System.out.println("Company ID: " + companyId);
        System.out.println("Company Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Industry: " + industry);
    }
}