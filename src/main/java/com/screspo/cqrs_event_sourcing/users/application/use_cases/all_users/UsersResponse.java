package com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.Response;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.UserResponse;
import lombok.experimental.Accessors;
import lombok.Value;

import java.util.List;

@Value
@Accessors(fluent = true)
public class UsersResponse implements Response {
    List<UserResponse> users;
}
