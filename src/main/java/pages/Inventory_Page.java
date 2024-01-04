package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class Inventory_Page extends TestBase
{

	//Object Repository
	@FindBy(xpath="//span[text()='Products']") private WebElement productLable;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-backpack']")private WebElement backpackproduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement bikelightproduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtproduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketproduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie']") private WebElement onesieproduct;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement tshirtredproduct;
	
	//identifying AddToCart Icon present on webpage.
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon; 
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartcount;
	
	// identifying logo/links present on webpage.
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement LinkedInlogo;
	
	//identifying texts present on webpage
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement textPresentOnWebpage; 
	
	//identifying filter for products dropdown present on webpage.
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement productdropdown; 
	
	//identifying remove button  present on webpage.
	@FindBy(xpath = "//button[@name='remove-sauce-labs-backpack']") private WebElement backpackremoveproduct;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-bike-light']") private WebElement bikelightremoveproduct;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtremoveproduct;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-fleece-jacket']") private WebElement jacketremoveproduct;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-onesie']") private WebElement onesieremoveproduct;
	@FindBy(xpath="//button[@name='remove-test.allthethings()-t-shirt-(red)']") private WebElement tshirtredremoveproduct;
	

	//constructor
	public Inventory_Page() 
	{
		PageFactory.initElements(driver,this);
	}
	
	//methods
	public String verifyProductlable() 
	{
		return productLable.getText(); 
		
	}
	
	public String verifytextPresentonPage() 
	{
		return textPresentOnWebpage.getText();
		
	}
	
	public boolean verifyTwitterLogo() //to check whether twitter logo is present
	{
		
		return TwitterLogo.isDisplayed(); //data type boolean
		
	}
	
	public boolean verifyFacebooklogo()//to check whether twitter logo is present 
	{
		return FacebookLogo.isDisplayed();//data type boolean
		
	}
	
	public boolean verifyLinkedInLogo() //to check whether twitter logo is present
	{
		return LinkedInlogo.isDisplayed(); //data type boolean
		
	}
	
	public String add6products() 
	{
		
		backpackproduct.click(); // click on add product to check functionality of Add to cart button
		bikelightproduct.click();
		boltTshirtproduct.click();
		jacketproduct.click();
		onesieproduct.click();
		tshirtredproduct.click();
		return cartcount.getText(); // getting text of cart count as it'll change as we add products in it.
		
	}
	
	public String remove2products() 
	{
		add6products();
		boltTshirtremoveproduct.click();
		onesieremoveproduct.click();
		return cartcount.getText();
		
	}
	public void clickoncartIcon() 
	{
		cartIcon.click();
	}
	
		

	
	
	
}
