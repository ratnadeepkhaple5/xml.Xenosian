package screenshotsFailed;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;




public class GoogleTest extends BaseForFailedScreenshots {

//	WebDriver driver;
//	@Test(testName = "testgoogle")
//	public void testgoogle() {
//	driver.get("https://www.google.co.in/");
//	
//	driver.findElement(By.name("q")).sendKeys("sunny khaple",Keys.ENTER);
//	
//	String expTitle="sunny khaple - Google Search";
//	String actualTitle = driver.getTitle();
//	assertEquals(actualTitle, expTitle);
//	}
	@Test(testName = "orangeHRM")
	public void orangeHRM() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Adminr3f");
		driver.findElement(By.name("password")).sendKeys("admin1234wefwf");
	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[.='Configuration ']")).click();
	}
}
