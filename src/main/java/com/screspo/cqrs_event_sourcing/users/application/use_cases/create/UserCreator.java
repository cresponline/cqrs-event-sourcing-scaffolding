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

    public void create(UserDTO userDTO) {
        usersRepository.searchAll().stream()
                .filter(user -> user.id().equalsIgnoreCase(userDTO.id()))
                .findFirst()
                .ifPresent((user) -> {
                    throw new UserAlreadyExistsException();
                });

        usersRepository.save(userFromDto(userDTO));
    }

    private User userFromDto(UserDTO userDTO) {
        return new User.Builder()
                .id(userDTO.id())
                .name(userDTO.name())
                .surname(userDTO.surname())
                .email(userDTO.email())
                .build();
    }
}
