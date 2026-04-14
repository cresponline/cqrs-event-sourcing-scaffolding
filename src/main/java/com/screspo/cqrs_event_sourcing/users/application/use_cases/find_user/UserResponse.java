package com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.Response;
import lombok.experimental.Accessors;
import lombok.Value;

@Value
@Accessors(fluent = true)
public final class UserResponse implements Response {
    String id;
    String name;
    String surname;
    String email;
}
