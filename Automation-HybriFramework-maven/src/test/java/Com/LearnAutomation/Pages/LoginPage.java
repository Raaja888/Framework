package Com.LearnAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	public WebDriver driver;
	
	
	public LoginPage(WebDriver Rdriver)
	{
		this.driver= Rdriver;
	}
	
	@FindBy(id = "txtUsername")   WebElement Email;
	
	
	@FindBy(id = "txtPassword")  WebElement Password;
	
	@FindBy(id = "btnLogin")     WebElement SubmitButton;
	
	
	public void EnterDetails(String user,String PW )
	{
		try 
		{	
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Email.sendKeys(user);
		Password.sendKeys(PW);
		SubmitButton.click();
	}	

}
