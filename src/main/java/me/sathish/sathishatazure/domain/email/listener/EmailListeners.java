package me.sathish.sathishatazure.domain.email.listener;

import lombok.RequiredArgsConstructor;
import me.sathish.sathishatazure.domain.email.service.EmailService;
import me.sathish.sathishatazure.domain.road.events.RoadRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class EmailListeners {
    private final EmailService emailService;

    @TransactionalEventListener
    public void onRegisterEvent(RoadRegisteredEvent event) {
        emailService.sendRoadRegisteredEmail(event.getRegisteredRoad());
    }

    @EventListener
    public void onCustomerRemovedEvent(RoadRegisteredEvent event) {
        emailService.sendRoadRemovedEmail(event.getRegisteredRoad());
    }
}
