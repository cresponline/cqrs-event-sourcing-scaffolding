package com.screspo.cqrs_event_sourcing.shared.infrastructure.bus.query;

import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.Query;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.QueryHandler;
import com.screspo.cqrs_event_sourcing.shared.domain.bus.query.QueryNotRegisteredError;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

@Component
public final class QueryHandlersInformation {
    HashMap<Class<? extends Query>, Class<? extends QueryHandler>> indexedQueryHandlers;

    public QueryHandlersInformation() {
        Reflections reflections = new Reflections("com.screspo");
        Set<Class<? extends QueryHandler>> classes = reflections.getSubTypesOf(QueryHandler.class);

        indexedQueryHandlers = formatHandlers(classes);
    }

    public Class<? extends QueryHandler> search(Class<? extends Query> queryClass) throws QueryNotRegisteredError {
        Class<? extends QueryHandler> queryHandlerClass = indexedQueryHandlers.get(queryClass);

        if (Objects.isNull(queryHandlerClass)) {
            throw new QueryNotRegisteredError(queryClass);
        }

        return queryHandlerClass;
    }

    private HashMap<Class<? extends Query>, Class<? extends QueryHandler>> formatHandlers(
            Set<Class<? extends QueryHandler>> queryHandlers
    ) {
        HashMap<Class<? extends Query>, Class<? extends QueryHandler>> handlers = new HashMap<>();

        for (Class<? extends QueryHandler> handler : queryHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Query> queryClass = (Class<? extends Query>) paramType.getActualTypeArguments()[0];

            handlers.put(queryClass, handler);
        }

        return handlers;
    }
}
