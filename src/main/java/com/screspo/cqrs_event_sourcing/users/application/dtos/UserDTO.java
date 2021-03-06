package com.screspo.cqrs_event_sourcing.users.application.dtos;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.Response;

public class UserDTO implements Response {
    private final String id;
    private final String name;
    private final String surname;
    private final String email;

    public UserDTO(String id, String name, String surname, String email) {
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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }


}
