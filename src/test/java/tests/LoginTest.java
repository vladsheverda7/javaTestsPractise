package tests;

import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.Configuration;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import org.json.simple.parser.JSONParser;

public class LoginTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage("https://magento.softwaretestingboard.com/");

    Object obj;
    {
        try {
            obj = new JSONParser().parse(new FileReader("src/test/userInformation.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    JSONObject jo = (JSONObject) obj;
    String email = (String) jo.get("email");
    String password = (String) jo.get("password");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void LoginFlow() {
        mainPage.Open();
        mainPage.ClickLoginButton();
        loginPage.loginAsUser(email, password);
    }
}
