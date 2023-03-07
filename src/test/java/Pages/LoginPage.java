package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage  {
    private SelenideElement emailField = $("[id=email]");;
    private SelenideElement passwordField = $("[id=pass]");
    private SelenideElement signInButton = $("[id=send2]");

    private SelenideElement headerLink = $(".customer-welcome");
    private SelenideElement signOut = $(".authorization-link");
    private SelenideElement welcomeMessage = $(By.xpath("//header//span[@class='logged-in']"));

    public void loginAsUser(String username, String password) {
        emailField.setValue(username);
        passwordField.setValue(password);
        signInButton.click();
    }

    public void logOut() {
        headerLink.click();
        signOut.click();
    }

    public String getWelcomeMessage(){
        return welcomeMessage.text();
    }
}
