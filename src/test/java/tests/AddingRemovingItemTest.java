package tests;

import Pages.LoginPage;
import Pages.MainPage;
import Utilities.UserInformation.UserInformation;
import com.codeborne.selenide.Configuration;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AddingRemovingItemTest {

    LoginPage loginPage = new LoginPage("https://magento.softwaretestingboard.com/customer/account/login");
    MainPage mainPage = new MainPage("https://magento.softwaretestingboard.com/");
    UserInformation userInfo = new UserInformation();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FirstFlow() throws  IOException {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/log.properties");
            LogManager.getLogManager().readConfiguration(fis);
            fis.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        Logger logger = Logger.getLogger(AddingRemovingItemTest.class.getName());

        logger.info("Login flow test started");
        SoftAssertions softAssertions = new SoftAssertions();
        logger.info("Login flow test started");
        mainPage.open();
        logger.warning("Clicking SignIn button");
        mainPage.clickSignIn();
        logger.warning("Logging in as a user");
        loginPage.loginAsUser(userInfo.getEmail(), userInfo.getPassword());

        logger.warning("Clicking navigation panel");
        mainPage.clickNav();
        logger.warning("Clicking navigation panel by tops");
        mainPage.clickTopNav();
        logger.warning("Choosing style");
        mainPage.clickStyleNav();
        logger.warning("Choosing rain coat");
        mainPage.clickRainCoat();
        logger.warning("Changing items view to list");
        mainPage.openItemsListView();
        logger.warning("Sorting item list");
        mainPage.clickSortedMenu();
        logger.warning("Filtering item list");
        mainPage.selectFilterByPrice();
        logger.warning("Adding first item to the cart");
        mainPage.addItemToCart(1,"M", "Yellow");

        logger.warning("Checking cart count");
        mainPage.checkCartCounter();
        softAssertions.assertThat(mainPage.getItemQtyInCart()).isEqualTo("1");

        logger.warning("Clicking cart button");
        mainPage.clickShowCartButton();
        logger.warning("Opening cart");
        mainPage.checkMiniCartOpened();
        logger.warning("Clicking delete button");
        mainPage.clickDeleteButton();
        logger.warning("Appearing of confirmation message");
        mainPage.confirmationMessageAppears();
        logger.warning("Clicking OK button");
        mainPage.clickOkButton();
        logger.warning("Checking confirmation message");
        mainPage.removeMessageAppears();
        logger.warning("Checking cart item count");
        softAssertions.assertThat(mainPage.getItemQtyInCart()).isEqualTo("");

        mainPage.logOut();
        logger.info("Adding and removing flow test completed");
    }

    @Test
    void SecondFlow() {
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.open();
        mainPage.clickSignIn();
        loginPage.loginAsUser(userInfo.getEmail(), userInfo.getPassword());

        mainPage.clickNav();
        mainPage.clickTopNav();
        mainPage.clickStyleNav();
        mainPage.clickRainCoat();
        mainPage.openItemsListView();
        mainPage.clickSortedMenu();
        mainPage.selectFilterByPrice();
        mainPage.addItemToCart(2, "S", "Red" );

        mainPage.checkCartCounter();
        softAssertions.assertThat(mainPage.getItemQtyInCart()).isEqualTo("1");

        mainPage.clickShowCartButton();
        mainPage.checkMiniCartOpened();
        mainPage.clickDeleteButton();
        mainPage.confirmationMessageAppears();
        mainPage.clickOkButton();
        mainPage.removeMessageAppears();
        softAssertions.assertThat(mainPage.getItemQtyInCart()).isEqualTo("");

        mainPage.logOut();
    }
}
