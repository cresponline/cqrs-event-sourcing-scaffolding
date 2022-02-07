package com.screspo.cqrs_event_sourcing.users.domain.value_objects;

import com.screspo.cqrs_event_sourcing.shared.domain.value_objects.StringValueObject;

public class UserEmail extends StringValueObject {
    public UserEmail(String value) {
        super(value);
    }

    public UserEmail() {
        super("");
    }
}
