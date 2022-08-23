package guru.qa.tests;


import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PracticeFormTestsWithFaker extends TestBase {


    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10).toString(),
            day = faker.number().numberBetween(1, 30) + "",
            year = faker.number().numberBetween(1990, 2010) + "",
            address = faker.address().fullAddress(),
            gender = "Other",
            month = "August",
            subject1 = "English",
            subject2 = "Maths",
            hobby1 = "Reading",
            hobby2 = "Sports",
            photo = "photo.jpg",
            state = "Haryana",
            city = "Karnal";

    @Test
    void fillPracticeForm() {

        //Вводим значения в поля
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setBirthday(day, month, year)
                .setSubject(subject1)
                .setSubject(subject2)
                .setHobby(hobby1)
                .setHobby(hobby2)
                .setPhoto(photo)
                .setAddress(address)
                .setCity(state, city)
                .submit();

        //Проверяем открывшуюся форму
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", String.format("%s %s,%s", day, month, year))
                .checkResult("Subjects", String.format("%s, %s", subject1, subject2))
                .checkResult("Hobbies", String.format("%s, %s", hobby1, hobby2))
                .checkResult("Picture", photo)
                .checkResult("Address", address)
                .checkResult("State and City", String.format("%s %s", state, city));

    }
}
