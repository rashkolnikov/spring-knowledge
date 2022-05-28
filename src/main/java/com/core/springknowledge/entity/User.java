package com.core.springknowledge.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"uuid"})
        })
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(name = "email", length = 320, nullable = false)
    private String email;

    @Basic(optional = false)
    @Column(name = "uuid", length = 64, nullable = false, updatable = false)
    private String uuid;

    @Basic(optional = false)
    @Column(name = "password", nullable = false)
    private String password;

    @Basic(optional = false)
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Basic(optional = false)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Basic(optional = false)
    @Column(name = "phone", length = 25, nullable = false)
    private String phone;

    @Basic(optional = false)
    @Column(name = "birthdate", nullable = false)
    private Instant birthdate;

    @Basic(optional = false)
    @Column(name = "verified_email", nullable = false)
    private boolean verifiedEmail;

    @Basic(optional = false)
    @Column(name = "verified_token", nullable = false)
    private boolean verifiedToken;

    public static @NonNull UserBuilder.Email builder(){return new Builder();}

    private static class Builder implements
            UserBuilder.Email,
            UserBuilder.UUID,
            UserBuilder.Password,
            UserBuilder.FirstName,
            UserBuilder.LastName,
            UserBuilder.Phone,
            UserBuilder.BirthDate,
            UserBuilder.Optionals{

        private final User user;

        private Builder(){ this.user = new User(); }


        @Override
        public @NonNull UserBuilder.UUID email(@NonNull String email) {
            this.user.setEmail(email);
            return this;
        }

        @Override
        public @NonNull UserBuilder.Password uuid(@NonNull String uuid) {
            this.user.setUuid(uuid);
            return this;
        }

        @Override
        public @NonNull UserBuilder.FirstName password(@NonNull String password) {
            this.user.setPassword(password);
            return this;
        }

        @Override
        public @NonNull UserBuilder.LastName firstName(@NonNull String firstName) {
            this.user.setFirstName(firstName);
            return this;
        }

        @Override
        public @NonNull UserBuilder.Phone lastName(@NonNull String lastName) {
            this.user.setLastName(lastName);
            return this;
        }

        @Override
        public @NonNull UserBuilder.BirthDate phone(@NonNull String phone) {
            this.user.setPhone(phone);
            return this;
        }

        @Override
        public @NonNull UserBuilder.Optionals birthdate(@NonNull Instant birthdate) {
            this.user.setBirthdate(birthdate);
            return this;
        }

        @Override
        public @NonNull UserBuilder.Optionals enabled(boolean enabled) {
            this.user.setEnabled(enabled);
            return this;
        }

        @Override
        public @NonNull UserBuilder.Optionals verifiedEmail(boolean verifiedEmail) {
            this.user.setVerifiedEmail(verifiedEmail);
            return this;
        }

        @Override
        public @NonNull UserBuilder.Optionals verifiedToken(boolean verifiedToken) {
            this.user.setVerifiedToken(verifiedToken);
            return this;
        }

        @Override
        public @NonNull User build() {
            return this.user;
        }
    }

    private interface UserBuilder {
        interface Email {
            @NonNull UUID email(@NonNull String email);
        }

        interface UUID {
            @NonNull Password uuid(@NonNull String uuid);
        }

        interface Password {
            @NonNull FirstName password(@NonNull String password);
        }

        interface FirstName {
            @NonNull LastName firstName(@NonNull String firstName);
        }

        interface LastName {
            @NonNull Phone lastName(@NonNull String lastName);
        }

        interface Phone {
            @NonNull BirthDate phone(@NonNull String phone);
        }

        interface BirthDate {
            @NonNull Optionals birthdate(@NonNull Instant birthdate);
        }

        interface Optionals {
            @NonNull Optionals enabled(boolean enabled);

            @NonNull Optionals verifiedEmail(boolean verifiedEmail);

            @NonNull Optionals verifiedToken(boolean verifiedToken);

            @NonNull User build();
        }
    }
}
