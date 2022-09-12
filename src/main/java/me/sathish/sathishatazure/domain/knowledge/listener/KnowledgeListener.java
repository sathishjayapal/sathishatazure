package me.sathish.sathishatazure.domain.knowledge.listener;

import lombok.RequiredArgsConstructor;
import me.sathish.sathishatazure.domain.knowledge.service.KowledgeService;
import me.sathish.sathishatazure.domain.road.events.RoadRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class KnowledgeListener {
    private final KowledgeService knowledgeService;

    @TransactionalEventListener
    public void onRegisterEvent(RoadRegisteredEvent event) {
        knowledgeService.sendRoadRegisteredKnowledge(event.getRegisteredRoad());
    }

    @EventListener
    public void onCustomerRemovedEvent(RoadRegisteredEvent event) {
        knowledgeService.sendRoadRemovedKnowledge(event.getRegisteredRoad());
    }
}
