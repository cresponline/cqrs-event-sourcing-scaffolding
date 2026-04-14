package com.screspo.cqrs_event_sourcing.users.application.mappers;

import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.UserResponse;
import com.screspo.cqrs_event_sourcing.users.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "id", expression = "java(user.id().value())")
    @Mapping(target = "name", expression = "java(user.name().value())")
    @Mapping(target = "surname", expression = "java(user.surname().value())")
    @Mapping(target = "email", expression = "java(user.email().value())")
    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> users);
}
