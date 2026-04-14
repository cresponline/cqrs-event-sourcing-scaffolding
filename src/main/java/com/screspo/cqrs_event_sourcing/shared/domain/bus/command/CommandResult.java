package com.screspo.cqrs_event_sourcing.shared.domain.bus.command;

public sealed interface CommandResult permits CommandResult.Success, CommandResult.NotFound, CommandResult.AlreadyExists {
    record Success(String id) implements CommandResult {}
    record NotFound(String id) implements CommandResult {}
    record AlreadyExists(String email) implements CommandResult {}
}
