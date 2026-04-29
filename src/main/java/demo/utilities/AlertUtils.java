package demo.utilities;

import org.openqa.selenium.WebDriver;

public class AlertUtils {

    public static void acceptAlert(WebDriver driver) 
    {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver)
    {
        driver.switchTo().alert().dismiss();
    }
    public static void getTxt(WebDriver driver)
    {
    	driver.switchTo().alert().getText();
    }
    
}