package me.sathish.sathishatazure.domain.JobApplication.data;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Data
@Table(name = "jobapplications")
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {
    @Id
    @SequenceGenerator(name = "job_id_seq_gen", sequenceName = "job_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_id_seq_gen")
    private Long id;
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Company Name cannot be empty")
    private String jobCompanyName;
    @Column
    @NotEmpty(message = "Job Description cannot be empty")
    private String jobDescription;
    @NotEmpty(message = "Job URL cannot be empty")
    @Column(nullable = false)
    private String jobURL;
    @NotEmpty(message = "Resume URL cannot be empty")
    @Column(nullable = false)
    private String resumeURL;

    private Instant createdAt;
}
