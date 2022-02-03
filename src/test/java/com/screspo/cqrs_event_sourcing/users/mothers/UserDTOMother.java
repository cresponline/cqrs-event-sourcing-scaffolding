package com.screspo.cqrs_event_sourcing.users.mothers;

import com.screspo.cqrs_event_sourcing.users.application.dtos.UserDTO;
import com.screspo.cqrs_event_sourcing.users.domain.User;

public class UserDTOMother {
    public static UserDTO create(String id, String name, String surname, String email) {
        return new UserDTO(id, name, surname, email);
    }

    public static UserDTO random() {
        return create("UserDTOMother-id", "UserDTOMother-name", "UserDTOMother-surname", "UserDTOMother@email.com");
    }

    public static UserDTO createFromUser(User user) {
        return create(user.id().value(), user.name().value(), user.surname().value(), user.email().value());
    }
}
