package com.screspo.cqrs_event_sourcing.users.mothers;

import com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users.UsersResponse;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.UserResponse;
import com.screspo.cqrs_event_sourcing.users.domain.User;

import java.util.List;

public class UsersResponseMother {

    public static UsersResponse create() {
        List<User> users = UsersMother.searchAll();
        List<UserResponse> responses = users.stream()
                .map(u -> new UserResponse(
                        u.id().value(),
                        u.name().value(),
                        u.surname().value(),
                        u.email().value()
                ))
                .toList();
        return new UsersResponse(responses);
    }
}
