package demo.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demo.base.Base_Class;
import demo.utilities.ScreenshotUtils;

public class TC_001_Launch_BroserTest extends Base_Class
{
@Test 
public void VerifyTitle()
{
test =extent.createTest("Launching_Broser")
.assignCategory("Positive Testing")
.assignAuthor("Narendra");
try
{
test.log(Status.INFO,
		"Navigating to " + driver.getTitle()+ "page");
  Assert.assertTrue(driver.getTitle().contains("STORE"));
}
catch(Exception e)
{
test.log(Status.FAIL, e.getMessage());
ScreenshotUtils.takeScreenshot(driver, "Demo1");
Assert.fail(e.getMessage());
}
}
}
