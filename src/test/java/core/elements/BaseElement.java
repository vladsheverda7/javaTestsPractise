package core.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import tests.AddingRemovingItemTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;

public class BaseElement {
    private SelenideElement element;
    private String elementName;
    Logger logger = Logger.getLogger(BaseElement.class.getName());

    public BaseElement(By locator, String name){
        element = $(locator);
        elementName = name;
    }

    public SelenideElement getElement(){
        readLogConfiguration();
        logger.info(String.format("get %s", elementName));
        return element;
    }

    public void click(){
        readLogConfiguration();
        logger.info(String.format("Click %s", elementName));
        element.click();
    }

    public String getText(){
        readLogConfiguration();
        logger.info(String.format("get text of the %s", elementName));
        return element.getText();
    }

    public void readLogConfiguration(){
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/log.properties");
            LogManager.getLogManager().readConfiguration(fis);
            fis.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
