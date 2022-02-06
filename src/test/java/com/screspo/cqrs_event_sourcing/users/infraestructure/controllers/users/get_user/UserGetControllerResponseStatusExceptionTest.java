package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.get_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.QueryBus;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.QueryHandlerExecutionError;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.FindUserQuery;
import com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.UserGetController;
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

class UserGetControllerResponseStatusExceptionTest {

    @InjectMocks
    private static UserGetController userGetController;

    @Mock
    private static QueryBus queryBus;

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
    void should_responds_with_ResponseStatusException_with_No_Content_HttpStatusCode_when_QueryHandlerExecutionError() {
        doThrow(QueryHandlerExecutionError.class).when(queryBus).ask(any(FindUserQuery.class));

        ResponseStatusException responseStatusException = assertThrows(ResponseStatusException.class,
                () -> userGetController.index(UUID.randomUUID().toString()));
        assertEquals(HttpStatus.NO_CONTENT, responseStatusException.getStatus());
    }

}