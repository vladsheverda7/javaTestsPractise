package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    protected String pageUrl;

    public BasePage(String pageUrl){
        this.pageUrl = pageUrl;
    }

    public void open() {
        Selenide.open(pageUrl);
    }

    public SelenideElement getElement(String locator){
        return $(By.xpath(locator));
    }
}
