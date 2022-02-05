package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandBus;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandHandlerExecutionError;
import com.screspo.cqrs_event_sourcing.users.application.dtos.UserDTO;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.update_user.EditUserCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/users/{id}")
public class UserPutController {

    private final CommandBus commandBus;

    public UserPutController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }


    @PutMapping
    public ResponseEntity<Void> index(@RequestBody UserDTO userDTO, @PathVariable String id) {
        try {
            if (!id.equalsIgnoreCase(userDTO.id())) throw new ResponseStatusException(HttpStatus.CONFLICT);
            commandBus.dispatch(new EditUserCommand(userDTO.id(), userDTO.name(), userDTO.surname(), userDTO.email()));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CommandHandlerExecutionError e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
