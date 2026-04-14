package com.screspo.cqrs_event_sourcing.users.application.dtos;

import lombok.experimental.Accessors;
import lombok.Value;

import java.util.List;

@Value
@Accessors(fluent = true)
public class UsersDTO {
    List<UserDTO> users;
}
