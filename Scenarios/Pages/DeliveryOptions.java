package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryOptions {
	WebDriver driver;

	


	@FindBy(className = "title")
	WebElement title;

    @FindBy(className="a-button-text")
    WebElement continueButton;
    
	public DeliveryOptions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

	
	public String getButton(){
		return continueButton.getAttribute("value");
	}
	
	public void clickContinue(){
		continueButton.click();
	}
	
	

	
}