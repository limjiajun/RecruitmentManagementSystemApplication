package com.Recruitment.Management.System.repository;


import com.Recruitment.Management.System.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Resume findByUserId(Long userId);
    

}
