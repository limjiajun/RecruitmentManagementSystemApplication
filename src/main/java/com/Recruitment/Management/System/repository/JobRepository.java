package com.Recruitment.Management.System.repository;


import com.Recruitment.Management.System.model.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Page<Job> findByTitleContainingOrLocationContainingOrCompanyContainingOrSalaryRangeContaining(
            String title, String location, String company, String salaryRange, Pageable pageable);
}
