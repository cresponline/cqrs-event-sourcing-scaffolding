package com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.QueryHandler;
import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserNotFoundException;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserId;
import org.springframework.stereotype.Service;

@Service
public final class FindUserQueryHandler implements QueryHandler<FindUserQuery, UserResponse> {
    private final UserSearcher userSearcher;

    public FindUserQueryHandler(UserSearcher userSearcher) {
        this.userSearcher = userSearcher;
    }

    @Override
    public UserResponse handle(FindUserQuery query) throws UserNotFoundException {
        return userSearcher.search(new UserId(query.id()));
    }
}
