package com.screspo.cqrs_event_sourcing.users.mothers;

import com.screspo.cqrs_event_sourcing.users.domain.*;

import java.util.ArrayList;
import java.util.List;

public class UsersMother {
    public static List<User> searchAll() {
        List<User> users = new ArrayList<>();
        User user1 = new User.Builder()
                .id(new UserId("user1-id"))
                .name(new UserName("user1"))
                .surname(new UserSurname("one"))
                .email(new UserEmail("user_one@email.com"))
                .build();

        users.add(user1);

        User user2 = new User.Builder()
                .id(new UserId("user2-id"))
                .name(new UserName("user2"))
                .surname(new UserSurname("two"))
                .email(new UserEmail("user_two@email.com"))

                .build();

        users.add(user2);

        return users;
    }
}
