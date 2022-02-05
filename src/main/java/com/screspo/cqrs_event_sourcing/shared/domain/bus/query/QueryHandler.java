package com.screspo.cqrs_event_sourcing.shared.domain.bus.query;

public interface QueryHandler<T, U extends Query<T>> {
    T handle(U query) throws Exception;
}
