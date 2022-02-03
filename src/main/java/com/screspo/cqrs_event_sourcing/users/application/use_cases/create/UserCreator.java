package com.screspo.cqrs_event_sourcing.users.application.use_cases.create;

import com.screspo.cqrs_event_sourcing.users.application.dtos.UserDTO;
import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserAlreadyExistsException;
import com.screspo.cqrs_event_sourcing.users.domain.User;
import com.screspo.cqrs_event_sourcing.users.domain.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    private final UsersRepository usersRepository;

    public UserCreator(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void create(User user) {
        usersRepository.searchAll().stream()
                .filter(u -> u.id().value().equalsIgnoreCase(user.id().value()))
                .findFirst()
                .ifPresent((u) -> {
                    throw new UserAlreadyExistsException();
                });

        usersRepository.save(user);
    }
}
