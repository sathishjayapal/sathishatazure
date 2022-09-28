package me.sathish.sathishatazure.domain.JobApplication.events;

import lombok.Data;
import me.sathish.sathishatazure.domain.JobApplication.data.JobApplication;

@Data
public class JobAppliedEvent {
    private final JobApplication jobApplication;
}
