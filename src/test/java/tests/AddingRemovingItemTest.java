package tests;

import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AddingRemovingItemTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage("https://magento.softwaretestingboard.com/");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void LoginFlow() {
        mainPage.Open();
        mainPage.ClickLoginButton();
        loginPage.loginAsUser("vs_testUser1@gmail.com", "vs_passWord1!");

    }

}
