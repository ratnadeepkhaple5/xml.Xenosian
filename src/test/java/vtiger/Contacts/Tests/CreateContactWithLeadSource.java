package vtiger.Contacts.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.Reposiratory.ContactInfoPage;
import object.Reposiratory.ContactsPage;
import object.Reposiratory.CreateNewContactPage;
import object.Reposiratory.Homepage;
import object.Reposiratory.LoginPage;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebdriverUtility;



public class CreateContactWithLeadSource {
	@Test
	public void createConWithLeadSource () throws Exception {
		// TODO Auto-generated method stub
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
		
		String lastName = eUtil.readDataFromExcel("Contact", 1, 2);
		String leadSource = eUtil.readDataFromExcel("Contact", 1, 3);
		
	//3)launch the browser
		if (browser.equalsIgnoreCase("chrome")) {
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
		//wUtil.maximizeWindow(driver);
		wUtil.waitForDom(driver);
		driver.get(url);
		
	//4) Login to App
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(username, password);
		
	//5) Navigate to contacts link
		Homepage hp=new Homepage(driver);
		hp.contactLnk();
		
	//6) click on create contact Img
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnNewContactImgLnk();
	
	//7) create new contact with leadSource
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContactWithLeadSource(lastName+jUtil.getRandomNumber(), leadSource);
	
	//8) Validate that contact is created or not
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String conHeader = cip.getContactHeader();
		System.out.println(conHeader);
		if (conHeader.contains(lastName)) {
			System.out.println("contact created");
		}else {
			System.out.println("Contact not created");
		}
	//9) signOut
		hp.signOutOApp();
		
		driver.close();
	}
		
}
