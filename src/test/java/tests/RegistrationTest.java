package tests;

import Pages.CustomerInfoPage;
import Pages.RegistrationPage;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationTest {

    RegistrationPage registrationPage = new RegistrationPage("https://magento.softwaretestingboard.com/customer/account/create/");
    UserInformation userInfo = new UserInformation();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void RegistrationFlow() {
        registrationPage.Open();

        registrationPage.enterFirstName("vs_firstName1");
        registrationPage.enterLastName("vs_lastName1");
        registrationPage.enterEmail(userInfo.GenerateRandomEmail());
        registrationPage.enterPassword("vs_passWord1!");
        registrationPage.enterPasswordConfirmation("vs_passWord1!");

        CustomerInfoPage customerInfo = registrationPage.OpenCustomerAccount();
        customerInfo.VerifyPageTitle("My Account");
    }
}
