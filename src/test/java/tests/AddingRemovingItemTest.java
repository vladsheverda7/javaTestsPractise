package tests;

import Pages.LoginPage;
import Pages.MainPage;
import Utilities.UserInformation.UserInformation;
import com.codeborne.selenide.Configuration;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AddingRemovingItemTest {

    LoginPage loginPage = new LoginPage("https://magento.softwaretestingboard.com/customer/account/login");
    MainPage mainPage = new MainPage("https://magento.softwaretestingboard.com/");
    UserInformation userInfo = new UserInformation();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FirstFlow() {
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.loginAsUser(userInfo.getEmail(), userInfo.getPassword());

        mainPage.clickNav();
        mainPage.clickTopNav();
        mainPage.clickStyleNav();
        mainPage.clickRainCoat();
        mainPage.openItemsListView();
        mainPage.clickSortedMenu();
        mainPage.selectFilterByPrice();
        mainPage.addItemToCart(1,"M", "Yellow");

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

    @Test
    void SecondFlow() {
        SoftAssertions softAssertions = new SoftAssertions();
        mainPage.open();
        mainPage.clickLoginButton();
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
