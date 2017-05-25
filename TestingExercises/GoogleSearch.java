

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {
static WebDriver driver;

public static void main(String[] args) {
System.setProperty("webdriver.gecko.driver",
"C:\\Users\\Profile\\Desktop\\Selenium\\geckodriver.exe");
driver =new FirefoxDriver();

driver.get("http://www.google.com/");
boolean result = true;

try {
	driver.findElement(By.name("q123"));
}
catch (NoSuchElementException e) {
	System.out.println(e);
	result = false;
}
finally {
	driver.close();
}

if (result)
	System.out.println("---Passed---");
else
	System.out.println("---Failed---");


}
}