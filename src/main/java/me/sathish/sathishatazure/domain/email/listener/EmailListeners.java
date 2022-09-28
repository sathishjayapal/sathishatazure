package me.sathish.sathishatazure.domain.email.listener;

import lombok.RequiredArgsConstructor;
import me.sathish.sathishatazure.domain.JobApplication.events.JobAppliedEvent;
import me.sathish.sathishatazure.domain.email.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class EmailListeners {
    private final EmailService emailService;

    @TransactionalEventListener
    public void onRegisterEvent(JobAppliedEvent event) {
        emailService.sendRoadRegisteredEmail(event.getJobApplication());
    }

    @EventListener
    public void onCustomerRemovedEvent(JobAppliedEvent event) {
        emailService.sendRoadRemovedEmail(event.getJobApplication());
    }
}
