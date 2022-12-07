package ru.boyko_anastasia.tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void fillFormTest() {
        String firstName = "Anastasia",
                lastName = "Boyko",
                userEmail = "boyko_anastasia@mail.ru",
                gender = "Female",
                userNumber = "88005000552",
                day = "07",
                month = "August",
                year = "1991",
                subjects = "Biology",
                hobbies = "Reading",
                picture = "img/Asha.jpg",
                currentAddress = "Bolshaya Pirogovskaya 36,53",
                state = "Haryana",
                city = "Karnal";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .setSubmit();


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", "boyko_anastasia@mail.ru")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "8800500055")
                .verifyResult("Date of Birth", "07 August,1991")
                .verifyResult("Subjects", "Biology")
                .verifyResult("Hobbies", "Reading")
                .verifyResult("Picture", "Asha.jpg")
                .verifyResult("Address", "Bolshaya Pirogovskaya 36,53")
                .verifyResult("State and City", "Haryana Karna");
    }
}