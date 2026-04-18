package demo.TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demo.base.Base_Class;
import demo.pages.demo_locator;

public class TC_002_Click_On_LaptopTest extends Base_Class 
{
@Test 
public void verify_Laptops()
{
	test =extent.createTest("Verify Laptops")
			.assignCategory("Positive Testing")
			.assignAuthor("Narendra");
	
	demo_locator demo=new demo_locator(driver);
	// --- Click on Laptops properly
    // WebElement laptopsTab = driver.findElement(By.xpath("//a[contains(@onclick,'notebook')]"));

      // Capture old first product BEFORE click
      String oldFirstProduct = driver.findElement(
              By.xpath("(//div[@class='card-block']//h4)[1]")).getText();

      // Wait until clickable
      wait.until(ExpectedConditions.elementToBeClickable(demo.laptops));

      // Click laptops
        // laptopsTab.click();
      utils.click(demo.laptops);

      // Wait until products refresh
      wait.until(ExpectedConditions.not(
              ExpectedConditions.textToBePresentInElementLocated(
                      By.xpath("(//div[@class='card-block']//h4)[1]"),
                      oldFirstProduct)));
      
      test.log(Status.INFO,"All Laptop products should visible");

}
}
