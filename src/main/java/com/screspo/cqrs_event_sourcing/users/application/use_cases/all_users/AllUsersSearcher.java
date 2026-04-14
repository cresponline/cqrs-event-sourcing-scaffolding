package com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users;

import com.screspo.cqrs_event_sourcing.users.application.mappers.UserMapper;
import com.screspo.cqrs_event_sourcing.users.domain.persistence.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class AllUsersSearcher {

    private final UsersRepository userRepository;
    private final UserMapper userMapper;

    public AllUsersSearcher(UsersRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UsersResponse search() {
        return new UsersResponse(userMapper.toResponseList(userRepository.searchAll()));
    }
}
