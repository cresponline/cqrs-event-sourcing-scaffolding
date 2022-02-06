package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.get_users;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.QueryBus;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users.FindUsersQuery;
import com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users.UsersResponse;
import com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users.UsersGetController;
import com.screspo.cqrs_event_sourcing.users.mothers.UsersResponseMother;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UsersGetControllerHappyPathTest {

    @InjectMocks
    private static UsersGetController usersGetController;

    @Mock
    private static QueryBus queryBus;

    private AutoCloseable closeable;

    UsersResponse usersResponse = UsersResponseMother.create();

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void should_call_query_bus_with_FindUsersQuery_and_responds_with_ok_HttpStatusCode() {
        when(queryBus.ask(any(FindUsersQuery.class))).thenReturn(usersResponse);

        ResponseEntity<UsersResponse> usersResponse = usersGetController.index();

        assertEquals(HttpStatus.OK, usersResponse.getStatusCode());
        verify(queryBus).ask(any(FindUsersQuery.class));
    }

}