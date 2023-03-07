package tests;

import com.codeborne.selenide.Configuration;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class SelectorPractise {

    String noItems = "You have no items in your shopping cart";
    String areYouSureQuestion = "Are you sure you would like to remove this item from the shopping cart?";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Story("Practise with selectors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void cartFlow() {
        open("https://magento.softwaretestingboard.com");

        $(By.xpath("//nav[@class='navigation']//span[text() = 'Men']")).click();
        $(By.xpath("//div[@class='sidebar sidebar-main']//*[text() = 'Tops']")).click();
        $(By.xpath("//div[@class='filter-options']//*[text() = 'Style']")).click();
        $(By.xpath("//li/a[normalize-space(text())='Rain Coat']")).click();
        $("[id=mode-list]").click();
        $("[id=sorter]").click();
        $(By.xpath("//option[@value='price']")).click();
        $(By.xpath(("//ol[@class='products list items product-items']/li[1]//div[text() = 'M']"))).click();
        $(By.xpath(("//ol[@class='products list items product-items']/li[1]//div[@aria-label='Color']/div[@option-label='Yellow']"))).click();
        $(By.xpath(("//ol[@class='products list items product-items']/li[1]//button[@title='Add to Cart']"))).click();
        $(By.xpath("//span[@class='counter qty']")).should(appear);
        $(By.xpath("//a[@class='action showcart']")).click();
        $(By.xpath("//div[@class='minicart-items-wrapper']")).should(appear);
        $(By.xpath("//div[@class='minicart-items-wrapper']//a[@class='action delete']")).click();
        $(By.xpath("(//div[@class='modal-content'])[last()]")).shouldHave(text(areYouSureQuestion));
        $(By.xpath("//button/span[text()='OK']")).click();
        $(By.xpath("//div[@id='minicart-content-wrapper']/div[@class='block-content']/strong[@class='subtitle empty']")).shouldHave(text(noItems));
    }
}