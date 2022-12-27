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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void FirstFlow() {
        mainPage.Open();
        mainPage.ClickLoginButton();
        loginPage.enterUserName(userInfo.ReturnEmail());
        loginPage.enterPassword(userInfo.ReturnPassword());
        loginPage.clickSignInButton();

        contentPage.clickNav();
        contentPage.clickTopNav();
        contentPage.clickStyleNav();
        contentPage.clickRainCoat();
        contentPage.openItemsListView();
        contentPage.clickSortedMenu();
        contentPage.selectFilterByPrice();
        contentPage.addItemToCart(1);
        contentPage.checkCartCounter();
        contentPage.clickShowCartButton();
        contentPage.checkMiniCartOpened();
        contentPage.clickDeleteButton();
        contentPage.confirmationMessageAppears();
        contentPage.clickOkButton();
        contentPage.removeMessageAppears();

        loginPage.userSignOut();
    }
}
