package com.core.springknowledge.entity;

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
