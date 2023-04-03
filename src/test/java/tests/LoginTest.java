package tests;

import Pages.LoginPage;
import Pages.MainPage;
import Utilities.UserInformation.UserInformation;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage("https://magento.softwaretestingboard.com/customer/account/login");
    MainPage mainPage = new MainPage("https://magento.softwaretestingboard.com/");
    UserInformation userInfo = new UserInformation();

    @Story("Check user login")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void LoginFlow() throws  IOException {

        try {
            FileInputStream fis = new FileInputStream("src/test/resources/log.properties");
            LogManager.getLogManager().readConfiguration(fis);
            fis.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        Logger logger = Logger.getLogger(LoginTest.class.getName());
        logger.info("Login flow test started");
        mainPage.open();
        logger.warning("Clicking SignIn button");
        mainPage.clickSignIn();
        logger.warning("Logging in as a user");
        loginPage.loginAsUser(userInfo.getEmail(), userInfo.getPassword());
        Assertions.assertEquals("Welcome, " + userInfo.getFullName() + "!",
                mainPage.getWelcomeMessage());
        logger.info("Login flow test completed");
    }
}
