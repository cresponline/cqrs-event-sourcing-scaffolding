package com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.Response;
import com.screspo.cqrs_event_sourcing.users.domain.User;

public final class UserResponse implements Response {
    private final String id;
    private final String name;
    private final String surname;
    private final String email;

    public UserResponse(String id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public static UserResponse fromAggregate(User user) {
        return new UserResponse(user.id().value(), user.name().value(), user.surname().value(), user.email().value());
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }


}
