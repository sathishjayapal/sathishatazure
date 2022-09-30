package me.sathish.sathishatazure.domain.JobApplication.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationDTO {
    private String jobCompanyName;
    private String jobDescription;
    private String jobURL;
    private String resumeURL;
    private Instant createdAt;
}
