package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users;

import com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users.AllUsersSearcher;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users.UsersResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/users")
public class UsersGetController {

    private final AllUsersSearcher allUsersSearcher;

    public UsersGetController(AllUsersSearcher allUsersSearcher) {
        this.allUsersSearcher = allUsersSearcher;
    }


    @GetMapping
    public ResponseEntity<UsersResponse> index() {
        return ResponseEntity.ok(allUsersSearcher.search());
    }
}
