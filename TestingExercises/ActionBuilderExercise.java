

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionBuilderExercise {
static WebDriver driver;

public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver",
"C:\\Users\\Profile\\Desktop\\Selenium\\chromedriver.exe");
driver =new ChromeDriver();

driver.get("file:///C:/Selenium%20Exercises/Selenium_IDE_Material/HTML/HTML/Sortable.html");


boolean result = true;

try {
	driver.findElement(By.id("sortable"));
	
}
catch (NoSuchElementException e) {
	System.out.println(e);
	result = false;
}


if (result)
	System.out.println("---Page has loaded successfully---");
else
	System.out.println("---Failed---");
//use builder to swap elements
Actions builder = new Actions(driver);

//Check the two elements are in place 2 and 3
WebElement two=driver.findElement(By.name("two"));
WebElement three=driver.findElement(By.name("three"));

//store their location
Point p1=two.getLocation();
Point p2=three.getLocation();
System.out.println("Two current location is: "+p1.getX()+" by "+p1.getY()+" px");
System.out.println("Three current location is: "+p2.getX()+" by "+p2.getY()+" px");

//if two x position is bigger than three x location then swap
if(p1.getX()>p2.getX()){   
	System.out.println("Number two should be in number three's position!"+"\n");
	System.out.println("Performing swap of two and three..."+"\n");
	
builder.clickAndHold(two) .release(three) .perform();
builder.release();

}
else
	System.out.println("Numbers are in the right location!");


//two=driver.findElement(By.name("two"));
//three=driver.findElement(By.name("three"));
p1=two.getLocation();
p2=three.getLocation();

if(p1.getX()<p2.getX()){
System.out.println("The numbers are in right location");
System.out.println("Two current location is: "+p1.getX()+" by "+p1.getY()+" px");
System.out.println("Three current location is: "+p2.getX()+" by "+p2.getY()+" px");
driver.close();

}



}

public boolean checkLocation(int x1,int x2,int y1,int y2){
	//Just an example if we need to extend this class for multiple checks
	if(y1==y2){
		if(x1>x2)
			return false;
		else
			return true;
	}
	
	
	return true;
		
}
}