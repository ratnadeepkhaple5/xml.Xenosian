package vtiger.Contacts.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebdriverUtility;

public class CreateContactTest {
	
	@Test
	public static void CreateContactTests() throws IOException {
		
		WebDriver driver=null;
		
	//1) load all the data
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		WebdriverUtility wUtil=new WebdriverUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		
	//2) Read all the necessary data
		String browser = pUtil.readDataFromFile("browser");
		String url=pUtil.readDataFromFile("url");
		String username = pUtil.readDataFromFile("username");
		String password=pUtil.readDataFromFile("password");
		
		String lastname = eUtil.readDataFromExcel("Contact", 1, 2)+jUtil.getRandomNumber();
		String leadSource = eUtil.readDataFromExcel("Contact", 1, 3);
		System.out.println(leadSource);
		
	//3) Launch the browser- Run Time PolyMorphism
		
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 System.out.println("chrome launched");
		}else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("edge launched");
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("firefox launched");
		}else {
			System.out.println("Invalid browser name");
		}
	//	wUtil.maximizeWindow(driver);
		wUtil.waitForDom(driver);
		driver.get(url);
		
	//4) Login to app
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
	//5)Navigate to contact
		
		driver.findElement(By.linkText("Contacts")).click();
		
	//6) click on create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
	//7) create new contact with mandatory information & save
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		WebElement ele = driver.findElement(By.name("leadsource"));
		wUtil.handleDropDown(leadSource, ele);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	//8) Logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.waitForElementToLoad(driver, element);
		element.click();
		driver.findElement(By.linkText("Sign Out")).click();	
		
		driver.close();
	}

}
