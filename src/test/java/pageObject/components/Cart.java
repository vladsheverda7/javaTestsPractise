package pageObject.components;

import core.elements.BaseElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;

public class Cart {
    private BaseElement itemQty = new BaseElement(By.xpath("//span[@class='counter-number']"));

    private BaseElement counterQty = new BaseElement(By.xpath("//span[@class='counter qty']"));

    public String getCartQty(){
        counterQty.getElement().should(appear);
        return itemQty.getText();
    }
}
