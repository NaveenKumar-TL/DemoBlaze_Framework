package demo.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {

    public static void selectByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    public static void selectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    public static void selectByVisibleText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }
}