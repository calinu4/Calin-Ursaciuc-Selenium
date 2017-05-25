package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryAddress {
	WebDriver driver;

	


	@FindBy(className = "title")
	WebElement title;
    
	@FindBy(xpath = "/html/body/div[5]/div[2]/form/div/div[1]/div[2]/span/a")
	WebElement delivery;

	public DeliveryAddress(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
   
	public String getDeliveryButton(){
		return delivery.getText();
	}
	
	public void selectDeliveryAddress(){
		delivery.click();
	}
	

	
}