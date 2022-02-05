package com.screspo.cqrs_event_sourcing.users.application.use_cases.create;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandHandler;
import com.screspo.cqrs_event_sourcing.users.domain.UserEmail;
import com.screspo.cqrs_event_sourcing.users.domain.UserId;
import com.screspo.cqrs_event_sourcing.users.domain.UserName;
import com.screspo.cqrs_event_sourcing.users.domain.UserSurname;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {
    private final UserCreator userCreator;

    public CreateUserCommandHandler(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @Override
    public void handle(CreateUserCommand command) {
        userCreator.create(
                new UserId(command.id()),
                new UserName(command.name()),
                new UserSurname(command.surname()),
                new UserEmail(command.email())
        );
    }
}
