package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            birthdayInput = $("#dateOfBirthInput"),
            photoInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");


    public RegistrationFormPage openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }


    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        genderInput.$(byText(gender)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthday(String day, String month, String year) {
        birthdayInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby(String hobby) {
        $(byText(hobby)).click();

        return this;
    }

    public RegistrationFormPage setPhoto(String photo) {
        photoInput.uploadFromClasspath(photo);

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setCity(String state, String city) {
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();

        return this;
    }

    public RegistrationFormPage submit() {
        submitButton.click();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }
}

