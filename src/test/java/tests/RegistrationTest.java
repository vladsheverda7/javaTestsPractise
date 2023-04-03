package tests;

import Pages.CustomerInfoPage;
import Pages.RegistrationPage;

import Utilities.UserInformation.UserInformation;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage("https://magento.softwaretestingboard.com/customer/account/create/");
    UserInformation userInfo = new UserInformation();

    @Story("Check user registration")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void RegistrationFlow() {
        registrationPage.open();

        registrationPage.enterFirstName(userInfo.getFirstName());
        registrationPage.enterLastName(userInfo.getLastName());
        registrationPage.enterEmail(userInfo.generateRandomEmail());
        registrationPage.enterPassword(userInfo.getPassword());
        registrationPage.enterPasswordConfirmation(userInfo.getPassword());

        CustomerInfoPage customerInfo = registrationPage.OpenCustomerAccount();
        Assertions.assertEquals("My Account", customerInfo.getPageTitle());
    }
}
