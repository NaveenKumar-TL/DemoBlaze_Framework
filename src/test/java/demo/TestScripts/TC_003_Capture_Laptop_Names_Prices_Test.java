package demo.TestScripts;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demo.base.Base_Class;
import demo.pages.demo_locator;

public class TC_003_Capture_Laptop_Names_Prices_Test extends Base_Class
{
	@Test(priority=0)
	public void VerifyLaptop()
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
@Test(priority=1, dependsOnMethods="VerifyLaptop")
public void Verify_LaptopDetails()
{
	test =extent.createTest("Verify Laptops")
			.assignCategory("Positive Testing")
			.assignAuthor("Narendra");
	
	demo_locator demo=new demo_locator(driver);
	
	 //----Capture all Names and Prices
    List<String> laptopList = new ArrayList<>();
    List<Integer> priceList = new ArrayList<>();
    Map<String , Integer> laptopPriceMap=new LinkedHashMap<>();
    
    Assert.assertTrue(laptopList.isEmpty());

    List<WebElement> products =
            driver.findElements(By.xpath("//div[@class='card-block']"));

    for(int i = 0; i < products.size(); i++)
    {
        String name = products.get(i)
                .findElement(By.tagName("h4")).getText();

        String price = products.get(i)
                .findElement(By.tagName("h5")).getText();

        if(price == null || price.isEmpty()) continue;

        String numericPrice = price.replace("$", "").trim();
        int priceValue = Integer.parseInt(numericPrice);

        laptopPriceMap.put(name, priceValue);
    }
    /*
    while(true)
    {
        // Always fetch fresh elements
        List<WebElement> products =
                driver.findElements(By.xpath("//div[@class='card-block']"));

        if(products.size() == 0)
            break;

        // Capture first product name (for wait condition)
        String firstProductName =
                products.get(0).findElement(By.tagName("h4")).getText();

        // Iterate using index (avoids stale)
        for(int i = 0; i < products.size(); i++)
        {
            List<WebElement> freshProducts =
                    driver.findElements(By.xpath("//div[@class='card-block']"));

            String name = freshProducts.get(i)
                    .findElement(By.tagName("h4")).getText();

            String price = freshProducts.get(i)
                    .findElement(By.tagName("h5")).getText();
            
            //----convert prices TO int
            String numericPrice = price.replace("$", "").trim();
            int priceValue = Integer.parseInt(numericPrice);
            //---Sorting logic Using Map
            laptopPriceMap.put(name, priceValue);
            priceList.add(priceValue);//----
            
            String laptopDetails = name + " - " + price;

            if(!laptopList.contains(laptopDetails))
            {
                laptopList.add(laptopDetails);

                // Console print
                System.out.println(laptopDetails);

                // Extent report print
                test.log(Status.INFO, laptopDetails);
            }
        }
     }
     */
    
  }
}
