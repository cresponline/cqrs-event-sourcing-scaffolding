package com.screspo.cqrs_event_sourcing.users.domain.value_objects;

import com.screspo.cqrs_event_sourcing.shared.domain.value_objects.Identifier;

public class UserId extends Identifier {
    public UserId(String value) {
        super(value);
    }

    public UserId() {
    }
}
