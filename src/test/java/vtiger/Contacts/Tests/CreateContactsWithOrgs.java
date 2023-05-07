package vtiger.Contacts.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebdriverUtility;

public class CreateContactsWithOrgs {

	@Parameters("browser")
	@Test
	public static void CreateContactsWithOrg() throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver=null;
		
//	//1) load all the data
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		WebdriverUtility wUtil=new WebdriverUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		
	//2) Read all the necessary data
		String browser = pUtil.readDataFromFile("browser");
		String url=pUtil.readDataFromFile("url");
		String username = pUtil.readDataFromFile("username");
		String password=pUtil.readDataFromFile("password");
		
		String orgname = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		String lastname = eUtil.readDataFromExcel("Contact", 4, 2);
		
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
		
	//5) Navigate organization link	
		driver.findElement(By.linkText("Organizations")).click();
	//6) click on create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	//7) create organization with mandatory fields	
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		//save	
		driver.findElement(By.name("button")).click();
		
		
	//8) Validate the Organization	
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		
		if (orgHeader.contains(orgname)) {
			System.out.println("Organization created...");
		}else {
			System.out.println("organisation not created..");
		}
		
		
		
//	//5)Navigate to contact
//		
//		driver.findElement(By.linkText("Contacts")).click();
//		
//	//6) click on create contact
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//		

	}

}
