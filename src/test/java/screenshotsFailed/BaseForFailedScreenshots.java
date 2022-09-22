package screenshotsFailed;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseForFailedScreenshots {
	
	WebDriver driver;
	@BeforeTest
	public void setup() {		
	WebDriverManager.edgedriver().setup();
	 driver=new EdgeDriver();	
	 
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
//	@AfterTest
//	public void exit() {
//		driver.quit();
//	}
	
	public void captureScreenShots(String filename) throws IOException{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File tempshot = ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./screenshots/"+filename+".png");
		try {
		FileUtils.copyFile(tempshot, destfile);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Screenshots saved successfully");
	}
	
	
}
