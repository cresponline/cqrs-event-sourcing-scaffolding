package com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserSearcherHappyPathTest {

    @InjectMocks
    private static UserSearcher userSearcher;

    @Mock
    private static UsersRepository usersRepository;

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
    void should_find_an_existing_user_in_usersRepository_search() {
        UserResponse user = userSearcher.search(exist.id());
        verify(usersRepository).search(anyString());
        assertEquals(user.id(), exist.id().value());
    }

}