package com.screspo.cqrs_event_sourcing.users.application.use_cases.update_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.EventBus;
import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserNotFoundException;
import com.screspo.cqrs_event_sourcing.users.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserEditor {

    private final EventBus eventBus;
    private final UsersRepository usersRepository;

    public UserEditor(UsersRepository usersRepository, EventBus eventBus) {
        this.usersRepository = usersRepository;
        this.eventBus = eventBus;
    }


    public void edit(UserId id, UserName name, UserSurname surname, UserEmail email) {
        User user = usersRepository.search(id.value()).orElseThrow(
                () -> {
                    throw new UserNotFoundException();
                });
        User edited = user.edit(user.id(), name, surname, email);
        usersRepository.save(edited);
        eventBus.publish(edited.pullDomainEvents());
    }
}
