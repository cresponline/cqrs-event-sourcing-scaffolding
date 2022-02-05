package com.screspo.cqrs_event_sourcing.shared.domain.events;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;

import java.util.List;

public interface EventStoreRepository {
    void save(DomainEvent domainEvent);

    List<DomainEvent> fetch();
}
