package com.screspo.cqrs_event_sourcing.users.application.use_cases.delete;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.EventBus;
import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserNotFoundException;
import com.screspo.cqrs_event_sourcing.users.domain.User;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserId;
import com.screspo.cqrs_event_sourcing.users.domain.persistence.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRemover {

    private final EventBus eventBus;
    private final UsersRepository usersRepository;

    public UserRemover(UsersRepository usersRepository, EventBus eventBus) {
        this.usersRepository = usersRepository;
        this.eventBus = eventBus;
    }

    public void remove(UserId id) {
        User user = usersRepository.search(id.value()).orElseThrow(
                () -> {
                    throw new UserNotFoundException();
                });
        usersRepository.delete(user.id().value());
        eventBus.publish(user.delete().pullDomainEvents());
    }
}
