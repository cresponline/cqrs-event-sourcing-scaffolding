package com.screspo.cqrs_event_sourcing.users.domain.value_objects;

import com.screspo.cqrs_event_sourcing.shared.domain.value_objects.StringValueObject;

public class UserSurname extends StringValueObject {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 100;

    public UserSurname(String value) {
        super(value);
        ensureValidSurname(value);
    }

    public UserSurname() {
        super("");
    }

    private void ensureValidSurname(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Surname cannot be null or blank");
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Surname cannot exceed " + MAX_LENGTH + " characters");
        }
    }
}
