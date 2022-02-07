package com.screspo.cqrs_event_sourcing.shared.application;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEventSubscriber;
import com.screspo.cqrs_event_sourcing.shared.domain.store.EventStoreRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@DomainEventSubscriber({DomainEvent.class})
public final class StoreDomainEventOnOccurred {
    private final EventStoreRepository store;

    public StoreDomainEventOnOccurred(EventStoreRepository store) {
        this.store = store;
    }

    @EventListener
    public void on(DomainEvent event) {
        store.save(event);
    }
}
