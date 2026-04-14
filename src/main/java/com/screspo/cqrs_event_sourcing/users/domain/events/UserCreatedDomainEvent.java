package com.screspo.cqrs_event_sourcing.users.domain.events;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@Accessors(fluent = true)
public final class UserCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final String surname;
    private final String email;

    public UserCreatedDomainEvent() {
        super(null);

        this.name = null;
        this.surname = null;
        this.email = null;
    }

    public UserCreatedDomainEvent(String aggregateId, String name, String surname, String email) {
        super(aggregateId);

        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public UserCreatedDomainEvent(
            String aggregateId,
            String eventId,
            String occurredOn,
            String name,
            String surname,
            String email
    ) {
        super(aggregateId, eventId, occurredOn);

        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String eventName() {
        return "user.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{
            put("name", name);
            put("surname", surname);
            put("email", email);
        }};
    }

    @Override
    public UserCreatedDomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    ) {
        return new UserCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (String) body.get("surname"),
                (String) body.get("email")
        );
    }
}
