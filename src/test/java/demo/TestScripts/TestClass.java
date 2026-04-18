package demo.TestScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demo.base.Base_Class;
import demo.pages.demo_locator;
import demo.utilities.AlertUtils;
import demo.utilities.DataProvide;
import demo.utilities.ScreenshotUtils;

public class TestClass extends Base_Class 
{

	@Test(dataProvider="orderData", dataProviderClass=DataProvide.class)
	public void Dynamic_Selection(String nam, String Country, String city,
			String card, String month,String year)
	{
	    test = extent.createTest("Verify Demo Blaze")
	            .assignCategory("Postive_Testing")
	            .assignAuthor("Narendra");

	    try
	    {
	    	 demo_locator demo=new demo_locator(driver);   
	        test.log(Status.INFO, "Navigating To " + driver.getTitle() + " Page");

	        Assert.assertTrue(driver.getTitle().contains("STORE"));
         }
	    catch(Exception e)
	    {
	    	 test.log(Status.FAIL, e.getMessage());
	    	 ScreenshotUtils.takeScreenshot(driver, "DemoBl");
	    	 Assert.fail(e.getMessage());

	    }
	    }
}