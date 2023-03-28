package core.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BaseElement {
    private SelenideElement element;

    public BaseElement(By locator){
        element = $(locator);
    }

    public SelenideElement getElement(){
        return element;
    }

    public void click(){
        element.click();
    }

    public String getText(){
        return element.getText();
    }

}
