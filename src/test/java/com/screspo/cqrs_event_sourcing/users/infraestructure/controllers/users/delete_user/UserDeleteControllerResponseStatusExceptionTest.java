package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.delete_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandBus;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandHandlerExecutionError;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.delete.DeleteUserCommand;
import com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.UserDeleteController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

class UserDeleteControllerResponseStatusExceptionTest {

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
    void should_responds_with_ResponseStatusException_with_No_Content_HttpStatusCode_when_CommandHandlerExecutionError() {
        doThrow(CommandHandlerExecutionError.class).when(commandBus).dispatch(any(DeleteUserCommand.class));

        ResponseStatusException responseStatusException = assertThrows(ResponseStatusException.class,
                () -> userDeleteController.index(UUID.randomUUID().toString()));
        assertEquals(HttpStatus.NO_CONTENT, responseStatusException.getStatus());
    }

}