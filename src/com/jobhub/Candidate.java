package com.jobhub;

public class Candidate extends Person {

    private String qualification;
    private int experience;
    private String[] skills;

    // Constructor
    public Candidate(int id, String name, String email, String phone,
                     String qualification, int experience, String[] skills) {

        super(id, name, email, phone);

        this.qualification = qualification;
        this.experience = experience;
        this.skills = skills;
    }
 // Overloaded constructor
    public Candidate(int id, String name, String email) {

        this(
            id,
            name,
            email,
            "Not Provided",
            "Not Provided",
            0,
            new String[0]
        );
    }
    

    // Getter
    public String getQualification() {
        return qualification;
    }

    public int getExperience() {
        return experience;
    }

    public String[] getSkills() {
        return skills;
    }

    // Method to display candidate details
    @Override
    public void displayDetails() {

        System.out.println("\n--- Candidate Details ---");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience: " + experience + " years");

        System.out.print("Skills: ");

        for (String skill : skills) {
            System.out.print(skill + " ");
        }

        System.out.println();
    }

    // Method to check eligibility
    public boolean isEligible(int requiredExperience) {

        return experience >= requiredExperience;
    }
    
    
 // Method to check whether candidate has a particular skill
    public boolean hasSkill(String skill) {

        for (String candidateSkill : skills) {

            if (candidateSkill.equalsIgnoreCase(skill)) {
                return true;
            }
        }

        return false;
    }

    // Overloaded method to check multiple skills
    public boolean hasSkill(String[] requiredSkills) {

        int matchCount = 0;

        for (String requiredSkill : requiredSkills) {

            if (hasSkill(requiredSkill)) {
                matchCount++;
            }
        }

        return matchCount > 0;
    }
}