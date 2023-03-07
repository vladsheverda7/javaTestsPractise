package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    public MainPage(String pageUrl) {
        super(pageUrl);
    }

    String noItems = "You have no items in your shopping cart";
    String areYouSureQuestion = "Are you sure you would like to remove this item from the shopping cart?";

    private SelenideElement signInButton = $(".authorization-link");
    private SelenideElement welcomeMessage = $(By.xpath("//header//span[@class='logged-in']"));

    private SelenideElement headerLink = $(".customer-welcome");
    private SelenideElement signOut = $(".authorization-link");

    private SelenideElement menNavigation = $(By.xpath("//div[@class='sections nav-sections']//li/a[contains(@href,'/men')]"));
    private SelenideElement topsNavigation = $(By.xpath("//div[@class='block filter']//li/a[contains(@href,'/men')]"));
    private SelenideElement styleNavigation = $(By.xpath("//div[@class='filter-options']//*[text() = 'Style']"));
    private SelenideElement rainCoat = $(By.xpath("//li/a[normalize-space(text())='Rain Coat']"));

    private SelenideElement listViewButton = $("[id=mode-list]");
    private SelenideElement sortedButton = $("[id=sorter]");
    private SelenideElement priceFilter =  $(By.xpath("//option[@value='price']"));

    private SelenideElement counterQty = $(By.xpath("//span[@class='counter qty']"));
    private SelenideElement itemQty = $(By.xpath("//span[@class='counter-number']"));

    private SelenideElement showCartButton = $(By.xpath("//a[@class='action showcart']"));
    private SelenideElement miniCart = $(By.xpath("//div[@class='minicart-items-wrapper']"));
    private SelenideElement deleteButton = $(By.xpath("//div[@class='minicart-items-wrapper']//a[@class='action delete']"));
    private SelenideElement question = $(By.xpath("(//div[@class='modal-content'])[last()]"));
    private SelenideElement okButton = $(By.xpath("//button/span[text()='OK']"));
    private SelenideElement modalRemovingConfirmation = $(By.xpath("//div[@id='minicart-content-wrapper']/div[@class='block-content']/strong[@class='subtitle empty']"));

    public void clickSignIn() {
        signInButton.click();
    }

    public String getWelcomeMessage(){
        welcomeMessage.shouldBe(visible);
        return welcomeMessage.text();
    }

    public void logOut() {
        headerLink.click();
        signOut.click();
    }

    public void clickNav() {menNavigation.click();}

    public void clickTopNav(){topsNavigation.click();}

    public void clickStyleNav(){styleNavigation.click();}

    public void clickRainCoat() {rainCoat.click();}

    public void openItemsListView() {listViewButton.click();}

    public void clickSortedMenu() {sortedButton.click();}

    public void selectFilterByPrice() {priceFilter.click();}

    public void checkCartCounter() {counterQty.should(appear);}

    public String getItemQtyInCart(){return itemQty.text();}

    public void clickShowCartButton() {showCartButton.click();}

    public void checkMiniCartOpened() {miniCart.should(appear);}

    public void clickDeleteButton() {deleteButton.click();}

    public void confirmationMessageAppears() {question.shouldHave(text(areYouSureQuestion));}

    public void clickOkButton() {okButton.click();}

    public void removeMessageAppears() {modalRemovingConfirmation.shouldHave(text(noItems));}

    public void addItemToCart(int itemNumber,  String size, String color){
        $(By.xpath(("//ol[@class='products list items product-items']/li" + "[" + itemNumber +"]" + "//div[text() = '" + size + "']"))).click();
        $(By.xpath(("//ol[@class='products list items product-items']/li" + "[" + itemNumber +"]" + "//div[@aria-label='Color']/div[@option-label='" + color + "']"))).click();
        $(By.xpath(("//ol[@class='products list items product-items']/li" + "[" + itemNumber +"]" + "//button[@title='Add to Cart']"))).click();
    }
}
