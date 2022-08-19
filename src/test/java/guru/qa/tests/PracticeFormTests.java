package guru.qa.tests;


import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class PracticeFormTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillPracticeForm() {

        //Вводим значения в поля
        registrationFormPage.openPage()
                .setFirstName("Tolyan")
                .setLastName("Tolyanov")
                .setEmail("tolyan@mail.ru")
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthday("12", "August", "2010")
                .setSubject("English")
                .setSubject("Maths")
                .setHobby("Reading")
                .setHobby("Sports")
                .setPhoto("photo.jpg")
                .setAddress("Some Address")
                .setCity("Haryana", "Karnal")
                .submit();

        //Проверяем открывшуюся форму
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Tolyan Tolyanov")
                .checkResult("Student Email", "tolyan@mail.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "12 August,2010")
                .checkResult("Subjects", "English, Maths")
                .checkResult("Hobbies", "Reading, Sports")
                .checkResult("Picture", "photo.jpg")
                .checkResult("Address", "Some Address")
                .checkResult("State and City", "Haryana Karnal");

    }
}
