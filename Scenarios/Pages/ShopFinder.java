package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopFinder {
	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;
	

	@FindBy(css="html.desktop.unauthenticated.avgrund-ready.wf-proximanova-n7-active.wf-proximanova-i7-active.wf-proximanova-n6-active.wf-proximanova-n4-active.wf-proximanova-i4-active.wf-bookmania-n4-active.wf-bookmania-n6-active.wf-active body div#outerWrap div#wrap div#main div.container_16.clearfix div.grid_16 div#storeLocator div div#locations.clearfix div#mapcontainer div#loclist ul li.storeResult.collectionPoint label.storeName span.storeName")
	WebElement firstTitle;

	@FindBy(css = "html.desktop.unauthenticated.avgrund-ready.wf-proximanova-n7-active.wf-proximanova-i7-active.wf-proximanova-n6-active.wf-proximanova-n4-active.wf-proximanova-i4-active.wf-bookmania-n4-active.wf-bookmania-n6-active.wf-active body div#outerWrap div#wrap div#main div.container_16.clearfix div.grid_16 div#storeLocator div div#locations.clearfix div#mapcontainer div#loclist ul li.storeResult.collectionPoint label.storeName span.miles")
	WebElement firstDistance;

	@FindBy(css = "html.desktop.unauthenticated.avgrund-ready.wf-proximanova-n7-active.wf-proximanova-i7-active.wf-proximanova-n6-active.wf-proximanova-n4-active.wf-proximanova-i4-active.wf-bookmania-n4-active.wf-bookmania-n6-active.wf-active body div#outerWrap div#wrap div#main div.container_16.clearfix div.grid_16 div#storeLocator div div#locations.clearfix div#mapcontainer div#loclist ul li.storeResult.collectionPoint label.storeName span.address")
	WebElement firstAddress;

	public ShopFinder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getFirstResult() {
		return firstTitle.getText();
	}

	public String getFirstDistance() {
		return firstDistance.getText();
	}
    
	public String getFirstAddress(){
		return firstAddress.getText();
	}
}