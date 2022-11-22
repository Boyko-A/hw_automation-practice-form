import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {


    @BeforeAll
    static void beforeALL() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest () {
        open ("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Anastasiya");
        $("#lastName").setValue("Boyko");
        $("#userEmail").setValue("boyko_anastasia@mail.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("88005000552");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--007").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Asha.jpg"));
        $("#currentAddress").setValue("Bolshaya Pirogovskaya 36,53");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Anastasiya Boyko"),
                text("boyko_anastasia@mail.ru"),
                text("Female"),
                text("8800500055"),
                text("07 August,1991"),
                text("Biology"),
                text("Reading"),
                text("Asha.jpg"),
                text("Bolshaya Pirogovskaya 36,53"),
                text("Haryana Karna"));






    }
}
