package com.screspo.cqrs_event_sourcing.users.application.use_cases.all_users;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.Query;
import lombok.experimental.Accessors;
import lombok.Value;

@Value
@Accessors(fluent = true)
public final class FindUsersQuery implements Query {
}
