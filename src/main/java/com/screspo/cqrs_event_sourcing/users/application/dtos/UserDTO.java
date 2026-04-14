package com.screspo.cqrs_event_sourcing.users.application.dtos;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.Response;
import lombok.experimental.Accessors;
import lombok.Value;

@Value
@Accessors(fluent = true)
public class UserDTO implements Response {
    String id;
    String name;
    String surname;
    String email;
}
