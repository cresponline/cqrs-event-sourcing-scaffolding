package com.screspo.cqrs_event_sourcing.users.domain.value_objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNameValidationTest {

    @Test
    void shouldCreateValidName() {
        assertDoesNotThrow(() -> new UserName("John"));
    }

    @Test
    void shouldThrowExceptionForNullName() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new UserName(null)
        );
        assertTrue(exception.getMessage().contains("cannot be null or blank"));
    }

    @Test
    void shouldThrowExceptionForBlankName() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new UserName("   ")
        );
        assertTrue(exception.getMessage().contains("cannot be null or blank"));
    }

    @Test
    void shouldThrowExceptionForNameExceedingMaxLength() {
        String longName = "a".repeat(51);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new UserName(longName)
        );
        assertTrue(exception.getMessage().contains("cannot exceed"));
    }
}
