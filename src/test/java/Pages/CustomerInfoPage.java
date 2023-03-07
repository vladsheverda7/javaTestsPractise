package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CustomerInfoPage extends  BasePage {
    private  SelenideElement pageTitle = $(By.xpath("//span[@data-ui-id='page-title-wrapper']"));

    public CustomerInfoPage(String pageUrl) {
        super(pageUrl);
    }

    public String getPageTitle() {
        pageTitle.shouldBe(visible);
        return pageTitle.text();
    }
}
