package com.screspo.cqrs_event_sourcing.users.domain.value_objects;

import com.screspo.cqrs_event_sourcing.shared.domain.value_objects.StringValueObject;

public class UserEmail extends StringValueObject {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public UserEmail(String value) {
        super(value);
        ensureValidEmail(value);
    }

    public UserEmail() {
        super("");
    }

    private void ensureValidEmail(String value) {
        if (value == null || !value.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid email format: " + value);
        }
    }
}
