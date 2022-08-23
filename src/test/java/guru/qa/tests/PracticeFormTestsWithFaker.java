package guru.qa.tests;


import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PracticeFormTestsWithFaker extends TestBase {


    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();
    String firstName,
            lastName,
            email,
            phoneNumber,
            day,
            year,
            address;


    @BeforeEach
    void prepareTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        phoneNumber = faker.phoneNumber().subscriberNumber(10).toString();
        day = faker.number().numberBetween(1, 30) + "";
        year = faker.number().numberBetween(1990, 2010) + "";
        address = faker.address().fullAddress();
    }

    @Test
    void fillPracticeForm() {

        //Вводим значения в поля
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Other")
                .setNumber(phoneNumber)
                .setBirthday(day, "August", year)
                .setSubject("English")
                .setSubject("Maths")
                .setHobby("Reading")
                .setHobby("Sports")
                .setPhoto("photo.jpg")
                .setAddress(address)
                .setCity("Haryana", "Karnal")
                .submit();

        //Проверяем открывшуюся форму
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", "Other")
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", day + " August," + year)
                .checkResult("Subjects", "English, Maths")
                .checkResult("Hobbies", "Reading, Sports")
                .checkResult("Picture", "photo.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", "Haryana Karnal");

    }
}
