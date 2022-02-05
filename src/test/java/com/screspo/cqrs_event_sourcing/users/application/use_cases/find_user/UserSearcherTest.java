package com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user;

import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserNotFoundException;
import com.screspo.cqrs_event_sourcing.users.domain.UserId;
import com.screspo.cqrs_event_sourcing.users.domain.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserSearcherTest {

    @InjectMocks
    private static UserSearcher userSearcher;

    @Mock
    private static UsersRepository usersRepository;

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
    void searchMustThrowAnUserNotFoundException() {
        when(usersRepository.search(anyString())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,
                () -> userSearcher.search(new UserId(UUID.randomUUID().toString())));
        verify(usersRepository).search(anyString());
    }

}