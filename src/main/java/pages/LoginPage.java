package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.TestUtility;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement username;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(css="[type='submit']")
	WebElement loginButton;
	
	@FindBy(css="#RememberMe")
	WebElement checkBoxRememberMe;
	
	@FindBy(css=".title > strong")
	WebElement loginPageWelcomeMsg;
	
	//constructor
	public LoginPage(WebDriver dr) {
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	private void enterUsername(String str) {
		TestUtility.waitForElement(username, driver);
		username.sendKeys(str);
	}
	
	private void enterPassword(String str) {
		TestUtility.waitForElement(username, driver);
		password.sendKeys(str);
	}
	
	private void clickOnLoginButton() {
		TestUtility.waitForElement(loginButton, driver);
		loginButton.click();
	}
	
	public void loginToAppilcation(String user, String pass, String rem) {
		enterUsername(user);
		enterPassword(pass);
		if(rem.equalsIgnoreCase("Yes")) {
			clickOnRememberMe();
		}else if(rem.equalsIgnoreCase("No")){
			removeRememberMe();
		}
		clickOnLoginButton();
	}
	
	public void loginToAppilcation(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickOnLoginButton();
	}
	private void clickOnRememberMe() {
		boolean b=false;
		b=checkBoxRememberMe.isSelected();
		if(b==false) {
			checkBoxRememberMe.click();
		}
	}
	private void removeRememberMe() {
		boolean b=false;
		b=checkBoxRememberMe.isSelected();
		if(b==true) {
			checkBoxRememberMe.click();
		}
	}
	
	private String welcomeMessage() 
	{
		String str=null;
		str=loginPageWelcomeMsg.getText();
		System.out.println(str);
		return str;
	}
	
	public boolean verifyWelcomeMessage(String str) {
		boolean b=false;
		String s = welcomeMessage();
		b=s.contains(str);
		return b;
	}
}
