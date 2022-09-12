package me.sathish.sathishatazure.domain.email.service;

import lombok.extern.slf4j.Slf4j;
import me.sathish.sathishatazure.domain.road.data.Road;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailService {
    public void sendRoadRegisteredEmail(Road road) {
        log.info("Sending registration email to customer {}", road);
    }

    public void sendRoadRemovedEmail(Road road) {
        log.info("Sending registration email to customer {}", road);
    }
}
