package demo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {

    WebDriver driver;
    Actions action;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void enterData(WebElement element, String data) {
        element.sendKeys(data);
    }

    public void hover(WebElement element) {
        action.moveToElement(element).perform();
    }

    public void actionClick(WebElement element) {
        action.moveToElement(element).click().perform();
    }
}