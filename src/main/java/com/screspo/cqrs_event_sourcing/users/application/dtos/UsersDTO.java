package com.screspo.cqrs_event_sourcing.users.application.dtos;

import java.util.List;

public class UsersDTO {

    private final List<UserDTO> users;

    public UsersDTO(List<UserDTO> users) {
        this.users = users;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

}
