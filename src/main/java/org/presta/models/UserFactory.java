package org.presta.models;

import com.github.javafaker.Faker;
import org.presta.config.Config;

import java.text.SimpleDateFormat;

public class UserFactory {

    protected static Config config = new Config();

    public User getRandomUser() {
        SimpleDateFormat correctFormat = new SimpleDateFormat("MM/dd/yyyy");
        Faker faker = new Faker();
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password(5, 15))
                .birthDate(correctFormat.format(faker.date().birthday()))
                .build();
    }

    public User getAlreadyRegisteredUser() {
        return new User.UserBuilder()
                .firstName(config.getUserFirstName())
                .lastName(config.getUserLastName())
                .email(config.getUserEmail())
                .build();
    }
}
