package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class ContentPage {

    private SelenideElement menNavigation = $(By.xpath("//nav[@class='navigation']//span[text() = 'Men']"));
    private SelenideElement topsNavigation = $(By.xpath("//div[@class='sidebar sidebar-main']//*[text() = 'Tops']"));
    private SelenideElement styleNavigation = $(By.xpath("//div[@class='filter-options']//*[text() = 'Style']"));
    private SelenideElement rainCoat = $(By.xpath("//li/a[normalize-space(text())='Rain Coat']"));
    private SelenideElement listViewButton = $("[id=mode-list]");
    private SelenideElement sortedButton = $("[id=sorter]");
    private SelenideElement priceFilter =  $(By.xpath("//option[@value='price']"));
    private SelenideElement mediumSize =  $(By.xpath(("//ol[@class='products list items product-items']/li[2]//div[text() = 'M']")));
    private SelenideElement yellowColor = $(By.xpath(("//ol[@class='products list items product-items']/li[2]//div[@aria-label='Color']/div[@option-label='Yellow']")));
    private SelenideElement addToCartButton = $(By.xpath(("//ol[@class='products list items product-items']/li[2]//button[@title='Add to Cart']")));
    private SelenideElement counterQty = $(By.xpath("//span[@class='counter qty']"));
    private SelenideElement showCartButton = $(By.xpath("//a[@class='action showcart']"));
    private SelenideElement miniCart = $(By.xpath("//div[@class='minicart-items-wrapper']"));

    public void AddaСlothesToCart() {
        menNavigation.click();
        topsNavigation.click();
        styleNavigation.click();
        rainCoat.click();
        listViewButton.click();
        sortedButton.click();
        priceFilter.click();
        mediumSize.click();
        yellowColor.click();
        addToCartButton.click();
        counterQty.should(appear);
        showCartButton.click();
        miniCart.should(appear);
    }
}
