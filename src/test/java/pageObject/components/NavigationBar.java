package pageObject.components;

import core.elements.BaseElement;
import org.openqa.selenium.By;

public class NavigationBar {
    private BaseElement menNavigationLink = new BaseElement(By.xpath("//div[@class='sections nav-sections']//li/a[contains(@href,'/men')]"),
            "menNavigationLink");

    private BaseElement womenNavigationLink = new BaseElement(By.xpath("//div[@class='sections nav-sections']//li/a[contains(@href,'/women')]"),
            "womenNavigationLink");

    public void selectMenNavigationMenuItem(){
        menNavigationLink.click();
    }

    public void selectWomenNavigationMenuItem(){
        womenNavigationLink.click();
    }
}
