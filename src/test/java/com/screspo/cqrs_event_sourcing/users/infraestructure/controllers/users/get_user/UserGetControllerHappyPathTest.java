package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.get_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.QueryBus;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.FindUserQuery;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.UserResponse;
import com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.UserGetController;
import com.screspo.cqrs_event_sourcing.users.mothers.UserResponseMother;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserGetControllerHappyPathTest {

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
    void should_call_query_bus_with_FindUserQuery_and_responds_with_ok_HttpStatusCode() {
        UserResponse mocked = UserResponseMother.random();
        when(queryBus.ask(any(FindUserQuery.class))).thenReturn(mocked);

        ResponseEntity<UserResponse> response = userGetController.index(UUID.randomUUID().toString());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(queryBus).ask(any(FindUserQuery.class));
    }

}