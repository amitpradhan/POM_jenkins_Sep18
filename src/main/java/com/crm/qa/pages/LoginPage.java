package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//iniatlize driver using Pagefactory.
	//driver is coming from TestBase class
	public LoginPage(){
		super();
		PageFactory.initElements(driver, this);
	}
	
	//find user id and password field
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	//Above statement is same as below		
	//WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	//implement login method
	public HomePage login(String uname,String pwd){
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
				
	}
	
	//Feature link
	@FindBy(xpath="//a[text()='Features']")
	WebElement featureLink;
	
	public FeaturesPage clickOnFeatureLink(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(featureLink)).click();;
		//featureLink.click();
		return new FeaturesPage();
	}
	
	//validate title method
	public String validateTitle(){
		return driver.getTitle();
	}
	
	//Validate if CRM logo is displayed or not
	@FindBy(xpath="//a[@class='navbar-brand']/child::img")
	WebElement crmLogo;
	
	public boolean crmLogo(){
		return crmLogo.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
