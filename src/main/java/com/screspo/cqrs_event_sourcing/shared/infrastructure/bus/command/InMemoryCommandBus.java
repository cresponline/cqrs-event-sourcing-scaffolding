package com.screspo.cqrs_event_sourcing.shared.infrastructure.bus.command;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.Command;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandBus;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandHandlerExecutionError;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            context.getBean(information.search(command.getClass())).handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}
