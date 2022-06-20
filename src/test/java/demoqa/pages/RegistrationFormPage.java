package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalendarComponents calendar = new CalendarComponents();

    //Locators
    SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            inputEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            mobilePhone = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            inputSubject = $("#subjectsInput"),
            inputHobby = $("#hobbiesWrapper"),
            uploadPhoto = $("#uploadPicture"),
            inputAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            endFScreen = $("#example-modal-sizes-title-lg");

    //Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        inputEmail.setValue(value);

        return this;
    }

    public RegistrationFormPage setGenderUser(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirth.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        mobilePhone.setValue(value);

        return this;
    }

    public RegistrationFormPage setSubjects(String subject) {
        inputSubject.setValue(subject).pressEnter(); // Если не дописать нажми Enter то текст Предмета не будет введён!

        return this;
    }

    public RegistrationFormPage setHobby(String hobby) {
        inputHobby.$(byText(hobby)).click();

        return this;
    }

    public RegistrationFormPage setPhoto(String Image) {
        uploadPhoto.uploadFromClasspath("Image/" + Image);
        // таким оразом название картинки не захардкоженно.( могу менять и название и
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String address) {
        inputAddress.setValue(address);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        state.click();
        $(byText(value)).scrollTo().click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        city.click();
        $(byText(value)).scrollTo().click();

        return this;
    }

    public RegistrationFormPage submitForm() {
        $("#submit").pressEnter();

        return this;
    }

    public RegistrationFormPage checkTitle(String title) {
        endFScreen.shouldHave(text(title));

        return this;
    }


    public RegistrationFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}