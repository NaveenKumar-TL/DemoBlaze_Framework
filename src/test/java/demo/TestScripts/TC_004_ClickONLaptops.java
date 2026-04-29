package demo.TestScripts;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demo.base.Base_Class;
import demo.pages.laptop;

public class TC_004_ClickONLaptops extends Base_Class
{
laptop lap;

@BeforeMethod
public void Setup(Method method)
{
	
	test=extent.createTest(method.getName())
			.assignCategory("Positive Testing")
			.assignAuthor("Narendra");
	lap=new laptop(driver);
}

@Test 
public void ClickOnLaptop()
{
	//---Click On Laptops
	utils.click(lap.Laptop);
	wait.until(ExpectedConditions.visibilityOf(lap.Next_b));
	//-- Scroll To View Avaialble Laptops loaded or not 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", lap.Next_b);
test.log(Status.PASS,"Laptop Products Is Visible");
}

}
