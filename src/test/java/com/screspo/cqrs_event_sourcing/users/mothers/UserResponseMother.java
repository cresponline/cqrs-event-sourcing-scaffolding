package com.screspo.cqrs_event_sourcing.users.mothers;

import com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users.UsersResponse;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.UserResponse;

import java.util.Random;

public class UserResponseMother {

    public static UserResponse random() {
        UsersResponse usersResponse = UsersResponseMother.create();
        return usersResponse.getUsers().get(new Random().nextInt(usersResponse.getUsers().size()));
    }
}
