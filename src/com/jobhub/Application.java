package com.jobhub;

public class Application {

    private int applicationId;
    private Candidate candidate;
    private Job job;
    private String applicationDate;
    private String status;

    // Constructor
    public Application(int applicationId, Candidate candidate, Job job,
                       String applicationDate) {

        this.applicationId = applicationId;
        this.candidate = candidate;
        this.job = job;
        this.applicationDate = applicationDate;
        this.status = "Applied";
    }

    // Getters
    public int getApplicationId() {
        return applicationId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public Job getJob() {
        return job;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    // Method to update application status
    public void updateStatus(String status) {
        this.status = status;
    }

    // Method to display application details
    public void displayApplicationDetails() {

        System.out.println("\n====== APPLICATION DETAILS ======");
        System.out.println("Application ID: " + applicationId);
        System.out.println("Candidate: " + candidate.getName());
        System.out.println("Job: " + job.getTitle());
        System.out.println("Company: "
                + job.getRecruiter().getCompany().getName());
        System.out.println("Application Date: " + applicationDate);
        System.out.println("Status: " + status);
        System.out.println("=================================");
    }
}