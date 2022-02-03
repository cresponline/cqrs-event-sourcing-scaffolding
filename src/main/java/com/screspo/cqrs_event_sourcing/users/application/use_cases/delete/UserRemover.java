package com.screspo.cqrs_event_sourcing.users.application.use_cases.delete;

import com.screspo.cqrs_event_sourcing.users.domain.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRemover {

    private final UsersRepository usersRepository;

    public UserRemover(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void remove(String id) {
        usersRepository.delete(id);
    }
}
