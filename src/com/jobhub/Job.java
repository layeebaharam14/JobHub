package com.jobhub;

public class Job {

    private int jobId;
    private String title;
    private String description;
    private String location;
    private double salary;
    private int requiredExperience;
    private String[] requiredSkills;
    private Recruiter recruiter;

    // Constructor
    public Job(int jobId, String title, String description,
               String location, double salary, int requiredExperience,
               String[] requiredSkills, Recruiter recruiter) {

        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.requiredExperience = requiredExperience;
        this.requiredSkills = requiredSkills;
        this.recruiter = recruiter;
    }
    
 // Overloaded constructor
    public Job(int jobId, String title, String location, double salary) {

        this(
            jobId,
            title,
            "No description provided",
            location,
            salary,
            0,
            new String[0],
            null
        );
    }

    // Getters
    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public double getSalary() {
        return salary;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public String[] getRequiredSkills() {
        return requiredSkills;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    // Method to display job details
    public void displayJobDetails() {

        System.out.println("\n========== JOB DETAILS ==========");
        System.out.println("Job ID: " + jobId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Location: " + location);
        System.out.println("Salary: ₹" + salary);
        System.out.println("Required Experience: " + requiredExperience + " years");

        System.out.print("Required Skills: ");

        for (String skill : requiredSkills) {
            System.out.print(skill + " ");
        }

        System.out.println();

        if (recruiter != null) {
            System.out.println("Posted By: " + recruiter.getName());
        }

        System.out.println("=================================");
    }

    // Method to check whether a candidate matches the job
    public boolean isCandidateSuitable(Candidate candidate) {

        if (candidate.getExperience() < requiredExperience) {
            return false;
        }

        int matchingSkills = 0;

        for (String candidateSkill : candidate.getSkills()) {

            for (String requiredSkill : requiredSkills) {

                if (candidateSkill.equalsIgnoreCase(requiredSkill)) {
                    matchingSkills++;
                    break;
                }
            }
        }

        return matchingSkills > 0;
    }
    
 // Demonstrates explicit type casting
    public int getSalaryAsInteger() {

        return (int) salary;
    }
}