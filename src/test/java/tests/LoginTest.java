package tests;

import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginTest {

    LoginPage loginPage = new LoginPage();
    UserInformation userInfo = new UserInformation();
    MainPage mainPage = new MainPage("https://magento.softwaretestingboard.com/");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void LoginFlow() {
        mainPage.Open();
        mainPage.ClickLoginButton();
        loginPage.loginAsUser(userInfo.getEmail(), userInfo.getPassword());
    }
}
