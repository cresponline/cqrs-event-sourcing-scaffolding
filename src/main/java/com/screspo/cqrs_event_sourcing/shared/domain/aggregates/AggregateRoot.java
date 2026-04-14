package com.screspo.cqrs_event_sourcing.shared.domain.aggregates;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public abstract class AggregateRoot {
    private List<DomainEvent> domainEvents = new ArrayList<>();

    final public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = domainEvents;

        domainEvents = Collections.emptyList();

        return events;
    }

    final protected void record(DomainEvent event) {
        domainEvents.add(event);
    }
}
