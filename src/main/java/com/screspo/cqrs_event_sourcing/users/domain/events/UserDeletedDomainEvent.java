package com.screspo.cqrs_event_sourcing.users.domain.events;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@Accessors(fluent = true)
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
}
