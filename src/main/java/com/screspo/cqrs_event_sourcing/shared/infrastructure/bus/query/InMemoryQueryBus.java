package com.screspo.cqrs_event_sourcing.shared.infrastructure.bus.query;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public final class InMemoryQueryBus implements QueryBus {
    private final QueryHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryQueryBus(QueryHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
    }

    @Override
    public Response ask(Query query) throws QueryHandlerExecutionError {
        try {
            Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());
            return context.getBean(queryHandlerClass).handle(query);
        } catch (Throwable error) {
            throw new QueryHandlerExecutionError(error);
        }
    }
}
