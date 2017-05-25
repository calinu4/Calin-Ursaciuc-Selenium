package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.Home1;
import Pages.Login1;
import Pages.AccountPage;;
public class LoginTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	Login1 loginPage;
	Home1 homePage;
	AccountPage accountPage;
	final String userName = "justtesting1990@outlook.com";
	final String password = "testing1990";
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Profile\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.mouseprice.com/");
	}
	@Test
	public void testLoginLogout() {
		report = AllTests.report1;//new ExtentReports("C:\\extent1.html", true);
		// start the test
		test = report.startTest("Login Scenario");
		test.log(LogStatus.INFO, "Browser started");
		homePage = new Home1(driver);
		String homePageTitle = homePage.getTitle();
		if(homePageTitle.equals("Land Registry Sold House Prices and Property Valuations – Mouseprice.com"))
			test.log(LogStatus.PASS, "verify Title of the Home Page");
	    else
	    	test.log(LogStatus.FAIL, "verify Title of the Home Page");
		homePage.clickSignInLink();

		loginPage = new Login1(driver);
		//check we're on the login page
		String loginTitle = loginPage.getTitle();
		if(loginTitle.equals("Login - Mouseprice"))
			test.log(LogStatus.PASS, "verify Title of Login Page");
	    else
	    	test.log(LogStatus.FAIL, "verify Title of Login Page");
		//set email and password
	    loginPage.setEmail(userName);
	    loginPage.setPassword(password);
	   
		//click sign in button
	    loginPage.clickSignIn();
	    
	    //check user is logged in and go to account area then logout
	    accountPage=new AccountPage(driver);
	    
	    String logouttext=accountPage.getLogoutText();
	    if(logouttext.equals("Logout"))
	    	test.log(LogStatus.PASS, "verify Logout button is present");
	    else
	    	test.log(LogStatus.FAIL, "verify Logout button is present");
	    accountPage.clickAccountLink();
	    String areaTitle=accountPage.getTitle();
	    if(areaTitle.equals("Account Details - Mouseprice"))
	    	test.log(LogStatus.PASS, "verify Account Details Page Title");
	    else
	    	test.log(LogStatus.FAIL, "verify Account Details Page Title");
	    
	    accountPage.clickLogout();
	        loginTitle=accountPage.getTitle();
	    if(loginTitle.equals("Login - Mouseprice"))
	    	test.log(LogStatus.PASS, "verify login title");
	    else
	    	test.log(LogStatus.FAIL, "verify login title");
	   
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