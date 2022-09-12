package me.sathish.sathishatazure.domain.knowledge.service;

import lombok.extern.slf4j.Slf4j;
import me.sathish.sathishatazure.domain.road.data.Road;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KowledgeService {
    public void sendRoadRegisteredKnowledge(Road road) {
        log.info("Sending knowledge to road {}", road);
    }

    public void sendRoadRemovedKnowledge(Road road) {
        log.info("Sending knowledge to customer {}", road);
    }
}
