package tests;

import Pages.ContentPage;
import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AddingRemovingItemTest {

    LoginPage loginPage = new LoginPage();
    UserInformation userInfo = new UserInformation();
    MainPage mainPage = new MainPage("https://magento.softwaretestingboard.com/");
    ContentPage contentPage = new ContentPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FirstFlow() {
        mainPage.Open();
        mainPage.ClickLoginButton();
        loginPage.loginAsUser(userInfo.getEmail(), userInfo.getPassword());

        contentPage.clickNav();
        contentPage.clickTopNav();
        contentPage.clickStyleNav();
        contentPage.clickRainCoat();
        contentPage.openItemsListView();
        contentPage.clickSortedMenu();
        contentPage.selectFilterByPrice();
        contentPage.addItemToCart(1,"M", "Yellow");
        contentPage.checkCartCounter();
        contentPage.clickShowCartButton();
        contentPage.checkMiniCartOpened();
        contentPage.clickDeleteButton();
        contentPage.confirmationMessageAppears();
        contentPage.clickOkButton();
        contentPage.removeMessageAppears();

        loginPage.logOut();
    }

    @Test
    void SecondFlow() {
        mainPage.Open();
        mainPage.ClickLoginButton();
        loginPage.loginAsUser(userInfo.getEmail(), userInfo.getPassword());

        contentPage.clickNav();
        contentPage.clickTopNav();
        contentPage.clickStyleNav();
        contentPage.clickRainCoat();
        contentPage.openItemsListView();
        contentPage.clickSortedMenu();
        contentPage.selectFilterByPrice();
        contentPage.addItemToCart(2, "S", "Red" );
        contentPage.checkCartCounter();
        contentPage.clickShowCartButton();
        contentPage.checkMiniCartOpened();
        contentPage.clickDeleteButton();
        contentPage.confirmationMessageAppears();
        contentPage.clickOkButton();
        contentPage.removeMessageAppears();

        loginPage.logOut();
    }
}
