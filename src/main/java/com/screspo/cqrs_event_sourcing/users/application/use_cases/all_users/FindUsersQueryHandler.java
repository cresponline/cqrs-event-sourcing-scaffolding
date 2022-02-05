package com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.QueryHandler;
import com.screspo.cqrs_event_sourcing.users.application.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public final class FindUsersQueryHandler implements QueryHandler<FindUsersQuery, UsersResponse> {
    private final AllUsersSearcher allUsersSearcher;

    public FindUsersQueryHandler(AllUsersSearcher allUsersSearcher) {
        this.allUsersSearcher = allUsersSearcher;
    }

    @Override
    public UsersResponse handle(FindUsersQuery query) throws UserNotFoundException {
        return allUsersSearcher.search();
    }
}
