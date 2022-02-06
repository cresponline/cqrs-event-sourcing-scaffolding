package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.delete_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandBus;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.delete.DeleteUserCommand;
import com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.UserDeleteController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

class UserDeleteControllerHappyPathTest {

    @InjectMocks
    private static UserDeleteController userDeleteController;

    @Mock
    private static CommandBus commandBus;

    private AutoCloseable closeable;


    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void should_call_command_bus_with_DeleteUserCommand_and_responds_with_ok_HttpStatusCode() {
        doNothing().when(commandBus).dispatch(any(DeleteUserCommand.class));
        ResponseEntity<Void> response = userDeleteController.index(UUID.randomUUID().toString());

        verify(commandBus).dispatch(any(DeleteUserCommand.class));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}