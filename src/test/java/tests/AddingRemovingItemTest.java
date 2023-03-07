package tests;

import Pages.ContentPage;
import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.Configuration;

import org.assertj.core.api.SoftAssertions;
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
        SoftAssertions softAssertions = new SoftAssertions();
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
        softAssertions.assertThat(contentPage.getItemQtyInCart()).isEqualTo("1");

        contentPage.clickShowCartButton();
        contentPage.checkMiniCartOpened();
        contentPage.clickDeleteButton();
        contentPage.confirmationMessageAppears();
        contentPage.clickOkButton();
        contentPage.removeMessageAppears();
        softAssertions.assertThat(contentPage.getItemQtyInCart()).isEqualTo("");

        loginPage.logOut();
    }

    @Test
    void SecondFlow() {
        SoftAssertions softAssertions = new SoftAssertions();
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
        softAssertions.assertThat(contentPage.getItemQtyInCart()).isEqualTo("1");

        contentPage.clickShowCartButton();
        contentPage.checkMiniCartOpened();
        contentPage.clickDeleteButton();
        contentPage.confirmationMessageAppears();
        contentPage.clickOkButton();
        contentPage.removeMessageAppears();
        softAssertions.assertThat(contentPage.getItemQtyInCart()).isEqualTo("");

        loginPage.logOut();
    }
}
