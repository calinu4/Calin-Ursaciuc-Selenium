package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotSame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.*;

public class AmazonPurchaseTest {
	WebDriver driver;

	
	Home2 homePage;
	Results results;
	ProductPage product;
	Basket basket;
	Login2 login;
	DeliveryAddress address;
	DeliveryOptions options;

	final String userName = "justtesting1990@outlook.com";
	final String password = "testing1990";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Profile\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.co.uk/");
	}

	@Test
	public void testPurchases() {
        //The purchase of a product will be tested only to the point of adding a payment method
		
		//Test the home page title match with expected title from Amazon.co.uk
		homePage = new Home2(driver);
		String homePageTitle = homePage.getTitle();
		assertEquals(homePageTitle, "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more");
		
        //put the keywords into the search box then check if the value of search button is Go and click on it
		homePage.setSearchInput();
		String searchButtonTitle=homePage.getButtonTitle();
		assertTrue(searchButtonTitle.contains("Go"));
		homePage.clickSearchButton();
		
		//Results Page test if the title reflects our search keywords entered earlier on
		results=new Results(driver);
		String resultsTitle=results.getTitle();
		assertEquals(resultsTitle, "Amazon.co.uk: cabin bag");
		results.clickFirstProduct();
		
		//Product Page Title we expect no to be the same as results title otherwise we didn't click on a product
		product=new ProductPage(driver);
		String productTitle=product.getTitle();
		assertNotSame(productTitle,resultsTitle);
		String addText=product.getAddButtonText();
		//If we have a add to basket button we click on it
		assertTrue(addText.contains("Add to Basket"));
		product.addToBasket();
		
		//Shopping Basket Page Confirmation
		basket=new Basket(driver);
		String basketTitle=basket.getTitle();
		assertEquals(basketTitle,"Amazon.co.uk Shopping Basket");
		String proceedText=basket.getProceedTitle();
		assertEquals(proceedText,"Proceed to checkout");
		basket.proceedToCheckout();
		
		//Go to Login Page ,enter the details and click sign in
		login=new Login2(driver);
		String loginTitle=login.getTitle();
		assertEquals(loginTitle,"Amazon Sign In");
		login.setEmail(userName);
		login.setPassword(password);
		login.clickSignIn();
		
		//Select Delivery address
		address=new DeliveryAddress(driver);
		String deliveryTitle=address.getTitle();
		assertEquals(deliveryTitle,"Select a delivery address");
		String deliveryButton=address.getDeliveryButton();
		assertEquals(deliveryButton,"Deliver to this address");
		address.selectDeliveryAddress();
		
		//Select a delivery option and click continue---This will be the final stage as we don't actually add a payment method
		
		options=new DeliveryOptions(driver);
		String optionsTitle=options.getTitle();
		assertEquals(optionsTitle,"Select Delivery Options - Amazon.co.uk Checkout");
		String continueTitle=options.getButton();
		assertEquals(continueTitle,"Continue");
		options.clickContinue();
		
		
		
		
		
		
	}

	@After
	public void tearDown() {
		try {
			driver.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}