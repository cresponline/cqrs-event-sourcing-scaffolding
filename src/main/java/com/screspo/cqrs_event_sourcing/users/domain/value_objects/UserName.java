package com.screspo.cqrs_event_sourcing.users.domain.value_objects;

import com.screspo.cqrs_event_sourcing.shared.domain.value_objects.StringValueObject;

public class UserName extends StringValueObject {
    public UserName(String value) {
        super(value);
    }

    public UserName() {
        super("");
    }
}
