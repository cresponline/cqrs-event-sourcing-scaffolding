package com.screspo.cqrs_event_sourcing.shared.domain.events;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

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

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserCreatedDomainEvent that = (UserCreatedDomainEvent) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email);
    }
}
