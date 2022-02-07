package com.screspo.cqrs_event_sourcing.users.domain.value_objects;

import com.screspo.cqrs_event_sourcing.shared.domain.value_objects.StringValueObject;

public class UserSurname extends StringValueObject {
    public UserSurname(String value) {
        super(value);
    }

    public UserSurname() {
        super("");
    }
}
