package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	private WebDriver driver;
	public Properties prop;
	public WebDriver getInstance() throws IOException {
		prop=new Properties();
		FileInputStream inStream=new FileInputStream("./src/main/java/config/config.properties");
		prop.load(inStream);
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			driver=new ChromeDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckodriver"));
			driver=new FirefoxDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgedriver"));
			driver=new EdgeDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("iedriver"));
			driver=new InternetExplorerDriver();
		}else {
			Throwable thr=new Throwable();
			thr.initCause(null);
		}
			
		System.out.println("URL: "+prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		System.out.println("Maximize windows:");
		driver.manage().window().maximize();
		return driver;
	}
}
