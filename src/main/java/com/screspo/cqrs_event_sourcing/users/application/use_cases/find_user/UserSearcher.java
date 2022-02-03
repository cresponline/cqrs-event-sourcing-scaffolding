package com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user;

import com.screspo.cqrs_event_sourcing.users.application.dtos.UserDTO;
import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserNotFoundException;
import com.screspo.cqrs_event_sourcing.users.domain.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSearcher {

    private final UsersRepository usersRepository;

    public UserSearcher(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserDTO search(String id) {
        return usersRepository.search(id)
                .map(UserDTO::fromAggregate)
                .orElseThrow(UserNotFoundException::new);
    }
}
