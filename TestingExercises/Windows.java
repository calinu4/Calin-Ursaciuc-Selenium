

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Windows {
static WebDriver driver;

public static void main(String[] args) {
System.setProperty("webdriver.gecko.driver",
"C:\\Users\\Profile\\Desktop\\Selenium\\geckodriver.exe");


WebDriver driver = new FirefoxDriver();
driver.get("file:///C:/Selenium%20Exercises/Selenium_IDE_Material/HTML/HTML/Window.html");

String window1 = driver.getWindowHandle();
System.out.println("First Handle is: "+window1);
WebElement link = driver.findElement(By.linkText("Google Search"));
link.click();

String window2 = driver.getWindowHandle();
System.out.println("Second Handle is: "+ window2);
System.out.println(" Handles so for: "
 +driver.getWindowHandles().size());

driver.switchTo().window(window1);

}
}