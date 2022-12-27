package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage  {
    private SelenideElement emailField = $("[id=email]");;
    private SelenideElement passwordField = $("[id=pass]");
    private SelenideElement signInButton = $("[id=send2]");
    private SelenideElement headerLink = $(".customer-welcome");
    private SelenideElement signOut = $(".authorization-link");


    public void enterUserName(String username){
        emailField.setValue(username);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }


    public void userSignOut(){
        headerLink.click();
        signOut.click();
    }
}
