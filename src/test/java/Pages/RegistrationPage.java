package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends BasePage {
    private SelenideElement firstNameField = $("[id=firstname]");
    private SelenideElement lastNameField = $("[id=lastname]");
    private SelenideElement emailField = $("[id=email_address]");
    private SelenideElement passwordField = $("[id=password]");
    private SelenideElement confirmPasswordField = $("[id=password-confirmation]");
    private SelenideElement createAnAccountButton = $(By.xpath("//button[@class='action submit primary']"));

    public RegistrationPage(String pageUrl) {
        super(pageUrl);
    }

    public void enterFirstName(String firstName) {
        firstNameField.shouldBe(visible);
        firstNameField.setValue(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.setValue(lastName);
    }

    public void enterEmail(String email) {
        emailField.setValue(email);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    public void enterPasswordConfirmation(String password) {
        confirmPasswordField.setValue(password);
    }

    public CustomerInfoPage OpenCustomerAccount(){
        createAnAccountButton.click();
        return new CustomerInfoPage("https://magento.softwaretestingboard.com/customer/account/");
    }
}
