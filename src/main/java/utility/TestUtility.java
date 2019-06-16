package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtility{
	
	public static WebDriverWait wait;
	
	public static void screenCapture(String str, WebDriver driver) throws IOException {
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File("image_"+str+".jpg"));
	}
	
	public static void scrollToElement(WebElement element, WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)", "");
	}
	
	public static void waitForElement(WebElement element, WebDriver driver) {
		wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
}
