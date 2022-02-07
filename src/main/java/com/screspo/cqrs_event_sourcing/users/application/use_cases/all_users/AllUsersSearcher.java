package com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users;

import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.UserResponse;
import com.screspo.cqrs_event_sourcing.users.domain.persistence.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AllUsersSearcher {

    private final UsersRepository userRepository;

    public AllUsersSearcher(UsersRepository usersRepository) {
        this.userRepository = usersRepository;

    }

    public UsersResponse search() {
        return new UsersResponse(userRepository.searchAll()
                .stream()
                .map(UserResponse::fromAggregate)
                .collect(Collectors.toList()));
    }
}
