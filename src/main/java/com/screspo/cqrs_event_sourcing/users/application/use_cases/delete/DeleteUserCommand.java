package com.screspo.cqrs_event_sourcing.users.application.use_cases.delete;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.Command;
import lombok.experimental.Accessors;
import lombok.Value;

@Value
@Accessors(fluent = true)
public class DeleteUserCommand extends Command {
    String id;
}
