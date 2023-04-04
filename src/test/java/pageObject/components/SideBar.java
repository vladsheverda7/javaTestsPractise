package pageObject.components;

import core.elements.BaseElement;
import org.openqa.selenium.By;

public class SideBar {
    private BaseElement jacket = new BaseElement(By.xpath("//div[@class='categories-menu']//li/a[contains(@href,'/jackets')]"),
            "jacket");

    private BaseElement pants = new BaseElement(By.xpath("//div[@class='categories-menu']//li/a[contains(@href,'/pants')]"),
            "pants");

    private BaseElement tees = new BaseElement(By.xpath("//div[@class='categories-menu']//li/a[contains(@href,'/tees')]"),
            "tees");

    public void selectJacketCategory(){
        jacket.click();
    }

    public void selectPantsCategory() {
        pants.click();
    }

    public void selectTeesCategory(){
        tees.click();
    }
}
