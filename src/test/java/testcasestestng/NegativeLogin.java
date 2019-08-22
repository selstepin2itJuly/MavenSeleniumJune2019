package testcasestestng;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NegativeLogin {
	
	static WebDriver dr;
	TestBase tb;
	LoginPage lp;
	DashboardPage dp;
	
	@Test(priority=3,description="Successful login Method")
	public void testOne_SuccessfulLogin() {
		System.out.println("Test 1");
		
		lp.loginToAppilcation(tb.prop.getProperty("username"), tb.prop.getProperty("password"));
		System.out.println(dp.verifyLogoutString());
		String s = dp.verifyLogoutString();
		assertTrue(s.equals("Logout1"));
	}
	
	@Test(priority=1,description="Not implemented",enabled=true)
	public void testTwo() {
		System.out.println("Test 2");
		fail("Not yet implemented");
	}
	
	@Test(priority=2, description="Welcome message")
	public void testThree() {
		System.out.println("Test 3");
		//fail("Not yet implemented");
		assertTrue(lp.verifyWelcomeMessage("Welcome"));
	}  

  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException {
	  System.out.println("Before");
		tb=new TestBase();
		dr=tb.getInstance();
		lp=new LoginPage(dr);
		dp=new DashboardPage(dr);
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  System.out.println("After");
		dr.quit();
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
