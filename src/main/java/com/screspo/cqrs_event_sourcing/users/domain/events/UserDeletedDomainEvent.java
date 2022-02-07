package com.screspo.cqrs_event_sourcing.users.domain.events;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class UserDeletedDomainEvent extends DomainEvent {

    public UserDeletedDomainEvent() {
        super(null);
    }

    public UserDeletedDomainEvent(String aggregateId) {
        super(aggregateId);
    }

    public UserDeletedDomainEvent(
            String aggregateId,
            String eventId,
            String occurredOn
    ) {
        super(aggregateId, eventId, occurredOn);
    }

    @Override
    public String eventName() {
        return "user.deleted";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {
        };
    }

    @Override
    public UserDeletedDomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    ) {
        return new UserDeletedDomainEvent(
                aggregateId,
                eventId,
                occurredOn
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDeletedDomainEvent that = (UserDeletedDomainEvent) o;
        return Objects.equals(aggregateId(), that.aggregateId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(aggregateId());
    }
}
