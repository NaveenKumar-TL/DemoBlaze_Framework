package demo.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class demo_locator 
{
	
	public WebDriver driver;
       WebDriverWait wait;	
       
	public demo_locator(WebDriver driver) 
	{
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	public WebElement home;
	
	@FindBy(xpath="//a[contains(@onclick,'phone')]")
	public WebElement phones;
	
@FindBy(xpath="//a[contains(@onclick,'notebook')]")
public WebElement laptops;

@FindBy(xpath="//div[@class='card-block']")
public List<WebElement> products;

@FindBy(xpath="//button[@id='next2']")
public WebElement next;

@FindBy(xpath="(//h4[@class='card-title']//a[@class='hrefch'])[5]")
public WebElement Asus;

@FindBy(xpath="//a[@id='cartur']")
public WebElement cart;

@FindBy(linkText="Add to cart")
public WebElement addToCartBtn;

public By cartProducts =By.xpath("//tbody[@id='tbodyid']//td[2]");

@FindBy(xpath="(//div[@class='col-lg-1'])//button")
public WebElement Place_Order;

@FindBy(xpath="//tbody[@id='tbodyid']//tr//td[3]")
public List<WebElement> cartPrice;

@FindBy(id="totalp")
public WebElement total;

@FindBy(xpath="//div[@class='col-lg-1']//button")
public WebElement PlaceOrder;

@FindBy(xpath="(//div[@class='form-group'])//input[@id='name']")
public WebElement PO_Name;

@FindBy(id="country")
public WebElement Po_Country;

@FindBy(id="city")
public WebElement Po_City;

@FindBy(id="card")
public WebElement Po_CreditCard;

@FindBy(id="month")
public WebElement Po_Month;

@FindBy(id="year")
public WebElement Po_Year;

@FindBy(xpath="//button[@onclick='purchaseOrder()']")
public WebElement purchase;

@FindBy(xpath="//div[@class='sa-confirm-button-container']")
public WebElement ok;

@FindBy(xpath="(//button[text()='Close'])[3]")
public WebElement Po_close;

public String clickOnProduct(String productName) 
{
    By product = By.xpath("//a[text()='" + productName + "']");
    wait.until(ExpectedConditions.elementToBeClickable(product)).click();
  return productName;
}
public List<String> getCartProductNames() 
{

    List<String> names = new ArrayList<>();

    List<WebElement> elements = driver.findElements(cartProducts);

    for (WebElement e : elements)
    {
        names.add(e.getText());
    }

    return names;
}

public int calcartTotal()
{
	int total=0;
	
		for(WebElement price: cartPrice)
		{
			total+= Integer.parseInt(price.getText().trim());
		}
	
	return total;
	
}

public int getDisplayedTotal()
{
	return Integer.parseInt(total.getText().trim());
}

}