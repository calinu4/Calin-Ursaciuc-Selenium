package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Basket {
	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;
	@FindBy(id="hlb-ptc-btn-native")
	WebElement proceedCheckout;
	
	public Basket(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getProceedTitle(){
		return proceedCheckout.getText();
	}
	
	public void proceedToCheckout(){
		proceedCheckout.click();
	}
	
	
	
}