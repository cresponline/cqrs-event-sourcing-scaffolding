package com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.Response;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.UserResponse;

import java.util.List;

public class UsersResponse implements Response {

    private final List<UserResponse> users;

    public UsersResponse(List<UserResponse> users) {
        this.users = users;
    }

    public List<UserResponse> getUsers() {
        return users;
    }

}
