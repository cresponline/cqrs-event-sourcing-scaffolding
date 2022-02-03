package com.screspo.cqrs_event_sourcing.users.infraestructure.persistence;

import com.screspo.cqrs_event_sourcing.users.domain.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class InMemoryUsersRepository implements UsersRepository {

    List<User> users;

    public InMemoryUsersRepository() {
        this.users = init();
    }


    @Override
    public List<User> searchAll() {
        return this.users;
    }

    @Override
    public void save(User user) {
        users = users.stream()
                .filter(u -> !user.id().value().equalsIgnoreCase(u.id().value()))
                .collect(Collectors.toList());
        users.add(user);
    }

    @Override
    public void delete(String id) {
        users = users.stream()
                .filter(user -> !user.id().value().equalsIgnoreCase(id))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> search(String id) {
        return users.stream()
                .filter(user -> user.id().value().equalsIgnoreCase(id))
                .findFirst();
    }

    private List<User> init() {
        List<User> users = new ArrayList<>();
        User user1 = new User.Builder()
                .id(new UserId(UUID.randomUUID().toString()))
                .name(new UserName("user1"))
                .surname(new UserSurname("one"))
                .email(new UserEmail("user_one@email.com"))
                .build();

        users.add(user1);

        User user2 = new User.Builder()
                .id(new UserId(UUID.randomUUID().toString()))
                .name(new UserName("user2"))
                .surname(new UserSurname("two"))
                .email(new UserEmail("user_two@email.com"))

                .build();

        users.add(user2);

        return users;
    }
}
