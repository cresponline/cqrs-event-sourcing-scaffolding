package com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user;

import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserNotFoundException;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserId;
import com.screspo.cqrs_event_sourcing.users.domain.persistence.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSearcher {

    private final UsersRepository usersRepository;

    public UserSearcher(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserResponse search(UserId id) {
        return usersRepository.search(id.value())
                .map(UserResponse::fromAggregate)
                .orElseThrow(UserNotFoundException::new);
    }
}
