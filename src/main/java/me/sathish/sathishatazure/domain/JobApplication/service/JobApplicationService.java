package me.sathish.sathishatazure.domain.JobApplication.service;

import lombok.RequiredArgsConstructor;
import me.sathish.sathishatazure.domain.JobApplication.Exception.JobApplicationDataException;
import me.sathish.sathishatazure.domain.JobApplication.data.JobApplication;
import me.sathish.sathishatazure.domain.JobApplication.data.JobApplicationDTO;
import me.sathish.sathishatazure.domain.JobApplication.events.JobAppliedEvent;
import me.sathish.sathishatazure.domain.JobApplication.repo.JobApplicationRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional(readOnly = true)
    public JobApplicationDTO getAllAppliedJobs(Integer page) {
        Pageable pageable = PageRequest.of(page, 2, Sort.Direction.DESC, "createdAt");
        return new JobApplicationDTO(jobApplicationRepository.findAll(pageable));

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
