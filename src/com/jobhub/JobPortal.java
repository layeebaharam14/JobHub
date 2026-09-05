package com.jobhub;

public class JobPortal {

    // Arrays of objects
    private Candidate[] candidates;
    private Recruiter[] recruiters;
    private Job[] jobs;
    private Application[] applications;
    private Interview[] interviews;

    // Counters
    private int candidateCount;
    private int recruiterCount;
    private int jobCount;
    private int applicationCount;
    private int interviewCount;

    // Constructor
    public JobPortal() {

        candidates = new Candidate[50];
        recruiters = new Recruiter[20];
        jobs = new Job[50];
        applications = new Application[100];
        interviews = new Interview[100];

        candidateCount = 0;
        recruiterCount = 0;
        jobCount = 0;
        applicationCount = 0;
        interviewCount = 0;
    }

    // Add Candidate
    public void addCandidate(Candidate candidate) {

        if (candidateCount < candidates.length) {
            candidates[candidateCount] = candidate;
            candidateCount++;

            System.out.println("Candidate added successfully!");
        } else {
            System.out.println("Candidate storage is full.");
        }
    }

    // Add Recruiter
    public void addRecruiter(Recruiter recruiter) {

        if (recruiterCount < recruiters.length) {
            recruiters[recruiterCount] = recruiter;
            recruiterCount++;

            System.out.println("Recruiter added successfully!");
        } else {
            System.out.println("Recruiter storage is full.");
        }
    }

    // Add Job
    public void addJob(Job job) {

        if (jobCount < jobs.length) {
            jobs[jobCount] = job;
            jobCount++;

            System.out.println("Job posted successfully!");
        } else {
            System.out.println("Job storage is full.");
        }
    }

    // Display all jobs
    public void displayAllJobs() {

        if (jobCount == 0) {
            System.out.println("No jobs available.");
            return;
        }

        System.out.println("\n========== AVAILABLE JOBS ==========");

        for (int i = 0; i < jobCount; i++) {
            jobs[i].displayJobDetails();
            System.out.println(
                    "Salary as Integer: ₹"
                    + jobs[i].getSalaryAsInteger()
            );
        }
    }

    // Search jobs by title
    public void searchJobs(String keyword) {

        boolean found = false;

        System.out.println("\n========== SEARCH RESULTS ==========");

        for (int i = 0; i < jobCount; i++) {

            if (jobs[i].getTitle().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                jobs[i].displayJobDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching jobs found.");
        }
    }

    // Apply for a job
    public void applyForJob(Candidate candidate, Job job,
                            String applicationDate) {

        if (job.isCandidateSuitable(candidate)) {

            if (applicationCount < applications.length) {

                Application application =
                        new Application(
                                applicationCount + 1,
                                candidate,
                                job,
                                applicationDate
                        );

                applications[applicationCount] = application;
                applicationCount++;

                System.out.println(
                        "Application submitted successfully!"
                );

            } else {
                System.out.println("Application storage is full.");
            }

        } else {
            System.out.println(
                    "Candidate does not meet the job requirements."
            );
        }
    }

    // Display all applications
    public void displayAllApplications() {

        if (applicationCount == 0) {
            System.out.println("No applications found.");
            return;
        }

        System.out.println("\n====== ALL APPLICATIONS ======");

        for (int i = 0; i < applicationCount; i++) {
            applications[i].displayApplicationDetails();
        }
    }

    // Schedule interview
    public void scheduleInterview(
            Application application,
            String date,
            String type,
            String interviewer) {

        if (interviewCount < interviews.length) {

            Interview interview =
                    new Interview(
                            interviewCount + 1,
                            application,
                            date,
                            type,
                            interviewer
                    );

            interviews[interviewCount] = interview;
            interviewCount++;

            application.updateStatus("Interview Scheduled");

            System.out.println(
                    "Interview scheduled successfully!"
            );

        } else {
            System.out.println("Interview storage is full.");
        }
    }

    // Display all interviews
    public void displayAllInterviews() {

        if (interviewCount == 0) {
            System.out.println("No interviews scheduled.");
            return;
        }

        System.out.println("\n====== ALL INTERVIEWS ======");

        for (int i = 0; i < interviewCount; i++) {
            interviews[i].displayInterviewDetails();
        }
    }

    // Display portal statistics
    public void displayStatistics() {

        System.out.println("\n========== JOBHUB STATISTICS ==========");

        System.out.println("Total Candidates: " + candidateCount);
        System.out.println("Total Recruiters: " + recruiterCount);
        System.out.println("Total Jobs: " + jobCount);
        System.out.println("Total Applications: " + applicationCount);
        System.out.println("Total Interviews: " + interviewCount);

        System.out.println(
                "Total Persons Created: "
                + Person.getPersonCount()
        );

        System.out.println("========================================");
    }
    
 // Get number of registered recruiters
    public int getRecruiterCount() {
        return recruiterCount;
    }

    // Display all recruiters
    public void displayAllRecruiters() {

        if (recruiterCount == 0) {
            System.out.println("No recruiters registered.");
            return;
        }

        for (int i = 0; i < recruiterCount; i++) {

            System.out.println("\nRecruiter ID: "
                    + recruiters[i].getId());

            System.out.println("Name: "
                    + recruiters[i].getName());

            System.out.println("Designation: "
                    + recruiters[i].getDesignation());

            System.out.println("Company: "
                    + recruiters[i].getCompany().getName());
        }
    }

    // Find recruiter using ID
    public Recruiter findRecruiterById(int recruiterId) {

        for (int i = 0; i < recruiterCount; i++) {

            if (recruiters[i].getId() == recruiterId) {
                return recruiters[i];
            }
        }

        return null;
    }
    
 // Get number of registered candidates
    public int getCandidateCount() {
        return candidateCount;
    }

    // Find candidate using ID
    public Candidate findCandidateById(int candidateId) {

        for (int i = 0; i < candidateCount; i++) {

            if (candidates[i].getId() == candidateId) {
                return candidates[i];
            }
        }

        return null;
    }

    // Find job using ID
    public Job findJobById(int jobId) {

        for (int i = 0; i < jobCount; i++) {

            if (jobs[i].getJobId() == jobId) {
                return jobs[i];
            }
        }

        return null;
    }
    
 // Get number of available jobs
    public int getJobCount() {
        return jobCount;
    }

    // Display all candidates
    public void displayAllCandidates() {

        if (candidateCount == 0) {
            System.out.println("No candidates registered.");
            return;
        }

        for (int i = 0; i < candidateCount; i++) {
            candidates[i].displayDetails();
        }
    }
    
 // Get number of applications
    public int getApplicationCount() {
        return applicationCount;
    }

    // Find application using ID
    public Application findApplicationById(int applicationId) {

        for (int i = 0; i < applicationCount; i++) {

            if (applications[i].getApplicationId() == applicationId) {
                return applications[i];
            }
        }

        return null;
    }
}