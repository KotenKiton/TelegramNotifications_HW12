package demoqa.tests;


import com.github.javafaker.Faker;
import demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@Tag("demoqa")
@DisplayName("Тест формы регистрации")
public class FormTest extends TestBase{ // расширь класс и включи TestBase!!!!!!!!!
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            InputEmail = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            address = faker.address().fullAddress(),
            mobilePhone = faker.phoneNumber().subscriberNumber(10),
            day = "19",
            month = "January",
            year = "2000",
            dayOfBirthday = format("%s %s,%s", day, month, year),
            fullName = format("%s %s", firstName, lastName),
            subject = "Computer Science",
            hobbies = "Sports",
            photo = "Me.png",
            state = "Haryana",
            city = "Karnal",
            endForm = "Thanks for submitting the form";

    @Test
    @DisplayName("Тест формы регистрации")
    void fillFormTest() {
        step("Открываем страницу формы регистрации", () -> {
            registrationFormPage
                    .openPage();

            step("Заполняем поле имени", () -> {
            registrationFormPage
                    .setFirstName(firstName);
            });
            registrationFormPage
                    .setLastName(lastName)
                    .setUserEmail(InputEmail)
                    .setGenderUser(gender)
                    .setUserNumber(mobilePhone)
                    .setBirthDate(day, month, year)
                    .setSubjects(subject)
                    .setHobby(hobbies)
                    .setPhoto(photo)
                    .setCurrentAddress(address)
                    .setState(state)
                    .setCity(city)
                    .submitForm();
        });

        step("Проверки", () -> {
            registrationFormPage
                    .checkTitle(endForm)
                    .checkResult("Student Name", fullName)
                    .checkResult("Student Email", InputEmail)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", mobilePhone)
                    .checkResult("Date of Birth", dayOfBirthday)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Picture", photo)
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);
        });
    }
}
