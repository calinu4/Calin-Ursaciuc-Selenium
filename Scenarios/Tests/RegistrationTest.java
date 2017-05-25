package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

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

public class RegistrationTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	Home3 homePage;
	Registration registration;
   Account account;
	 String userName = "";
	final String password = "testing1990";
     int rand1,rand2;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Profile\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.hive.co.uk/");
		Random rand=new Random();
		rand1=rand.nextInt(1000000);
		rand2=rand.nextInt(1000000);
		userName="testing"+rand1+"@"+"testing"+rand2+".com";
		
	}

	@Test
	public void testRegistrationLogin() {
        //The purchase of a product will be tested only to the point of adding a payment method
		report = AllTests.report1;//new ExtentReports("C:\\extent1.html", true);
		// start the test
		test = report.startTest("Registration Scenario");
		test.log(LogStatus.INFO, "Browser started");
		//Test the home page title and search for sign in button which will redirect to create account as well
		homePage = new Home3(driver);
		String homePageTitle = homePage.getTitle();
		if(homePageTitle.equals("Hive.co.uk - Books, eBooks, DVDs, Blu-ray, Stationery, Music CDs"))
			test.log(LogStatus.PASS, "verify Title of the Home page");
		else
			test.log(LogStatus.FAIL, "verify Title of the Home page");
		String loginTitle=homePage.getLoginTitle();
		if(loginTitle.equals("Sign In Or Register"))
			test.log(LogStatus.PASS, "verify Title of the Login page");
		else
			test.log(LogStatus.FAIL, "verify Title of the Login page");
		homePage.clickLogin();
		
		
		//Enter all details and create new account
		registration=new Registration(driver);
		String regTitle=registration.getTitle();
		if(regTitle.equals("hive.co.uk Log on"))
			test.log(LogStatus.PASS, "verify Title of the registration page");
		else
			test.log(LogStatus.FAIL, "verify Title of the registration page");
		registration.setEmail(userName);
		registration.setNotRegistered();
		registration.setTitleSelection();
		registration.setFirstName("Firsttest");
		registration.setLastName("Testing");
		registration.setPassword("testing1990");
        registration.clickCreate();
        
        //
        account=new Account(driver);
        String helloTitle=account.getHello();
        if(helloTitle.equals("Hello Firsttest,"))
        	test.log(LogStatus.PASS, "verify registration has been successfull");
		else
			test.log(LogStatus.FAIL, "verify registration has been successfull");
        account.clickLogout();
        
	    report.endTest(test);
	    report.flush();
        
	    
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