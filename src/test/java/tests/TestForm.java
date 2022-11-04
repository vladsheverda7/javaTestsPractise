package tests;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class TestForm {

    String firstName = "James";
    String lastName = "Bond";
    String userEmail = "jamesBond@gmail.com";

    String gender = "Male";
    String phoneNumber = "0070070070";

    String month = "November";
    String year = "1920";
    String day = "11";

    String subject = "Maths";
    String hobbies = "Reading";

    String currentAddress = "Dubai";

    String state = "Rajasthan";
    String city = "Jaiselmer";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void studentRegistration() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);

        $(byText(gender)).click();

        $("[id=userNumber]").setValue(phoneNumber);

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day.react-datepicker__day--0" + day).click();

        $("[id=subjectsInput]").setValue(subject);
        $("[id=subjectsInput]").pressEnter();

        $(byText(hobbies)).click();

        $("[id=uploadPicture]").uploadFile(new File("cat.jpeg"));

        $("[id=currentAddress]").setValue(currentAddress);

        $("[id=state]").click();
        $(byText(state)).click();

        $("[id=city]").click();
        $(byText(city)).click();

        $("[id=submit]").click();

        $(".modal-body").shouldHave(
                text(String.join(" " ,firstName, lastName)),
                text(userEmail),
                text(gender),
                text(phoneNumber),
                text(String.join(" ", day, (String.join(",",month,year )))),
                text(subject),
                text(hobbies),
                text("cat.jpeg"),
                text(currentAddress),
                text(String.join(" " ,state, city))
        );
    }
}
