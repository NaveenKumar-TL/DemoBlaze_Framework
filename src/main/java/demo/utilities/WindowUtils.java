package demo.utilities;

import java.util.Set;
import org.openqa.selenium.WebDriver;

public class WindowUtils {

    public static void switchToChildWindow(WebDriver driver, String parent) {

        Set<String> windows = driver.getWindowHandles();

        for (String win : windows) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
                break;
            }
        }
    }

    public static void switchToParentWindow(WebDriver driver, String parent) {
        driver.switchTo().window(parent);
    }
}