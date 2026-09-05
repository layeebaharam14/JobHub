package com.jobhub;

public class Interview {

    private int interviewId;
    private Application application;
    private String interviewDate;
    private String interviewType;
    private String interviewer;
    private String result;

    // Constructor
    public Interview(int interviewId, Application application,
                     String interviewDate, String interviewType,
                     String interviewer) {

        this.interviewId = interviewId;
        this.application = application;
        this.interviewDate = interviewDate;
        this.interviewType = interviewType;
        this.interviewer = interviewer;
        this.result = "Pending";
    }

    // Getters
    public int getInterviewId() {
        return interviewId;
    }

    public Application getApplication() {
        return application;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public String getResult() {
        return result;
    }

    // Method to update interview result
    public void updateResult(String result) {
        this.result = result;

        // Update application status based on interview result
        if (result.equalsIgnoreCase("Selected")) {
            application.updateStatus("Selected");
        } else if (result.equalsIgnoreCase("Rejected")) {
            application.updateStatus("Rejected");
        }
    }

    // Method to display interview details
    public void displayInterviewDetails() {

        System.out.println("\n====== INTERVIEW DETAILS ======");
        System.out.println("Interview ID: " + interviewId);
        System.out.println("Candidate: "
                + application.getCandidate().getName());
        System.out.println("Job: "
                + application.getJob().getTitle());
        System.out.println("Date: " + interviewDate);
        System.out.println("Type: " + interviewType);
        System.out.println("Interviewer: " + interviewer);
        System.out.println("Result: " + result);
        System.out.println("================================");
    }
}