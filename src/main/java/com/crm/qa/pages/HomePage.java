package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


	
	/**
	 * @CacheLookup annotation is used to improve the performance of the script.
	 * When we use @CacheLookup against any webelement with FindBy annotation, 
	 * the webelement will be stored in the cache memory so that if the webelement is 
	 * accessed multiple times, selenium would look for it in the cache rather than 
	 * the HTML page DOM which saves execution time.
	 * SO it is good practice is to add @CacheLookup.
	 * However, if the page got refreshed or page got changed , then this cache memory may
	 * get corrupted and throw StaleElementException.
	 *  
	 * @author Admin
	 *
	 */
	public class HomePage extends TestBase {
		
		//Initializing page object
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		//driver.findelemnt(By.xpath("xpath_1"));
		//@FindBy(xpath="//td[contains(text(),'User: Amit Pradhan ')]")
		@FindBy(xpath="//td[@class='headertext'][1]")
		@CacheLookup
		WebElement userNameLabel;
		
			
		@FindBy(xpath="//a[contains(text(),'Deals')]")
		@CacheLookup
		WebElement dealsLink;
		
		@FindBy(xpath="//a[contains(text(),'Tasks')]")
		@CacheLookup
		WebElement tasksLink;
		
		@FindBy(xpath="//a[contains(text(),'Contacts')]")
		//@CacheLookup
		WebElement contactsLink;
		
		
				
		@FindBy(xpath="//a[contains(text(),'New Contact')]")
		//@CacheLookup
		WebElement newContactLink;
		
		
		//Implementing methods..
		
		public String verifyHomepageTitle(){
			return driver.getTitle();
		}
		
		public ContactsPage clickOnContactsLink(){
			contactsLink.click();
			return new ContactsPage();
		}
		
		public DealsPage clickOnDealsLink(){
			dealsLink.click();
			return new DealsPage();
		}
			
		public TasksPage clickOnTaskLink(){
			tasksLink.click();
			return new TasksPage();
		}
		
		public boolean verifyCorrectUserName(){
			return userNameLabel.isDisplayed();
		}
		
		
		public void clickOnNewContactLink() {
			Actions action= new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContactLink.click();
		}
		
}
