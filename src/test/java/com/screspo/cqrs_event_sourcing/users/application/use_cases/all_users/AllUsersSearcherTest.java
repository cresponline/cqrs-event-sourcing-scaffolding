package com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users;

import com.screspo.cqrs_event_sourcing.users.application.mappers.UserMapper;
import com.screspo.cqrs_event_sourcing.users.domain.persistence.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AllUsersSearcherTest {

    @InjectMocks
    private static AllUsersSearcher allUsersSearcher;

    @Mock
    private static UsersRepository usersRepository;

    @Mock
    private static UserMapper userMapper;

    private AutoCloseable closeable;


    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        when(usersRepository.searchAll()).thenReturn(Collections.emptyList());
        when(userMapper.toResponseList(Collections.emptyList())).thenReturn(Collections.emptyList());
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void should_call_userRepository_SearchAll() {
        allUsersSearcher.search();
        verify(usersRepository).searchAll();
    }
}