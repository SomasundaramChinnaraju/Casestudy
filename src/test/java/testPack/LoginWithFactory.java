package testPack;
//New

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import browserPack.UtilityClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginWithFactory {
	WebDriver driver;
	@Given("^the user is in the registration page of the browser application$")
	public void the_user_is_in_the_registration_page_of_the_browser_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=UtilityClass.browser("http://10.232.237.143:443/TestMeApp/RegisterUser.htm");
	    //throw new PendingException();
	}

	@When("^username \"([^\"]*)\" ,firstname \"([^\"]*)\" ,lastname \"([^\"]*)\" ,password \"([^\"]*)\" ,confirm password \"([^\"]*)\" ,email \"([^\"]*)\" ,mobilenumber \"([^\"]*)\" ,DOB \"([^\"]*)\" ,Address \"([^\"]*)\" ,SecurityQuestion \"([^\"]*)\"$")
	public void username_firstname_lastname_password_confirm_password_email_mobilenumber_DOB_Address_SecurityQuestion(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 	  driver.findElement(By.name("userName")).sendKeys(arg1);
		  driver.findElement(By.name("firstName")).sendKeys(arg2);
		  driver.findElement(By.name("lastName")).sendKeys(arg3);
		  driver.findElement(By.name("password")).sendKeys(arg4);
		  driver.findElement(By.name("confirmPassword")).sendKeys(arg5);
		  driver.findElement(By.xpath("//input[@value='Female']")).click();
		  driver.findElement(By.name("emailAddress")).sendKeys(arg6);
		  driver.findElement(By.name("mobileNumber")).sendKeys(arg7);
		  driver.findElement(By.name("dob")).sendKeys(arg8);
		  driver.findElement(By.name("address")).sendKeys(arg9);
		  Select a=new Select(driver.findElement(By.id("securityQuestion")));
		  a.selectByIndex(2);
		  driver.findElement(By.id("answer")).sendKeys(arg10);
		  driver.findElement(By.name("Submit")).click();

		
		
	    //throw new PendingException();
	}

	@Then("^user must be redirected to the login page$")
	public void user_must_be_redirected_to_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Login")));
		System.out.println("Registered Successfully");
		driver.close();

	    //throw new PendingException();
	}

	@Given("^User must be in the Login Page$")
	public void user_must_be_in_the_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=UtilityClass.browser("http://10.232.237.143:443/TestMeApp/login.htm");

	    //throw new PendingException();
	}

	@When("^User must provide registered username credentials \"([^\"]*)\" and \"([^\"]*)\" and click Login$")
	public void user_must_provide_registered_username_credentials_and_and_click_Login(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("userName")).sendKeys(arg1);
	    driver.findElement(By.name("password")).sendKeys(arg2);
	    driver.findElement(By.name("Login")).click();

		
	    //throw new PendingException();
	}

	@Then("^Login is done successfully and user is directed to the Home page$")
	public void login_is_done_successfully_and_user_is_directed_to_the_Home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("val")));
		System.out.println("Logged in successfully");
		
	    //throw new PendingException();
	}
	@Given("^User providing informaion in search box$")
	public void user_providing_informaion_in_search_box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@id='myInput']")).click();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	    //throw new PendingException();
	}

	@When("^User enters headphones as value in search box$")
	public void user_enters_headphones_as_value_in_search_box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys("head");
		
		//throw new PendingException();
	}

	@Then("^the appropriate product is displayed$")
	public void the_appropriate_product_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	    //throw new PendingException();
	}
}
