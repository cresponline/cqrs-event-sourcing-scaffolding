package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users;


import com.screspo.cqrs_event_sourcing.users.application.dtos.UserDTO;
import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserAlreadyExistsException;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.create.UserCreator;
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

    private final UserCreator userCreator;

    public UserPostController(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @PostMapping
    public ResponseEntity<Void> index(@RequestBody UserDTO userDTO) {
        try {
//            userCreator.create(userDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

}
