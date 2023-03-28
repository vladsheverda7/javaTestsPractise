package pageObject.components;

import core.elements.BaseElement;
import org.openqa.selenium.By;

public class SideBar {
    private BaseElement jacket = new BaseElement(By.xpath("//div[@class='categories-menu']//li/a[contains(@href,'/jackets')]"));

    private BaseElement pants = new BaseElement(By.xpath("//div[@class='categories-menu']//li/a[contains(@href,'/pants')]"));

    private BaseElement tees = new BaseElement(By.xpath("//div[@class='categories-menu']//li/a[contains(@href,'/tees')]"));

    public void selectJacketCategory(){
        jacket.click();
    }

    public void selectPants() {
        pants.click();
    }

    public void selectTeesCategory(){
        tees.click();
    }
}
