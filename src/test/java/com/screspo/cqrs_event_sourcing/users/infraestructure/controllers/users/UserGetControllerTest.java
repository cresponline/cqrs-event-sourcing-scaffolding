package com.screspo.cqrs_event_sourcing.users.infraestructure.controllers.users;

import com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user.UserSearcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

class UserGetControllerTest {

    @InjectMocks
    private static UserGetController userGetController;

    @Mock
    private static UserSearcher userSearcher;

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
//    void mustThrowResponseStatusExceptionWhenUserNotFound() {
//        UserId id = new UserId(UUID.randomUUID().toString());
//        doThrow(UserNotFoundException.class)
//                .when(userSearcher)
//                .search(id);
//
//        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
//                () -> userGetController.index(id.value()));
//
//        assertEquals(HttpStatus.NO_CONTENT, exception.getStatus());
//    }

//    @Test
//    void shouldRespondsWithOkHttpStatusCode() {
//        when(userSearcher.search(userDto.id())).thenReturn(userDto);
//        ResponseEntity<UserDTO> userDTOResponseEntity = userGetController.index("a");
//        assertEquals(HttpStatus.OK, userDTOResponseEntity.getStatusCode());
//    }
}