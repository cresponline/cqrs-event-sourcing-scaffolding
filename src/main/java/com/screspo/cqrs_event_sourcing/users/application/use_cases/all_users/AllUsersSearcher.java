package com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users;

import com.screspo.cqrs_event_sourcing.shared.domain.events.EventStoreRepository;
import com.screspo.cqrs_event_sourcing.users.application.dtos.UserDTO;
import com.screspo.cqrs_event_sourcing.users.application.dtos.UsersDTO;
import com.screspo.cqrs_event_sourcing.users.domain.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AllUsersSearcher {

    private final UsersRepository userRepository;

    private final EventStoreRepository eventStoreRepository;

    public AllUsersSearcher(UsersRepository usersRepository, EventStoreRepository eventStoreRepository) {
        this.userRepository = usersRepository;
        this.eventStoreRepository = eventStoreRepository;
    }

    public UsersDTO search() {
        System.out.println(eventStoreRepository.fetch());
        return new UsersDTO(userRepository.searchAll()
                .stream()
                .map(UserDTO::fromAggregate)
                .collect(Collectors.toList()));
    }
}
