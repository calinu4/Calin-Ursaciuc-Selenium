package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home4 {
	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(id = "postcode")
	WebElement post;
	
	
	
	
	public Home4(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void setLocation(String s){
		post.sendKeys(s);
	}
	
	public void clickFind(){
		post.sendKeys(Keys.RETURN);
	}
	
	
	
	
}