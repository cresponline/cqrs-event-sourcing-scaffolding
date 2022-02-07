package com.screspo.cqrs_event_sourcing.users.application.use_cases.create;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.EventBus;
import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserAlreadyExistsException;
import com.screspo.cqrs_event_sourcing.users.domain.*;
import com.screspo.cqrs_event_sourcing.users.domain.persistence.UsersRepository;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserEmail;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserId;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserName;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserSurname;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    private final EventBus eventBus;
    private final UsersRepository usersRepository;

    public UserCreator(UsersRepository usersRepository, EventBus eventBus) {
        this.eventBus = eventBus;
        this.usersRepository = usersRepository;
    }

    public void create(UserId id, UserName name, UserSurname surname, UserEmail email) {
        usersRepository.searchAll().stream()
                .filter(u -> u.id().value().equalsIgnoreCase(id.value()))
                .findFirst()
                .ifPresent((u) -> {
                    throw new UserAlreadyExistsException();
                });

        User user = new User.Builder()
                .id(id)
                .name(name)
                .surname(surname)
                .email(email)
                .build();

        usersRepository.save(user);
        eventBus.publish(user.pullDomainEvents());
    }
}
