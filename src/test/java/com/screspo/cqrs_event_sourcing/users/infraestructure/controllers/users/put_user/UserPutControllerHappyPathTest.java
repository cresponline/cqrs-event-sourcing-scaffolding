package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.put_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.command.CommandBus;
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
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;


class UserPutControllerHappyPathTest {

    @InjectMocks
    private static UserPutController userPutController;

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
    void should_call_command_bus_with_CreateUserCommand_and_responds_with_ok_HttpStatusCode() {
        doNothing().when(commandBus).dispatch(any(EditUserCommand.class));
        ResponseEntity<Void> response = userPutController.index(userDTO, userDTO.id());

        verify(commandBus).dispatch(any(EditUserCommand.class));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}