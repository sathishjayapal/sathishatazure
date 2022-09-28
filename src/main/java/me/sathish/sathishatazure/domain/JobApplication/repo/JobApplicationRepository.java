package me.sathish.sathishatazure.domain.JobApplication.repo;

import me.sathish.sathishatazure.domain.JobApplication.data.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}
