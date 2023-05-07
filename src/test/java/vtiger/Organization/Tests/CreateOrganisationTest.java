package vtiger.Organization.Tests;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest {
	@Test(retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void CreateOrganisation() throws Exception {
	
		WebDriver driver=null;
		
		//generate random number-->
		Random r=new Random();
		int random=r.nextInt(500);
		
//step1: Read all the necessary data
		
	//read data from property files	
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	Properties pObj =new Properties();
	
	pObj.load(fisp);
	
	String browser=pObj.getProperty("browser");
	String url=pObj.getProperty("url");
	String username=pObj.getProperty("username");
	String password=pObj.getProperty("password");
	
	//read data from excel
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
	Workbook wb=WorkbookFactory.create(fise);
	Sheet sheet=wb.getSheet("Organisation");
	Row row=sheet.getRow(1);
	Cell cel=row.getCell(2);
	String orgname=cel.getStringCellValue();
	
//step2: launch the browser
	if (browser.equalsIgnoreCase("Chrome")) {
	WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 System.out.println("chrome launched");
	}else if(browser.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		System.out.println("edge launched");
	}else if (browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
		System.out.println("firefox launched");
	}else {
		System.out.println("Invalid browser name");
		driver=new ChromeDriver();
		System.out.println("Chrome launched");
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver, 10);
	driver.get(url);
	
//step3: login to app

	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();

//Step4:navigate to organization
	driver.findElement(By.linkText("Organizations")).click();
	
//step5:click on create organization
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
//create organization with mandatory fields	
	driver.findElement(By.name("accountname")).sendKeys(orgname+random);
	
//save	
	driver.findElement(By.name("button")).click();
//logout	
	
	try {
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}catch (StaleElementReferenceException e) {
		e.getStackTrace();
		}
	}
}
