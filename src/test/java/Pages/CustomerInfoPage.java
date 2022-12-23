package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CustomerInfoPage extends  BasePage {
    private SelenideElement pageTitle = $(By.xpath("//h1/span[text()='My Account']"));

    public CustomerInfoPage(String pageUrl) {
        super(pageUrl);
    }

    public void VerifyPageTitle(String expectedTitle){
        pageTitle.shouldHave(text(expectedTitle));
    }
}
