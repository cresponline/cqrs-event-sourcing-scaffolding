package com.screspo.cqrs_event_sourcing.users.application.use_cases.create;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.event.EventBus;
import com.screspo.cqrs_event_sourcing.users.domain.User;
import com.screspo.cqrs_event_sourcing.users.domain.persistence.UsersRepository;
import com.screspo.cqrs_event_sourcing.users.mothers.UsersMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserCreatorHappyPathTest {

    @InjectMocks
    private static UserCreator userCreator;

    @Mock
    private static UsersRepository usersRepository;

    @Mock
    private static EventBus eventBus;

    User user = UsersMother.random();

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


    @Test
    void should_call_usersRepository_save_and_publish() {
        userCreator.create(user.id(), user.name(), user.surname(), user.email());
        verify(usersRepository).save(any(User.class));
        verify(eventBus).publish(anyList());
    }

}