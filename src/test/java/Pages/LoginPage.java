package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage  {
    private SelenideElement emailField = $("[id=email]");;
    private SelenideElement passwordField = $("[id=pass]");
    private SelenideElement signInButton = $("[id=send2]");

    private SelenideElement headerLink = $(".customer-welcome");
    private SelenideElement signOut = $(".authorization-link");

    public void loginAsUser(String username, String password) {
        emailField.setValue(username);
        passwordField.setValue(password);
        signInButton.click();
    }

    public void logOut() {
        headerLink.click();
        signOut.click();
    }
}
