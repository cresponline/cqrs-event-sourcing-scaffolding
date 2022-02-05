package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users;


import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandBus;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandHandlerExecutionError;
import com.screspo.cqrs_event_sourcing.users.application.dtos.UserDTO;
import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserAlreadyExistsException;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.create.CreateUserCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(value = "/users")
public class UserPostController {

    private final CommandBus commandBus;

    public UserPostController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping
    public ResponseEntity<Void> index(@RequestBody UserDTO userDTO) {
        try {
            commandBus.dispatch(new CreateUserCommand(userDTO.id(), userDTO.name(), userDTO.surname(), userDTO.email()));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (CommandHandlerExecutionError e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

}
