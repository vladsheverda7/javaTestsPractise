package pageObject.pages;

import core.Constants;
import core.Navigation;
import core.elements.BaseElement;
import org.openqa.selenium.By;
import pageObject.components.NavigationBar;
import pageObject.components.SideBar;

import static com.codeborne.selenide.Condition.visible;

public class LandingPage {
    private NavigationBar navigationBar = new NavigationBar();
    private BaseElement dropdownIcon = new BaseElement(By.xpath("//span[contains(@class,'ui-menu-icon')]"),
            "dropdownIcon");
    private SideBar sideBar = new SideBar();

    public void open(){
        Navigation.open(Constants.BASE_URL);
        waitForPageToLoad();
    }

    private void waitForPageToLoad(){
        dropdownIcon.getElement().shouldBe(visible);
    }

    public void selectMenJackets(){
        navigationBar.selectMenNavigationMenuItem();
        sideBar.selectJacketCategory();
    }

    public void selectMenPants() {
        navigationBar.selectMenNavigationMenuItem();
        sideBar.selectPantsCategory();
    }

    public void selectWomenTees(){
        navigationBar.selectWomenNavigationMenuItem();
        sideBar.selectTeesCategory();
    }
}
