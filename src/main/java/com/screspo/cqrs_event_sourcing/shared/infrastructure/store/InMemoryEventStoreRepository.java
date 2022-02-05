package com.screspo.cqrs_event_sourcing.shared.infrastructure.store;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;
import com.screspo.cqrs_event_sourcing.shared.domain.events.EventStoreRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEventStoreRepository implements EventStoreRepository {

    List<DomainEvent> events = new ArrayList<>();

    @Override
    public void save(DomainEvent domainEvent) {
        events.add(domainEvent);
    }

    @Override
    public List<DomainEvent> fetch() {
        return events;
    }
}
