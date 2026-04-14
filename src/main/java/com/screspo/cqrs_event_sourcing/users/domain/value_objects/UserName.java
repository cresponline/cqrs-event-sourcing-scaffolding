package com.screspo.cqrs_event_sourcing.users.domain.value_objects;

import com.screspo.cqrs_event_sourcing.shared.domain.value_objects.StringValueObject;

public class UserName extends StringValueObject {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 50;

    public UserName(String value) {
        super(value);
        ensureValidName(value);
    }

    public UserName() {
        super("");
    }

    private void ensureValidName(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Name cannot exceed " + MAX_LENGTH + " characters");
        }
    }
}
