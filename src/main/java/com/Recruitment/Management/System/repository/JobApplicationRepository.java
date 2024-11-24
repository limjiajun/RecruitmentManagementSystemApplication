package com.Recruitment.Management.System.repository;

import java.util.List;

import com.Recruitment.Management.System.model.Job;
import com.Recruitment.Management.System.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByJob(Job job);
    boolean existsByJobIdAndUserId(Long jobId, Long userId);
}

