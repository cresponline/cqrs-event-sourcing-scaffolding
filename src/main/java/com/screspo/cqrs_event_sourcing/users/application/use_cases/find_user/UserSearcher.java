package com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user;

import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserNotFoundException;
import com.screspo.cqrs_event_sourcing.users.application.mappers.UserMapper;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserId;
import com.screspo.cqrs_event_sourcing.users.domain.persistence.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSearcher {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public UserSearcher(UsersRepository usersRepository, UserMapper userMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    public UserResponse search(UserId id) {
        return usersRepository.search(id.value())
                .map(userMapper::toResponse)
                .orElseThrow(UserNotFoundException::new);
    }
}
