package com.screspo.cqrs_event_sourcing.users.application.use_cases.update_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.EventBus;
import com.screspo.cqrs_event_sourcing.users.domain.User;
import com.screspo.cqrs_event_sourcing.users.domain.UsersRepository;
import com.screspo.cqrs_event_sourcing.users.mothers.UsersMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserEditorHappyPathTest {

    @InjectMocks
    private static UserEditor userEditor;

    @Mock
    private static UsersRepository usersRepository;

    @Mock
    private static EventBus eventBus;

    private final User exist = UsersMother.exist();

    private final User random = UsersMother.random();

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        when(usersRepository.search(anyString())).thenReturn(Optional.ofNullable(exist));
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void should_call_usersRepository_delete_and_publish() {
        userEditor.edit(exist.id(), random.name(), random.surname(), random.email());
        verify(usersRepository).save(any(User.class));
        verify(eventBus).publish(anyList());
    }

}