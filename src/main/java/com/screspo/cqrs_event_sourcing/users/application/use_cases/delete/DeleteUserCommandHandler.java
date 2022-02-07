package com.screspo.cqrs_event_sourcing.users.application.use_cases.delete;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandHandler;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserId;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserCommandHandler implements CommandHandler<DeleteUserCommand> {
    private final UserRemover userRemover;

    public DeleteUserCommandHandler(UserRemover userRemover) {
        this.userRemover = userRemover;
    }

    @Override
    public void handle(DeleteUserCommand command) {
        userRemover.remove(new UserId(command.id()));
    }
}
