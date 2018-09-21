package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FeaturesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage  homePage;
	FeaturesPage featurespage;
	//ForgotPasswordPage forgotPassword;
	//String expectedTitle="#1 Free CRM for Any Business: Online Customer Relationship Software";
	String expectedTitle="#1 Free CRM software in the cloud for sales and service";
	
	//create constructor of this class
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		//create the object LoginPage so that we can call
		//methods present in LoginPage to test them.
		loginPage= new LoginPage();	
	}
	
	
	@Test(priority=1)
	public void crmLogoTest(){
		boolean flag=loginPage.crmLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void validateTitleTest(){
		String actualTitle=loginPage.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title doesn't match.");
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		//validate successful login by checking the title
		Assert.assertEquals(driver.getTitle(), "CRMPRO",
				"Login unsuccessful");
		
	}
	@Test(priority=4)
	public void testFeautureLink(){
		featurespage=loginPage.clickOnFeatureLink();
		//validation
		Assert.assertEquals(driver.getTitle(), "Free CRM Features powerful sales automation and customer service features import data, export, dashboards and more",
							"Features link doesn't work.");	
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
