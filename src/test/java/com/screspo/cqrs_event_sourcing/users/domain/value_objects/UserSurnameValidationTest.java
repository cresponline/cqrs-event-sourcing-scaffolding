package com.screspo.cqrs_event_sourcing.users.domain.value_objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserSurnameValidationTest {

    @Test
    void shouldCreateValidSurname() {
        assertDoesNotThrow(() -> new UserSurname("Doe"));
    }

    @Test
    void shouldThrowExceptionForNullSurname() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new UserSurname(null)
        );
        assertTrue(exception.getMessage().contains("cannot be null or blank"));
    }

    @Test
    void shouldThrowExceptionForBlankSurname() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new UserSurname("")
        );
        assertTrue(exception.getMessage().contains("cannot be null or blank"));
    }

    @Test
    void shouldThrowExceptionForSurnameExceedingMaxLength() {
        String longSurname = "a".repeat(101);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new UserSurname(longSurname)
        );
        assertTrue(exception.getMessage().contains("cannot exceed"));
    }
}
