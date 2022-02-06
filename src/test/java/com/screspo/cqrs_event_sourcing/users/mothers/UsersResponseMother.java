package com.screspo.cqrs_event_sourcing.users.mothers;

import com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users.UsersResponse;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.UserResponse;

import java.util.stream.Collectors;

public class UsersResponseMother {

    public static UsersResponse create() {
        return new UsersResponse(UsersMother.searchAll().stream().map(UserResponse::fromAggregate).collect(Collectors.toList()));
    }
}
