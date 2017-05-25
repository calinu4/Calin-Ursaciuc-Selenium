package Tests;   
import org.junit.runner.RunWith;

	import org.junit.runners.Suite;

	import org.junit.runners.Suite.SuiteClasses;

import com.relevantcodes.extentreports.ExtentReports;

	 

	@RunWith(Suite.class)

	@SuiteClasses({ LoginTest.class, BookShopTest.class, RegistrationTest.class,AmazonPurchaseTest.class })

	public class AllTests {

	 static ExtentReports report1=new ExtentReports("C:\\extent1.html", true);

	}