package tests;

import Pages.CustomerInfoPage;
import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RegistrationTest {

    RegistrationPage registrationPage = new RegistrationPage("https://magento.softwaretestingboard.com/customer/account/create/");
    private String urlAfterRegistration = "https://magento.softwaretestingboard.com/customer/account/";

    private String GenerateRandomEmail(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "username"+ randomInt +"@gmail.com";
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void RegistrationFlow() {
        registrationPage.Open();
        registrationPage.registerAsUser("vs_firstName1", "vs_lastName1", GenerateRandomEmail(), "vs_passWord1!");
        CustomerInfoPage customerInfo = registrationPage.OpenCustomerAccount();
        customerInfo.VerifyPageTitle("My Account");
    }
}
