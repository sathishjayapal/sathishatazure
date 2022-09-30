package me.sathish.sathishatazure.domain.JobApplication.data;

import org.springframework.stereotype.Component;

@Component
public class JobApplicationDataMapper {
    public JobApplicationDTO toDTO(JobApplication jobApplication) {
        JobApplicationDTO jobApplicationDTO = new JobApplicationDTO(jobApplication.getJobCompanyName(),
                jobApplication.getJobDescription(), jobApplication.getJobURL(),
                jobApplication.getResumeURL(), jobApplication.getCreatedAt());
        return jobApplicationDTO;
    }
}
