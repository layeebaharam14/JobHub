package com.jobhub;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        JobPortal portal = new JobPortal();

        System.out.println("========================================");
        System.out.println("          WELCOME TO JOBHUB");
        System.out.println("   Job & Recruitment Management System");
        System.out.println("========================================");

        boolean running = true;

        while (running) {

            System.out.println("\n--------------- MENU ----------------");
            System.out.println("1. Candidate Registration");
            System.out.println("2. Recruiter Registration");
            System.out.println("3. Post a Job");
            System.out.println("4. View Available Jobs");
            System.out.println("5. Search Jobs");
            System.out.println("6. Apply for a Job");
            System.out.println("7. View Applications");
            System.out.println("8. Schedule Interview");
            System.out.println("9. View Interviews");
            System.out.println("10. Update Application Status");
            System.out.println("11. View Statistics");
            System.out.println("0. Exit");
            System.out.println("-------------------------------------");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            case 1: {

                System.out.println("\n====== CANDIDATE REGISTRATION ======");

                System.out.print("Enter Candidate ID: ");
                int candidateId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Name: ");
                String candidateName = scanner.nextLine();

                System.out.print("Enter Email: ");
                String candidateEmail = scanner.nextLine();

                System.out.print("Enter Phone: ");
                String candidatePhone = scanner.nextLine();

                System.out.print("Enter Qualification: ");
                String qualification = scanner.nextLine();

                System.out.print("Enter Years of Experience: ");
                int experience = scanner.nextInt();
                scanner.nextLine();

                if (!InputValidator.isNonNegative(experience)) {
                    System.out.println("Experience cannot be negative.");
                    break;
                }

                System.out.print("Enter number of skills: ");
                int skillCount = scanner.nextInt();
                scanner.nextLine();

                if (!InputValidator.isPositive(skillCount)) {
                    System.out.println("Number of skills must be greater than 0.");
                    break;
                }

                String[] skills = new String[skillCount];

                for (int i = 0; i < skillCount; i++) {
                    System.out.print("Enter Skill " + (i + 1) + ": ");
                    skills[i] = scanner.nextLine();
                }

                Candidate candidate = new Candidate(
                        candidateId,
                        candidateName,
                        candidateEmail,
                        candidatePhone,
                        qualification,
                        experience,
                        skills
                );

                portal.addCandidate(candidate);

                System.out.println("\nCandidate registered successfully!");

                break;
            } 
                

            case 2: {

                System.out.println("\n====== RECRUITER REGISTRATION ======");

                System.out.print("Enter Recruiter ID: ");
                int recruiterId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Recruiter Name: ");
                String recruiterName = scanner.nextLine();

                System.out.print("Enter Email: ");
                String recruiterEmail = scanner.nextLine();

                System.out.print("Enter Phone: ");
                String recruiterPhone = scanner.nextLine();

                System.out.print("Enter Designation: ");
                String designation = scanner.nextLine();

                System.out.println("\n--- Company Details ---");

                System.out.print("Enter Company ID: ");
                int companyId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Company Name: ");
                String companyName = scanner.nextLine();

                System.out.print("Enter Company Location: ");
                String companyLocation = scanner.nextLine();

                System.out.print("Enter Industry: ");
                String industry = scanner.nextLine();

                // Create Company object
                Company company = new Company(
                        companyId,
                        companyName,
                        companyLocation,
                        industry
                );

                // Create Recruiter object
                Recruiter recruiter = new Recruiter(
                        recruiterId,
                        recruiterName,
                        recruiterEmail,
                        recruiterPhone,
                        designation,
                        company
                );

                portal.addRecruiter(recruiter);

                System.out.println("\nRecruiter registered successfully!");

                break;
            }
                
            case 3: {

                System.out.println("\n========== POST A JOB ==========");

                if (portal.getRecruiterCount() == 0) {
                    System.out.println("No recruiters registered yet.");
                    System.out.println("Please register a recruiter first.");
                    break;
                }

                System.out.print("Enter Job ID: ");
                int jobId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Job Title: ");
                String jobTitle = scanner.nextLine();

                System.out.print("Enter Job Description: ");
                String jobDescription = scanner.nextLine();

                System.out.print("Enter Job Location: ");
                String jobLocation = scanner.nextLine();

                System.out.print("Enter Annual Salary (in ₹): ");
                double salary = scanner.nextDouble();

                if (!InputValidator.isValidSalary(salary)) {
                    System.out.println("Salary must be greater than 0.");
                    break;
                }

                System.out.print("Enter Required Experience (years): ");
                int requiredExperience = scanner.nextInt();

                if (!InputValidator.isNonNegative(requiredExperience)) {
                    System.out.println("Experience cannot be negative.");
                    break;
                }

                scanner.nextLine();

                System.out.print("Enter number of required skills: ");
                int skillCount = scanner.nextInt();
                scanner.nextLine();

                if (!InputValidator.isPositive(skillCount)) {
                    System.out.println("Number of required skills must be greater than 0.");
                    break;
                }

                String[] requiredSkills = new String[skillCount];

                for (int i = 0; i < skillCount; i++) {

                    System.out.print("Enter Required Skill " + (i + 1) + ": ");
                    requiredSkills[i] = scanner.nextLine();
                }

                System.out.println("\n--- Select Recruiter ---");

                portal.displayAllRecruiters();

                System.out.print("Enter Recruiter ID: ");
                int recruiterId = scanner.nextInt();
                scanner.nextLine();

                Recruiter recruiter = portal.findRecruiterById(recruiterId);

                if (recruiter != null) {

                    Job job = new Job(
                            jobId,
                            jobTitle,
                            jobDescription,
                            jobLocation,
                            salary,
                            requiredExperience,
                            requiredSkills,
                            recruiter
                    );

                    portal.addJob(job);

                    recruiter.postJob(job);

                } else {

                    System.out.println("Recruiter not found.");
                }

                break;
            }


                case 4: {
                    portal.displayAllJobs();
                    break;
                }

                case 5: {

                    System.out.println("\n========== SEARCH JOBS ==========");

                    System.out.print("Enter job title or keyword: ");
                    String keyword = scanner.nextLine();

                    portal.searchJobs(keyword);

                    break;
                }

                case 6: {

                    System.out.println("\n========== APPLY FOR A JOB ==========");

                    if (portal.getCandidateCount() == 0) {
                        System.out.println("No candidates registered.");
                        break;
                    }

                    if (portal.getJobCount() == 0) {
                        System.out.println("No jobs available.");
                        break;
                    }

                    System.out.println("\n--- Registered Candidates ---");
                    portal.displayAllCandidates();

                    System.out.print("\nEnter Candidate ID: ");
                    int candidateId = scanner.nextInt();
                    scanner.nextLine();

                    Candidate candidate = portal.findCandidateById(candidateId);

                    if (candidate == null) {
                        System.out.println("Candidate not found.");
                        break;
                    }

                    System.out.println("\n--- Available Jobs ---");
                    portal.displayAllJobs();

                    System.out.print("\nEnter Job ID: ");
                    int jobId = scanner.nextInt();
                    scanner.nextLine();

                    Job job = portal.findJobById(jobId);

                    if (job == null) {
                        System.out.println("Job not found.");
                        break;
                    }

                    System.out.print("Enter Application Date: ");
                    String applicationDate = scanner.nextLine();

                    portal.applyForJob(candidate, job, applicationDate);

                    break;
                }

                case 7: {

                    System.out.println("\n========== ALL APPLICATIONS ==========");

                    portal.displayAllApplications();

                    break;
                }

                case 8: {

                    System.out.println("\n========== SCHEDULE INTERVIEW ==========");

                    if (portal.getApplicationCount() == 0) {
                        System.out.println("No applications available.");
                        break;
                    }

                    portal.displayAllApplications();

                    System.out.print("\nEnter Application ID: ");
                    int applicationId = scanner.nextInt();
                    scanner.nextLine();

                    Application application =
                            portal.findApplicationById(applicationId);

                    if (application == null) {
                        System.out.println("Application not found.");
                        break;
                    }

                    System.out.print("Enter Interview Date: ");
                    String interviewDate = scanner.nextLine();

                    System.out.print("Enter Interview Type (Online/Offline): ");
                    String interviewType = scanner.nextLine();

                    System.out.print("Enter Interviewer Name: ");
                    String interviewer = scanner.nextLine();

                    portal.scheduleInterview(
                            application,
                            interviewDate,
                            interviewType,
                            interviewer
                    );

                    break;
                }

                case 9: {

                    System.out.println("\n========== ALL INTERVIEWS ==========");

                    portal.displayAllInterviews();

                    break;
                }

                case 10: {

                    System.out.println("\n====== UPDATE APPLICATION STATUS ======");

                    if (portal.getApplicationCount() == 0) {
                        System.out.println("No applications available.");
                        break;
                    }

                    portal.displayAllApplications();

                    System.out.print("\nEnter Application ID: ");
                    int applicationId = scanner.nextInt();
                    scanner.nextLine();

                    Application application =
                            portal.findApplicationById(applicationId);

                    if (application == null) {
                        System.out.println("Application not found.");
                        break;
                    }

                    System.out.println("\nSelect New Status:");
                    System.out.println("1. Shortlisted");
                    System.out.println("2. Rejected");
                    System.out.println("3. Selected");

                    System.out.print("Enter choice: ");
                    int statusChoice = scanner.nextInt();
                    scanner.nextLine();

                    String newStatus="";

                    switch (statusChoice) {

                        case 1:
                            newStatus = "Shortlisted";
                            break;

                        case 2:
                            newStatus = "Rejected";
                            break;

                        case 3:
                            newStatus = "Selected";
                            break;

                        default:
                            System.out.println("Invalid status choice.");
                            break;
                    }

                    if (statusChoice >= 1 && statusChoice <= 3) {

                        application.updateStatus(newStatus);

                        System.out.println(
                                "Application status updated to: " + newStatus
                        );
                    }

                    break;
                }
                
                case 11: {
                	
                	portal.displayStatistics();
                	
                	break;
                }

                case 0:
                    running = false;
                    System.out.println("\nThank you for using JobHub!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}