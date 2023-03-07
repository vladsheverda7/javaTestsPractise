package Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends  BasePage  {

    public LoginPage(String pageUrl) {
        super(pageUrl);
    }

    private SelenideElement emailField = $("[id=email]");;
    private SelenideElement passwordField = $("[id=pass]");
    private SelenideElement signInButton = $("[id=send2]");


    public void loginAsUser(String username, String password) {
        emailField.setValue(username);
        passwordField.setValue(password);
        signInButton.click();
    }
}
