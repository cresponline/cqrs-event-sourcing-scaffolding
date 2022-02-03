package com.screspo.cqrs_event_sourcing.shared.domain.bus.command;

public interface CommandBus {
    void handle(Command command) throws Exception;
}
