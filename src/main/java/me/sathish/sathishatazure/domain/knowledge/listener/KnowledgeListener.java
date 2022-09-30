package me.sathish.sathishatazure.domain.knowledge.listener;

import lombok.RequiredArgsConstructor;
import me.sathish.sathishatazure.domain.JobApplication.events.JobAppliedEvent;
import me.sathish.sathishatazure.domain.knowledge.service.KowledgeService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class KnowledgeListener {
    private final KowledgeService knowledgeService;

    @TransactionalEventListener
    public void onRegisterEvent(JobAppliedEvent event) {
        knowledgeService.sendRoadRegisteredKnowledge(event.getJobApplication());
    }

    @EventListener
    public void onCustomerRemovedEvent(JobAppliedEvent event) {
        knowledgeService.sendRoadRemovedKnowledge(event.getJobApplication());
    }
}
