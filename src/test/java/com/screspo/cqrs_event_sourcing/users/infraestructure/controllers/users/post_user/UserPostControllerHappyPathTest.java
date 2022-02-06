package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.post_user;


import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandBus;
import com.screspo.cqrs_event_sourcing.users.application.dtos.UserDTO;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.create.CreateUserCommand;
import com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.UserPostController;
import com.screspo.cqrs_event_sourcing.users.mothers.UserDTOMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

class UserPostControllerHappyPathTest {

    @InjectMocks
    private static UserPostController userPostController;

    @Mock
    private static CommandBus commandBus;

    private AutoCloseable closeable;

    private final UserDTO userDTO = UserDTOMother.random();

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }


    @Test
    void should_call_command_bus_with_CreateUserCommand_and_responds_with_Created_HttpStatusCode() {
        doNothing().when(commandBus).dispatch(any(CreateUserCommand.class));
        ResponseEntity<Void> response = userPostController.index(userDTO);

        verify(commandBus).dispatch(any(CreateUserCommand.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}