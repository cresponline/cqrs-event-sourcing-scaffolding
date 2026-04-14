package com.screspo.cqrs_event_sourcing.users.domain.value_objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserEmailValidationTest {

    @Test
    void shouldCreateValidEmail() {
        assertDoesNotThrow(() -> new UserEmail("test@example.com"));
    }

    @Test
    void shouldThrowExceptionForInvalidEmailWithoutAt() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new UserEmail("invalid-email")
        );
        assertTrue(exception.getMessage().contains("Invalid email format"));
    }

    @Test
    void shouldThrowExceptionForInvalidEmailWithoutDomain() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new UserEmail("test@")
        );
        assertTrue(exception.getMessage().contains("Invalid email format"));
    }

    @Test
    void shouldThrowExceptionForNullEmail() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new UserEmail(null)
        );
        assertTrue(exception.getMessage().contains("Invalid email format"));
    }
}
