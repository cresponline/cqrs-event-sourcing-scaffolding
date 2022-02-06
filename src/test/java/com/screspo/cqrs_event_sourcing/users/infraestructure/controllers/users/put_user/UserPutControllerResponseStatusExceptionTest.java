package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.put_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandBus;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandHandlerExecutionError;
import com.screspo.cqrs_event_sourcing.users.application.dtos.UserDTO;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.update_user.EditUserCommand;
import com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.UserPutController;
import com.screspo.cqrs_event_sourcing.users.mothers.UserDTOMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

class UserPutControllerResponseStatusExceptionTest {

    @InjectMocks
    private static UserPutController userPutController;

    @Mock
    private static CommandBus commandBus;

    private final UserDTO userDTO = UserDTOMother.random();

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
    void should_responds_with_ResponseStatusException_with_No_content_HttpStatusCode_when_CommandHandlerExecutionError() {
        doThrow(CommandHandlerExecutionError.class).when(commandBus).dispatch(any(EditUserCommand.class));

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> userPutController.index(userDTO, userDTO.id()));

        assertEquals(HttpStatus.NO_CONTENT, exception.getStatus());
    }
}