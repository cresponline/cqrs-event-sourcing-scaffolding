package com.screspo.cqrs_event_sourcing.users.application.use_cases.create;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.Command;

public class CreateUserCommand extends Command {

    private final String id;
    private final String name;
    private final String surname;
    private final String email;

    public CreateUserCommand(String id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }
}
