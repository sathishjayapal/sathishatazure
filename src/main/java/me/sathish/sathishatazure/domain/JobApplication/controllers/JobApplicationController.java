package me.sathish.sathishatazure.domain.JobApplication.controllers;

import lombok.AllArgsConstructor;
import me.sathish.sathishatazure.domain.JobApplication.data.JobApplication;
import me.sathish.sathishatazure.domain.JobApplication.data.JobApplicationDTO;
import me.sathish.sathishatazure.domain.JobApplication.service.JobApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class JobApplicationController {
    private static final Logger logger = LoggerFactory.getLogger(JobApplicationController.class);
    JobApplicationService jobApplicationService;

    @GetMapping
    public JobApplicationDTO index(Integer page) {
        if (page == null)
            page = 0;
        else
            page = page < 1 ? 0 : page - 1;
        logger.debug("Coming to index");
        JobApplicationDTO allAppliedJobs = jobApplicationService.getAllAppliedJobs(page);
        System.out.println("All jobs are " + allAppliedJobs);
        return allAppliedJobs;
    }

    @PostMapping("/createJobApplication")
    @ResponseStatus(HttpStatus.CREATED)
    public JobApplication createJobApplicationEntry(@RequestBody @Valid JobApplication request) {
        return jobApplicationService.createJobApplicationRecord(request);
    }

}
