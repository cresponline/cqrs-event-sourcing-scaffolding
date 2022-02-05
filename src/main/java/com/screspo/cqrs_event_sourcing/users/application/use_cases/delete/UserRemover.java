package com.screspo.cqrs_event_sourcing.users.application.use_cases.delete;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.EventBus;
import com.screspo.cqrs_event_sourcing.shared.domain.events.UserDeletedDomainEvent;
import com.screspo.cqrs_event_sourcing.users.domain.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserRemover {

    private final EventBus eventBus;
    private final UsersRepository usersRepository;

    public UserRemover(UsersRepository usersRepository, EventBus eventBus) {
        this.usersRepository = usersRepository;
        this.eventBus = eventBus;
    }

    public void remove(String id) {
        usersRepository.delete(id);
        eventBus.publish(Collections.singletonList(new UserDeletedDomainEvent(id)));
    }
}
