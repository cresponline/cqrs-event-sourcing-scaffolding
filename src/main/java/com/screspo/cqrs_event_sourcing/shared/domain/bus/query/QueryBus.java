package com.screspo.cqrs_event_sourcing.shared.domain.bus.query;

public interface QueryBus {
    <T> T handle(Query<T> query) throws Exception;
}
