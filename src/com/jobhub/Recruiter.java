package com.jobhub;

public class Recruiter extends Person {

    private String designation;
    private Company company;

    // Constructor
    public Recruiter(int id, String name, String email, String phone,
                     String designation, Company company) {

        super(id, name, email, phone);

        this.designation = designation;
        this.company = company;
    }

    // Getters
    public String getDesignation() {
        return designation;
    }

    public Company getCompany() {
        return company;
    }

    // Method to display recruiter details
    @Override
    public void displayDetails() {

        System.out.println("\n--- Recruiter Details ---");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());
        System.out.println("Designation: " + designation);

        if (company != null) {
            System.out.println("Company: " + company.getName());
        } else {
            System.out.println("Company: Not Assigned");
        }
    }

    // Method to post a job
    public void postJob(Job job) {

        System.out.println(
            getName() + " posted a new job: " + job.getTitle()
        );
    }
}