package com.screspo.cqrs_event_sourcing.users.application.use_cases.update_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandHandler;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserEmail;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserId;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserName;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserSurname;
import org.springframework.stereotype.Service;

@Service
public class EditUserCommandHandler implements CommandHandler<EditUserCommand> {
    private final UserEditor userEditor;

    public EditUserCommandHandler(UserEditor userEditor) {
        this.userEditor = userEditor;
    }

    @Override
    public void handle(EditUserCommand command) {
        userEditor.edit(
                new UserId(command.id()),
                new UserName(command.name()),
                new UserSurname(command.surname()),
                new UserEmail(command.email())
        );
    }
}
