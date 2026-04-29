
package demo.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import demo.utilities.CommonUtils;

public class Base_Class {

    public WebDriver driver;
    public CommonUtils utils;
    public static Properties config;
    public static WebDriverWait wait;

    // Reports
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    // ================= REPORT SETUP =================
    @BeforeSuite
    public void setupReport() {

        htmlReporter = new ExtentHtmlReporter(
                System.getProperty("user.dir") + "/Reports/Extent_" + getCurrentDateTime() + ".html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Execution Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    // ================= DRIVER SETUP =================
    @BeforeClass
    public void init() throws Exception {

        config = new Properties();
        File file = new File(System.getProperty("user.dir")
                + "\\src\\test\\resources\\config.properties");

        FileInputStream fis = new FileInputStream(file);
        config.load(fis);

        String browser = config.getProperty("Browser_Type");

        if (browser.equalsIgnoreCase("chrome")) 
        {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) 
        {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new SafariDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	utils=new CommonUtils(driver);

        driver.manage().window().maximize();
        driver.get(config.getProperty("URL"));
    }

    // ================= COMMON METHOD =================
    public String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return LocalDateTime.now().format(formatter);
    }

    // ================= TEARDOWN =================
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void reportGenerate() {
        extent.flush();
    }
}
/*package demo.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Base_Class 
{

	public WebDriver driver;
	public static Properties config;
	public static File f;
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static Actions action;
	public static String parent;
	
	//--Reports 
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite 
	public void setupReport() 
   {
	// for Reports initialization
	  	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/Extent_"+getCurrentDateTime()+".html");
       extent = new ExtentReports();
       extent.attachReporter(htmlReporter);
//        

       htmlReporter.config().setChartVisibilityOnOpen(true);
       htmlReporter.config().setDocumentTitle("Test Reports");
       htmlReporter.config().setReportName("Test Reports ");
       htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
       htmlReporter.config().setTheme(Theme.STANDARD);
   }
@BeforeClass
public void init() throws Exception
{
	//--For Reports Initialization
	
    
    
	config=new Properties();
	
	f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	fis=new FileInputStream(f);
	config.load(fis);
	
	if(config.getProperty("Browser_Type").equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(config.getProperty("Browser_Type").equals("edge"))
	{
		driver=new EdgeDriver();
	}
	else 	if(config.getProperty("Browser_Type").equals("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else 
	{
		driver = new SafariDriver();
	}
	
	//int implicitwait=Integer.parseInt(config.getProperty("implicitwait");
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitwait));

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	//wait = new WebDriverWait(driver,20);
	driver.manage().window().maximize();
	
	driver.get(config.getProperty("URL"));
	//test.log(Status.INFO, "Navigate to Application");
	//driver.get("https://testautomationpractice.blogspot.com/");
   
	action=new Actions(driver);
	parent =driver.getWindowHandle();
}

public String getCurrentDateTime() 
{
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
	 LocalDateTime now=LocalDateTime.now();
	 
	 return now.format(formatter);
}

//---Generic Methods For Any Automation Project 
//--If We Use Any Repeated Method in Our Project We Can Initialize once Here And Use Multiple Times In Our Project
public void enterData(WebElement element, String data)
{
	element.sendKeys(data);
}
public void Click(WebElement element)
{
	element.click();
}
public void hover(WebElement element)
{
	action.moveToElement(element).perform();
}
public void actionClick(WebElement element)
{
	action.moveToElement(element).click(element).build().perform();
}
public void selectByIndex(WebElement element, int index)
{
new Select(element).selectByIndex(index);	
}
public void deselectByIndex(WebElement element, int index)
{
new Select(element).deselectByIndex(index);	
}
public void selectByValue(WebElement element,String value)
{
new Select(element).selectByValue(value);	
}
public void deselectByValue(WebElement element, String Value)
{
new Select(element).deselectByValue(Value);	
}
public void SelectByVisualText(WebElement element, String Value)
{
new Select(element).selectByVisibleText(Value);	
}
public void deselectByVisbibleText(WebElement element, String Value)
{
new Select(element).deselectByVisibleText(Value);	
}
public void deselectAll(WebElement element)
{
  new Select(element).deselectAll();	
}
public WebElement firstSelectedOption(WebElement element)
{
WebElement Option=new Select(element).getFirstSelectedOption();
return Option;
}
public List<WebElement> allSelectedOptions(WebElement element)
{
	List<WebElement> options=new Select(element).getAllSelectedOptions();
	return options;
	
}
public void switchToAlertAccept()
{
Alert alert=driver.switchTo().alert();
//alert.getText();
alert.accept();
//alert.dismiss();
//alert.getText();
}
public void switchToAlertDismiss()
{
	Alert alert=driver.switchTo().alert();
	alert.dismiss();
	//alert.getText();
	
}
public void SwitchToFrameIndex(int index)
{
driver.switchTo().frame(index);	
}
public void switchToFrameByNameOrId(String nameOrId)
{
	driver.switchTo().frame(nameOrId);
}
public void switchToFrameByWebElement(WebElement element)
{
driver.switchTo().frame(element);
}
public void SwitchToParentFrame()
{
driver.switchTo().parentFrame();	
}
public void switchToParentWindow(String parent)
{
driver.switchTo().window(parent);	
}
public void switchToChildWindow()
{
Set<String> childs=driver.getWindowHandles();
Iterator<String> it=childs.iterator();
while(it.hasNext())
{
	String child=it.next();
    if(!parent.equals(child))
    {
    	driver.switchTo().window(child);
    	break;
    }
}
}


@AfterMethod
public void getResult(ITestResult result)
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Test Case Failed Due To Below Issues ", ExtentColor.RED));
		test.fail(result.getThrowable());
	}
	else if (result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Test Case Passed ", ExtentColor.GREEN));
		
	}
	else
	{
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"Test Case Skipped", ExtentColor.ORANGE));
		test.skip(result.getThrowable());
	
	}
	
}

public void Screenshots(String filename)

{
String screenshotPath=System.getProperty("user.dir")+"/Scressnshots/"+getCurrentDateTime()+filename+".png";
File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File destFile=new File(screenshotPath);

try
{
	FileUtils.copyFile(srcFile, destFile);
}
catch(Exception e)

{
	e.printStackTrace();
}
}
@AfterClass
public void terdown()
{
	if (driver != null) 
	{
         driver.quit();
	}
  
}

@AfterSuite
public void reportGenerate()
{
	System.out.println("In Report Generate");
	extent.flush();
}


}*/
