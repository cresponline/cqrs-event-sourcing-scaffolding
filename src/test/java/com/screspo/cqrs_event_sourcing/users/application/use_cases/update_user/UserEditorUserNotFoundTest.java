package com.screspo.cqrs_event_sourcing.users.application.use_cases.update_user;

import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserNotFoundException;
import com.screspo.cqrs_event_sourcing.users.domain.User;
import com.screspo.cqrs_event_sourcing.users.domain.persistence.UsersRepository;
import com.screspo.cqrs_event_sourcing.users.mothers.UsersMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserEditorUserNotFoundTest {

    @InjectMocks
    private static UserEditor userEditor;

    @Mock
    private static UsersRepository usersRepository;

    private final User random = UsersMother.random();

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        when(usersRepository.search(anyString())).thenReturn(Optional.empty());
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void should_throw_an_UserNotFoundException() {
        assertThrows(UserNotFoundException.class, () -> userEditor.edit(random.id(), random.name(), random.surname(), random.email()));
    }
}