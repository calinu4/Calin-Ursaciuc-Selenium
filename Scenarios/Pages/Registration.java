package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration {
	WebDriver driver;

	


	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(id = "LogonDetails_Email")
	WebElement emailText;
	
	@FindBy(id = "IsRegistered")
	WebElement notregistered;
	
	@FindBy(id = "UserTitlePrefixTypeId")
	WebElement titleSelection;
	
	
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div/div[3]/div[2]/form/div/div/div[13]/input")
	WebElement createButton;
	

	
	
	

	
	
	

	public Registration(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	

	
	public void setNotRegistered(){
		notregistered.click();
	}
    
	public void setTitleSelection(){

        Select oSelect = new Select(titleSelection);

        oSelect.selectByIndex(1);

	}
	
	public void setEmail(String s1){
		emailText.sendKeys(s1);
		
		
	}
	public void setFirstName(String s2){
		
		WebElement firstname=driver.findElement(By.id("FirstName"));
		firstname.sendKeys(s2);
		
	}
	
public void setLastName(String s3){
		
		WebElement lastname=driver.findElement(By.id("LastName"));
		lastname.sendKeys(s3);
		
	}

public void setPassword(String p){
	
	WebElement password=driver.findElement(By.id("Password"));
	WebElement confirmpassword=driver.findElement(By.id("PasswordConfirm"));
	
	password.sendKeys(p);
	confirmpassword.sendKeys(p);
}
	public void clickCreate(){
		createButton.click();
	}
	
	
	
	

	
}