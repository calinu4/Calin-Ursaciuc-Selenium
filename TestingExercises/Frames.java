

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {
static WebDriver driver;

public static void main(String[] args) {
System.setProperty("webdriver.gecko.driver",
"C:\\Users\\Profile\\Desktop\\Selenium\\geckodriver.exe");


 driver = new FirefoxDriver();
driver.get("file:///C:/Selenium%20Exercises/Selenium_IDE_Material/HTML/HTML/Frames.html");

Actions action = new Actions(driver);

driver.switchTo().frame(0);
WebElement txt1 = driver.findElement(By.name("1"));
txt1.sendKeys("I'm Frame One");
System.out.println(txt1);

driver.switchTo().defaultContent();

driver.switchTo().frame(1);
WebElement txt2 = driver.findElement(By.name("2"));
txt2.sendKeys("I'm Frame Two");
System.out.println(txt2);

}
}