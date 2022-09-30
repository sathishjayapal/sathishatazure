package me.sathish.sathishatazure.domain.JobApplication.repo;

import me.sathish.sathishatazure.domain.JobApplication.data.JobApplication;
import me.sathish.sathishatazure.domain.JobApplication.data.JobApplicationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    @Query("""
            select new me.sathish.sathishatazure.domain.JobApplication.data.JobApplicationDTO(b.jobCompanyName, b.jobDescription, b.jobURL, b.resumeURL, b.createdAt) from JobApplication b
            """)
    Page<JobApplicationDTO> findBy(Pageable pageable);
}
