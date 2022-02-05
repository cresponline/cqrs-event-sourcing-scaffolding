package com.screspo.cqrs_event_sourcing.shared.infrastructure.bus.event;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class InMemoryEventBus implements EventBus {
    private final ApplicationEventPublisher publisher;

    public InMemoryEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(final List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event) {
        this.publisher.publishEvent(event);
    }
}
