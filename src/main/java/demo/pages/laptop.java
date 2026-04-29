package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class laptop
{
	public WebDriver driver;
	 
	public laptop(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy (xpath="//a[contains(@onclick,'notebook')]")
public WebElement Laptop;

@FindBy(xpath="//button[text()='Next']")
public WebElement Next_b;
}