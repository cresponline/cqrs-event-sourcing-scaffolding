package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users;

import com.screspo.cqrs_event_sourcing.users.application.use_cases.delete.UserRemover;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserDeleteControllerTest {

    @InjectMocks
    private static UserDeleteController userDeleteController;

    @Mock
    private static UserRemover userRemover;

    private AutoCloseable closeable;


    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

//    @Test
//    void shouldRespondsWithOkStatusCode() {
//        ResponseEntity<Void> response = userDeleteController.index(UsersMother.searchAll().get(0).id());
//        verify(userRemover).remove(anyString());
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
}