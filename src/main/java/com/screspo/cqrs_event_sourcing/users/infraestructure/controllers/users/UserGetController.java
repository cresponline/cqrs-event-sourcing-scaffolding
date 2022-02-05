package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.QueryBus;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.QueryHandlerExecutionError;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.FindUserQuery;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/users/{id}")
public class UserGetController {

    private final QueryBus queryBus;

    public UserGetController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping
    public ResponseEntity<UserResponse> index(@PathVariable String id) {
        try {
            return ResponseEntity.ok(queryBus.ask(new FindUserQuery(id)));
        } catch (QueryHandlerExecutionError e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
