package com.Recruitment.Management.System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Recruitment.Management.System.model.Job;
import com.Recruitment.Management.System.model.JobApplication;
import com.Recruitment.Management.System.model.User;
import com.Recruitment.Management.System.repository.JobApplicationRepository;
import com.Recruitment.Management.System.repository.UserRepository;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;

    @Autowired
    public JobApplicationService(JobApplicationRepository jobApplicationRepository, UserRepository userRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.userRepository = userRepository;
    }
    public List<JobApplication> getAllApplications() {
        return jobApplicationRepository.findAll();
    }
    public boolean isUserAlreadyApplied(Long jobId, Long userId) {
        return jobApplicationRepository.existsByJobIdAndUserId(jobId, userId);
    }

    public void applyForJob(Job job, Optional<User> user) {
        if (user.isPresent()) {
            // Check if the user has already applied
            if (jobApplicationRepository.existsByJobIdAndUserId(job.getId(), user.get().getId())) {
                throw new IllegalArgumentException("User has already applied for this job");
            }
    
            // Create a new job application
            JobApplication application = new JobApplication();
            application.setJob(job);
            application.setUser(user.get());
            application.setStatus(JobApplication.ApplicationStatus.PENDING);
            
            // Save the job application
            jobApplicationRepository.save(application);
        } else {
            throw new IllegalArgumentException("User is not present");
        }
    }
    
    
    public void changeApplicationStatus(Long applicationId, JobApplication.ApplicationStatus status) {
        // Find the application by ID
        JobApplication jobApplication = jobApplicationRepository.findById(applicationId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid application ID: " + applicationId));
    
        // Set the new status
        jobApplication.setStatus(status);
    
        // Save the updated application
        jobApplicationRepository.save(jobApplication);
    }
    
}