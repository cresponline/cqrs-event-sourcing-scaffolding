package com.screspo.cqrs_event_sourcing.users.domain;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.DomainEvent;
import com.screspo.cqrs_event_sourcing.users.domain.events.UserCreatedDomainEvent;
import com.screspo.cqrs_event_sourcing.users.domain.events.UserEditedDomainEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserEventReplayTest {

    @Test
    void shouldReconstructUserFromCreatedEvent() {
        String id = "f47ac10b-58cc-4372-a567-0e02b2c3d479";
        String name = "John";
        String surname = "Doe";
        String email = "john.doe@example.com";

        DomainEvent event = new UserCreatedDomainEvent(id, name, surname, email);

        User user = User.fromEvent(event);

        assertNotNull(user);
        assertEquals(id, user.id().value());
        assertEquals(name, user.name().value());
        assertEquals(surname, user.surname().value());
        assertEquals(email, user.email().value());
    }

    @Test
    void shouldReconstructUserFromEditedEvent() {
        String id = "f47ac10b-58cc-4372-a567-0e02b2c3d479";
        String editedName = "Jane";
        String editedSurname = "Smith";
        String editedEmail = "jane.smith@example.com";

        DomainEvent event = new UserEditedDomainEvent(id, editedName, editedSurname, editedEmail);

        User user = User.fromEvent(event);

        assertNotNull(user);
        assertNull(user.id());
        assertEquals(editedName, user.name().value());
        assertEquals(editedSurname, user.surname().value());
        assertEquals(editedEmail, user.email().value());
    }

    @Test
    void shouldThrowExceptionForUnsupportedEvent() {
        DomainEvent unsupportedEvent = new DomainEvent("id") {
            @Override
            public String eventName() {
                return "unsupported";
            }

            @Override
            public java.util.HashMap<String, java.io.Serializable> toPrimitives() {
                return new java.util.HashMap<>();
            }

            @Override
            public DomainEvent fromPrimitives(String aggregateId, java.util.HashMap<String, java.io.Serializable> body, String eventId, String occurredOn) {
                return this;
            }
        };

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> User.fromEvent(unsupportedEvent)
        );
        assertTrue(exception.getMessage().contains("Unsupported event type"));
    }
}
