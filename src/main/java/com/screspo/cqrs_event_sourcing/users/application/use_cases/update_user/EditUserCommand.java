package com.screspo.cqrs_event_sourcing.users.application.use_cases.update_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.Command;
import lombok.experimental.Accessors;
import lombok.Value;

@Value
@Accessors(fluent = true)
public class EditUserCommand extends Command {
    String id;
    String name;
    String surname;
    String email;
}
