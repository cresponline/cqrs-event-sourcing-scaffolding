package com.screspo.cqrs_event_sourcing.users.application.use_cases.update_user;

import com.screspo.cqrs_event_sourcing.users.application.dtos.UserDTO;
import com.screspo.cqrs_event_sourcing.users.domain.UsersRepository;
import com.screspo.cqrs_event_sourcing.users.mothers.UserDTOMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserEditorTest {

    @InjectMocks
    private static UserEditor userEditor;

    @Mock
    private static UsersRepository usersRepository;

    final UserDTO userDTO = UserDTOMother.random();

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
//    void mustThrowAnUserNotFoundException() {
//        when(usersRepository.search(anyString())).thenReturn(Optional.empty());
//        assertThrows(UserNotFoundException.class,
//                () -> userEditor.edit(userDTO));
//    }
}