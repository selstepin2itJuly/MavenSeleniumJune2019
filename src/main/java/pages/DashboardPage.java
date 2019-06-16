package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	private WebDriver driver;
	
	@FindBy(css=".account-info")
	WebElement useraccount;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//ul[@class='sidebar-menu tree']/li[@class='treeview']")
	List<WebElement> dashboardMenu;
	
	//constructor
	public DashboardPage(WebDriver dr) {
			this.driver=dr;
			PageFactory.initElements(driver, this);
	}
	
	public String verifyLogoutString() {
		String str=null;
		str=logout.getText();
		return str;
	}
	
}
