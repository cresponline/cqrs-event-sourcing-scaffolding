package com.screspo.cqrs_event_sourcing.users.application.use_cases.delete;

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

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserRemoverHappyPathTest {

    @InjectMocks
    private static UserRemover userRemover;

    @Mock
    private static UsersRepository usersRepository;

    @Mock
    private static EventBus eventBus;

    private final User exist = UsersMother.exist();

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
        userRemover.remove(exist.id());
        verify(usersRepository).delete(anyString());
        verify(eventBus).publish(anyList());
    }

}