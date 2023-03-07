package tests;

import Pages.LoginPage;
import Pages.MainPage;
import Utilities.UserInformation.UserInformation;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginTest {

    LoginPage loginPage = new LoginPage("https://magento.softwaretestingboard.com/customer/account/login");
    MainPage mainPage = new MainPage("https://magento.softwaretestingboard.com/");
    UserInformation userInfo = new UserInformation();


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void LoginFlow() {
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.loginAsUser(userInfo.getEmail(), userInfo.getPassword());
        Assertions.assertEquals("Welcome, " + userInfo.getFullName() + "!",
                mainPage.getWelcomeMessage());
    }
}
