package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class SearchHomePage {
	
	public SearchHomePage() {
		PageFactory.initElements(BaseClass.getDriver(),this);
	}
	
	@FindBy(id="searchval")
	public WebElement searchBox;
	
	@FindBy(xpath="//button[text()='Search']")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[@id='product_listing']//a[contains(text(), 'Table')]")
	public List <WebElement> allProducts;
	
	
	@FindBy(xpath="//input[@type='submit'][@name = 'addToCartButton']")
	public List<WebElement> addToCart;
	
	@FindBy(xpath = "//span[text()='Cart']")
	public WebElement Cart;
	
	@FindBy(xpath="//button[text()='Empty Cart']")
	public WebElement emptyCartbutton;
	
	@FindBy(xpath="//div[@class='notification-fader open']")
	public WebElement notificationPopUp;
	
	@FindBy(xpath="//button[contains(text(), 'Empty') and contains(@class, 'green')]")
	public WebElement greenEmptyCart;
	
	@FindBy(xpath="//p[contains(text(), 'Your cart is empty')]")
	public WebElement yourCartIsEmpty;

}
