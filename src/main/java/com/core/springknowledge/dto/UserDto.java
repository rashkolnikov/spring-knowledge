package com.core.springknowledge.dto;

import com.core.springknowledge.entity.User;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserDto {

    private String email;

    private String uuid;

    private String password;

    private boolean enabled;

    private String firstName;

    private String lastName;

    private String phone;

    private Instant birthdate;

    private boolean verifiedEmail;

    private boolean verifiedToken;

    public static @NonNull UserDtoBuilder.Email builder(){return new UserDto.Builder();}

    private static class Builder implements
            UserDtoBuilder.Email,
            UserDtoBuilder.UUID,
            UserDtoBuilder.Password,
            UserDtoBuilder.FirstName,
            UserDtoBuilder.LastName,
            UserDtoBuilder.Phone,
            UserDtoBuilder.BirthDate,
            UserDtoBuilder.Optionals{

        private final  UserDto userDto;

        private Builder(){ this.userDto = new UserDto(); }


        @Override
        public @NonNull UserDtoBuilder.UUID email(@NonNull String email) {
            this.userDto.setEmail(email);
            return this;
        }

        @Override
        public @NonNull UserDtoBuilder.Password uuid(@NonNull String uuid) {
            this.userDto.setUuid(uuid);
            return this;
        }

        @Override
        public @NonNull UserDtoBuilder.FirstName password(@NonNull String password) {
            this.userDto.setPassword(password);
            return this;
        }

        @Override
        public @NonNull UserDtoBuilder.LastName firstName(@NonNull String firstName) {
            this.userDto.setFirstName(firstName);
            return this;
        }

        @Override
        public @NonNull UserDtoBuilder.Phone lastName(@NonNull String lastName) {
            this.userDto.setLastName(lastName);
            return this;
        }

        @Override
        public @NonNull UserDtoBuilder.BirthDate phone(@NonNull String phone) {
            this.userDto.setPhone(phone);
            return this;
        }

        @Override
        public @NonNull UserDtoBuilder.Optionals birthdate(@NonNull Instant birthdate) {
            this.userDto.setBirthdate(birthdate);
            return this;
        }

        @Override
        public @NonNull UserDtoBuilder.Optionals enabled(boolean enabled) {
            this.userDto.setEnabled(enabled);
            return this;
        }

        @Override
        public @NonNull UserDtoBuilder.Optionals verifiedEmail(boolean verifiedEmail) {
            this.userDto.setVerifiedEmail(verifiedEmail);
            return this;
        }

        @Override
        public @NonNull UserDtoBuilder.Optionals verifiedToken(boolean verifiedToken) {
            this.userDto.setVerifiedToken(verifiedToken);
            return this;
        }

        @Override
        public @NonNull UserDto build() {
            return this.userDto;
        }
    }

    private interface UserDtoBuilder {
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

            @NonNull UserDto build();
        }
    }
}
