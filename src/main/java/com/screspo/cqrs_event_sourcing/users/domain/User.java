package com.screspo.cqrs_event_sourcing.users.domain;

import com.screspo.cqrs_event_sourcing.shared.domain.agregates.AggregateRoot;
import com.screspo.cqrs_event_sourcing.shared.domain.events.UserCreatedDomainEvent;

public class User extends AggregateRoot {
    private final UserId id;
    private final UserName name;
    private final UserSurname surname;
    private final UserEmail email;

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;

        this.record(new UserCreatedDomainEvent(id.value(), name.value(), surname.value(), email.value()));
    }

    public UserId id() {
        return id;
    }

    public UserName name() {
        return name;
    }

    public UserSurname surname() {
        return surname;
    }

    public UserEmail email() {
        return email;
    }

    public static class Builder {
        private UserId id;
        private UserName name;
        private UserSurname surname;
        private UserEmail email;

        public Builder id(final UserId id) {
            this.id = id;
            return this;
        }

        public Builder name(final UserName name) {
            this.name = name;
            return this;
        }

        public Builder surname(final UserSurname surname) {
            this.surname = surname;
            return this;
        }

        public Builder email(final UserEmail email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }


}
