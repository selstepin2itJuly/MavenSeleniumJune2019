package testcasesjunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;

public class jUnitTestCases_2 extends TestBase{
	static WebDriver dr;
	TestBase tb;
	LoginPage lp;
	DashboardPage dp;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
		tb=new TestBase();
		dr=tb.getInstance();
		lp=new LoginPage(dr);
		dp=new DashboardPage(dr);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
		dr.quit();
	}

	@Test
	public void testOne_SuccessfulLogin() {
		System.out.println("Test 1");
		//fail("Not yet implemented");
		
		lp.loginToAppilcation(tb.prop.getProperty("username"), tb.prop.getProperty("password"));
		System.out.println(dp.verifyLogoutString());
		String s = dp.verifyLogoutString();
		assertTrue(s.equals("Logout1"));
	}
	@Test
	public void testTwo() {
		System.out.println("Test 2");
		fail("Not yet implemented");
	}
	@Test
	public void testThree() {
		System.out.println("Test 3");
		//fail("Not yet implemented");
		assertTrue(lp.verifyWelcomeMessage("Welcome"));
	}

}
