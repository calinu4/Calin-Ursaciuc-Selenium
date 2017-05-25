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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.*;

public class AmazonPurchaseTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
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
		report =AllTests.report1;// new ExtentReports("C:\\extent1.html", true);
		// start the test
		test = report.startTest("Amazon Scenario New");
		//Test the home page title match with expected title from Amazon.co.uk
		homePage = new Home2(driver);
		String homePageTitle = homePage.getTitle();
		if(homePageTitle.equals("Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more"))
				test.log(LogStatus.PASS, "verify Title of the Home Page");
	    else
	    	test.log(LogStatus.FAIL, "verify Title of the Home Page");
		
        //put the keywords into the search box then check if the value of search button is Go and click on it
		homePage.setSearchInput();
		String searchButtonTitle=homePage.getButtonTitle();
		if(searchButtonTitle.equals("Go"))
			test.log(LogStatus.PASS, "verify value of Search Button");
	    else
	    	test.log(LogStatus.FAIL, "verify value of Search Button");
		homePage.clickSearchButton();
		
		//Results Page test if the title reflects our search keywords entered earlier on
		results=new Results(driver);
		String resultsTitle=results.getTitle();
		if(resultsTitle.equals("Amazon.co.uk: cabin bag"))
			test.log(LogStatus.PASS, "verify title of results page");
	    else
	    	test.log(LogStatus.FAIL, "verify title of results page");
		results.clickFirstProduct();
		
		//Product Page Title we expect no to be the same as results title otherwise we didn't click on a product
		product=new ProductPage(driver);
		String productTitle=product.getTitle();
		if(productTitle!=resultsTitle)
			test.log(LogStatus.PASS, "verify title of current page is different than previous page");
	    else
	    	test.log(LogStatus.FAIL, "verify title of current page is different than previous page");
		String addText=product.getAddButtonText();
		//If we have a add to basket button we click on it
		if(addText.equals("Add to Basket"))
			test.log(LogStatus.PASS, "verify Add to Basket button is present");
	    else
	    	test.log(LogStatus.FAIL, "verify Add to Basket button is present");
		product.addToBasket();
		
		//Shopping Basket Page Confirmation
		basket=new Basket(driver);
		String basketTitle=basket.getTitle();
		if(basketTitle.equals("Amazon.co.uk Shopping Basket"))
			test.log(LogStatus.PASS, "verify title of shopping basket page");
	    else
	    	test.log(LogStatus.FAIL, "verify title of shopping basket page");
		String proceedText=basket.getProceedTitle();
		if(proceedText.equals("Proceed to checkout"))
			test.log(LogStatus.PASS, "verify title of shopping basket page");
	    else
	    	test.log(LogStatus.FAIL, "verify title of shopping basket page");
		basket.proceedToCheckout();
		
		//Go to Login Page ,enter the details and click sign in
		login=new Login2(driver);
		String loginTitle=login.getTitle();
		if(loginTitle.equals("Amazon Sign In"))
			test.log(LogStatus.PASS, "verify title of login page");
	    else
	    	test.log(LogStatus.FAIL, "verify title of login page");
		login.setEmail(userName);
		login.setPassword(password);
		login.clickSignIn();
		
		//Select Delivery address
		address=new DeliveryAddress(driver);
		String deliveryTitle=address.getTitle();
		if(deliveryTitle.equals("Select a delivery address"))
			test.log(LogStatus.PASS, "verify title of delivery address page");
	    else
	    	test.log(LogStatus.FAIL, "verify title of delivery address page");
		
	    report.endTest(test);
	    report.flush();
		/*
		String deliveryButton=address.getDeliveryButton();
	//	assertEquals(deliveryButton,"Deliver to this address");
		address.selectDeliveryAddress();
		
		//Select a delivery option and click continue---This will be the final stage as we don't actually add a payment method
		
		options=new DeliveryOptions(driver);
		String optionsTitle=options.getTitle();
		assertEquals(optionsTitle,"Select Delivery Options - Amazon.co.uk Checkout");
		String continueTitle=options.getButton();
		assertEquals(continueTitle,"Continue");
		options.clickContinue();
		
		*/
		
		
		
		
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