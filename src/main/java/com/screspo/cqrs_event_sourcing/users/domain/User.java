package com.screspo.cqrs_event_sourcing.users.domain;

import com.screspo.cqrs_event_sourcing.shared.domain.agregates.AggregateRoot;
import com.screspo.cqrs_event_sourcing.users.domain.events.UserCreatedDomainEvent;
import com.screspo.cqrs_event_sourcing.users.domain.events.UserDeletedDomainEvent;
import com.screspo.cqrs_event_sourcing.users.domain.events.UserEditedDomainEvent;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserEmail;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserId;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserName;
import com.screspo.cqrs_event_sourcing.users.domain.value_objects.UserSurname;

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
    }

    private User(UserId id, UserName name, UserSurname surname, UserEmail email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public User edit(UserId id, UserName name, UserSurname surname, UserEmail email) {
        User edited = new User(id, name, surname, email);
        edited.record(new UserEditedDomainEvent(
                id.value(),
                name.value(),
                surname.value(),
                email.value())
        );
        return edited;
    }

    public User delete() {
        User toDelete = new User(this.id, this.name, this.surname, this.email);
        toDelete.record(new UserDeletedDomainEvent(this.id.value()));
        return toDelete;
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
            User user = new User(this);
            user.record(new UserCreatedDomainEvent(id.value(), name.value(), surname.value(), email.value()));
            return user;
        }
    }
}
