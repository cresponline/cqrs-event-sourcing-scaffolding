package com.screspo.cqrs_event_sourcing.users.mothers;

import com.screspo.cqrs_event_sourcing.users.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class UsersMother {
    public static List<User> searchAll() {
        List<User> users = new ArrayList<>();
        User user1 = new User.Builder()
                .id(new UserId("ed7b640c-045a-42e0-b0c5-752a63328caf"))
                .name(new UserName("user1"))
                .surname(new UserSurname("one"))
                .email(new UserEmail("user_one@email.com"))
                .build();

        users.add(user1);

        User user2 = new User.Builder()
                .id(new UserId("958eeab1-7344-4e02-8448-0ebb531673a9"))
                .name(new UserName("user2"))
                .surname(new UserSurname("two"))
                .email(new UserEmail("user_two@email.com"))

                .build();

        users.add(user2);

        return users;
    }

    public static User random() {

        return new User.Builder()
                .id(new UserId(UUID.randomUUID().toString()))
                .name(new UserName("user_random"))
                .surname(new UserSurname("random"))
                .email(new UserEmail("random@email.com"))

                .build();
    }

    public static User exist() {
        List<User> users = searchAll();
        return users.get(new Random().nextInt(users.size()));
    }
}
