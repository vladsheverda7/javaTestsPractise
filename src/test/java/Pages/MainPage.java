package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private SelenideElement signInButton = $(".authorization-link");

    public MainPage(String pageUrl) {
        super(pageUrl);
    }

    public LoginPage ClickLoginButton() {
        signInButton.click();
        return new LoginPage();
    }
}
