package com.screspo.cqrs_event_sourcing.users.application.use_cases.find_user;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.Query;
import lombok.experimental.Accessors;
import lombok.Value;

@Value
@Accessors(fluent = true)
public final class FindUserQuery implements Query {
    String id;
}
