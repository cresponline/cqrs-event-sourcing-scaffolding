package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandBus;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandHandlerExecutionError;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.delete.DeleteUserCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/users/{id}")
public class UserDeleteController {

    private final CommandBus commandBus;

    public UserDeleteController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @DeleteMapping
    public ResponseEntity<Void> index(@PathVariable String id) {
        try {
            commandBus.dispatch(new DeleteUserCommand(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CommandHandlerExecutionError e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
