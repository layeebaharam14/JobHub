# JobHub — Job & Recruitment Management System

A console-based Job and Recruitment Management System developed using Core Java.

## 📌 Project Overview

JobHub is a Core Java application that simulates a basic recruitment workflow. It allows candidates and recruiters to be registered, companies and job opportunities to be managed, applications to be submitted, interviews to be scheduled, and application statuses to be updated.

The project is designed to demonstrate fundamental Java programming and Object-Oriented Programming concepts through a practical real-world application.

## ✨ Features

- 👤 Candidate Registration
- 🏢 Recruiter Registration
- 🏭 Company Management
- 💼 Job Posting
- 🔎 Job Search
- 📝 Job Application
- 📄 Application Management
- 🎤 Interview Scheduling
- 📋 Interview Management
- 🔄 Application Status Updates
- 📊 Recruitment Statistics
- ✅ Input Validation

## 🛠️ Technologies Used

- Java
- JDK 23
- Eclipse IDE
- Core Java
- Console / CLI

No database, framework, or external API is required.

---

## 🧠 Core Java Concepts Demonstrated

| Concept | Implementation |
|---|---|
| Classes & Objects | All project classes |
| Encapsulation | Private fields with getters |
| Inheritance | Candidate and Recruiter extend Person |
| Abstraction | Person is an abstract class |
| Polymorphism | Overridden displayDetails() |
| Constructors | All major classes |
| Constructor Overloading | Candidate and Job |
| Method Overloading | Candidate.hasSkill() |
| Static Members | Person.personCount |
| Arrays | Skills and object storage |
| Loops | Array processing and searching |
| Conditional Statements | Validation and eligibility |
| Switch | Main menu |
| Strings | Names, skills, search and status |
| Type Casting | Salary conversion |
| Methods | Business operations |
| Input Validation | InputValidator |

---

## 🏗️ Project Structure

```text
JobHub/
│
├── src/
│   └── com/jobhub/
│       ├── Application.java
│       ├── Candidate.java
│       ├── Company.java
│       ├── InputValidator.java
│       ├── Interview.java
│       ├── Job.java
│       ├── JobPortal.java
│       ├── Main.java
│       ├── Person.java
│       └── Recruiter.java
│
├── Documentation/
│   └── JobHub_Project_Report.docx
│
└── README.md

```
---

## 🔄 Application Workflow

```
Candidate / Recruiter Registration
              ↓
         Company Setup
              ↓
          Job Posting
              ↓
       View / Search Jobs
              ↓
       Candidate Applies
              ↓
       Eligibility Checking
              ↓
       Application Created
              ↓
       Interview Scheduled
              ↓
      Application Status
              ↓
          Statistics
```
---

## 👥 Main Classes

**Person:**
Abstract base class containing common personal information.

**Candidate:**
Stores candidate qualification, experience and skills. Also performs skill checking.

**Recruiter:**
Stores recruiter information and maintains a relationship with a company.

**Company:**
Stores company name, location and industry information.

**Job:**
Stores job details, salary, required experience and required skills.

**Application:**
Connects a candidate with a job and maintains application status.

**Interview:**
Stores interview information and is associated with an application.

**JobPortal:**
Acts as the central management class and maintains candidates, recruiters, jobs, applications and interviews using arrays.

**InputValidator:**
Provides reusable static methods for validating input values.

**Main:**
Provides the menu-driven console interface.

---

## ✅ Eligibility Logic

A candidate can apply for a job when:
1. The candidate's experience is greater than or equal to the required experience.
2. At least one candidate skill matches a required job skill.
   
Skill comparison is case-insensitive.

---

## ▶️ How to Run

**Prerequisites**
- JDK 23 or compatible Java Development Kit
- Eclipse IDE

**Steps**
1. Open Eclipse IDE.
2. Import or open the JobHub project.
3. Open: src → com.jobhub → Main.java
4. Right-click Main.java.
5. Select: Run As → Java Application
6. Use the menu displayed in the console.

   
### 📋 Application Menu

```
1. Candidate Registration
2. Recruiter Registration
3. Post a Job
4. View Available Jobs
5. Search Jobs
6. Apply for a Job
7. View Applications
8. Schedule Interview
9. View Interviews
10. Update Application Status
11. View Statistics
0. Exit
```

### 🧪 Testing

The complete workflow was successfully tested:
- Candidate registration
- Recruiter registration
- Company registration
- Job posting
- Job search
- Job application
- Application viewing
- Interview scheduling
- Interview viewing
- Application status update
- Statistics
- Program exit
  
**Sample Final Statistics**
```
Total Candidates: 1
Total Recruiters: 1
Total Jobs: 1
Total Applications: 1
Total Interviews: 1
Total Persons Created: 2
```

---

## 🚀 Future Enhancements

- Database integration using MySQL
- Java Collections such as ArrayList
- User authentication
- Role-based access
- Advanced job filtering
- Email notifications
- Graphical user interface
- Web-based version
- Recruitment analytics
- Persistent data storage

---

## 👩‍💻 Author

**Layeeba Haram**

Core Java Training Project
2026
