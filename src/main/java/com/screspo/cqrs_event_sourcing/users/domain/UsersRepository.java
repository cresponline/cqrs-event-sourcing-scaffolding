package com.screspo.cqrs_event_sourcing.users.domain;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {

    List<User> searchAll();

    void save(User user);

    void delete(String id);

    Optional<User> search(String id);
}
