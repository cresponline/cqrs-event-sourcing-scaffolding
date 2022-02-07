package com.screspo.cqrs_event_sourcing.shared.domain.store;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;

public interface EventStoreRepository {
    void save(DomainEvent domainEvent);
}
