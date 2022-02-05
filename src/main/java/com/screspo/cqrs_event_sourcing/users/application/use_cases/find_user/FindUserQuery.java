package com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.Query;

public final class FindUserQuery implements Query {
    private final String id;

    public FindUserQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
