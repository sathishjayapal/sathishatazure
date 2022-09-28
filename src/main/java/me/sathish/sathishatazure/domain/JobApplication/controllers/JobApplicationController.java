package me.sathish.sathishatazure.domain.JobApplication.controllers;

import lombok.AllArgsConstructor;
import me.sathish.sathishatazure.domain.JobApplication.data.JobApplication;
import me.sathish.sathishatazure.domain.JobApplication.service.JobApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class JobApplicationController {
    private static final Logger logger = LoggerFactory.getLogger(JobApplicationController.class);
    JobApplicationService jobApplicationService;

    @GetMapping
    public List<JobApplication> index() {
        logger.debug("Coming to index");
        List<JobApplication> allAppliedJobs = jobApplicationService.getAllAppliedJobs();
        System.out.println("All jobs are " + allAppliedJobs.size());
        return allAppliedJobs;
    }

    @PostMapping("/createJobApplication")
    @ResponseStatus(HttpStatus.CREATED)
    public JobApplication createJobApplicationEntry(@RequestBody @Valid JobApplication request) {
        return jobApplicationService.createJobApplicationRecord(request);
    }

}
