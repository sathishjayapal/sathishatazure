package me.sathish.sathishatazure.domain.email.service;

import lombok.extern.slf4j.Slf4j;
import me.sathish.sathishatazure.domain.JobApplication.data.JobApplication;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailService {
    public void sendRoadRegisteredEmail(JobApplication road) {
        log.info("Sending registration email to customer {}", road);
    }

    public void sendRoadRemovedEmail(JobApplication road) {
        log.info("Sending registration email to customer {}", road);
    }
}
