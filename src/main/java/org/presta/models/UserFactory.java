package org.presta.models;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class UserFactory {

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
}
