package me.sathish.sathishatazure.domain.JobApplication.service;

import lombok.RequiredArgsConstructor;
import me.sathish.sathishatazure.domain.JobApplication.Exception.JobApplicationDataException;
import me.sathish.sathishatazure.domain.JobApplication.data.JobApplication;
import me.sathish.sathishatazure.domain.JobApplication.events.JobAppliedEvent;
import me.sathish.sathishatazure.domain.JobApplication.repo.JobApplicationRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional(readOnly = true)
    public List<JobApplication> getAllAppliedJobs() {
        return jobApplicationRepository.findAll();
    }

    @Transactional
    public JobApplication createJobApplicationRecord(JobApplication jobApplication) {
        jobApplicationRepository.save(jobApplication);
        publisher.publishEvent(new JobAppliedEvent(jobApplication));
        return jobApplication;
    }

    @Transactional
    public JobApplication getJobApplicationByID(Long id) {
        return jobApplicationRepository.findById(id)
                .orElseThrow(() -> new JobApplicationDataException(id));
    }
}
