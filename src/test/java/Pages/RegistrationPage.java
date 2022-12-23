package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

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

    public void registerAsUser (String firstName, String lastName, String email,
                                String password) {
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        emailField.setValue(email);
        passwordField.setValue(password);
        confirmPasswordField.setValue(password);
    }

    public CustomerInfoPage OpenCustomerAccount(){
        createAnAccountButton.click();
        return new CustomerInfoPage("https://magento.softwaretestingboard.com/customer/account/");
    }
}
