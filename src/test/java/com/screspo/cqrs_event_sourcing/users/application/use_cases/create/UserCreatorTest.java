package com.screspo.cqrs_event_sourcing.users.application.use_cases.create;

import com.screspo.cqrs_event_sourcing.users.domain.UsersRepository;
import com.screspo.cqrs_event_sourcing.users.mothers.UsersMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class UserCreatorTest {

    @InjectMocks
    private static UserCreator userCreator;

    @Mock
    private static UsersRepository usersRepository;

    private AutoCloseable closeable;


    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        when(usersRepository.searchAll()).thenReturn(UsersMother.searchAll());
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }


//    @Test
//    void shouldCallUserRepositorySave() {
//        userCreator.create(UserDTOMother.random());
//        verify(usersRepository).save(any(User.class));
//    }
//
//    @Test
//    void mustThrowAnUserAlreadyExistsException() {
//        UserDTO existingUser = UserDTOMother.createFromUser(UsersMother.searchAll().get(0));
//        assertThrows(UserAlreadyExistsException.class,
//                () -> userCreator.create(existingUser));
//    }


}