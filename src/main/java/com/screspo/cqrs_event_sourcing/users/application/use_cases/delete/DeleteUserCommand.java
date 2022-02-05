package com.screspo.cqrs_event_sourcing.users.application.use_cases.delete;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.Command;

public class DeleteUserCommand extends Command {

    private final String id;

    public DeleteUserCommand(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    public String getId() {
        return id;
    }
}
