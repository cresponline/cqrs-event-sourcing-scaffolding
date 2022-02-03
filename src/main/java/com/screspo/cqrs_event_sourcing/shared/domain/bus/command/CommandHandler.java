package com.screspo.cqrs_event_sourcing.shared.domain.bus.command;

public interface CommandHandler <T extends Command> {
    void handle(T command) throws Exception;
}
