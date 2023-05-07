package vtiger.Contacts.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.Reposiratory.ContactInfoPage;
import object.Reposiratory.ContactsPage;
import object.Reposiratory.CreateNewContactPage;
import object.Reposiratory.Homepage;
import object.Reposiratory.LoginPage;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebdriverUtility;

/**
 * this class will create contacts with lead source
 * @author Ratnadeep khaple
 *
 */
@Listeners(vtiger.GenericUtility.ListenerImplementationClass.class)
public class CreateContactWithLeadSource extends BaseClass {
	@Test(groups = "smokeSuite")
	public void createConWithLeadSource () throws Exception {
		try {
//		// TODO Auto-generated method stub
//		WebDriver driver=null;
//		
//	//1) load all the data
//		JavaUtility jUtil=new JavaUtility();
//		PropertyFileUtility pUtil=new PropertyFileUtility();
//		WebdriverUtility wUtil=new WebdriverUtility();
//		ExcelFileUtility eUtil=new ExcelFileUtility();
//
//	//2) Read all the necessary data
//		String browser = pUtil.readDataFromFile("browser");
//		String url=pUtil.readDataFromFile("url");
//		String username = pUtil.readDataFromFile("username");
//		String password=pUtil.readDataFromFile("password");	
//		
		String lastName = eUtil.readDataFromExcel("Contact", 1, 2);
		String leadSource = eUtil.readDataFromExcel("Contact", 1, 3);
//		
//	//3)launch the browser
//		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//			System.out.println("chrome launched");
//		}else if(browser.equalsIgnoreCase("Edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//			System.out.println("edge launched");
//		}else if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//			System.out.println("firefox launched");
//		}else {
//			System.out.println("Invalid browser name");
//		}
//		//wUtil.maximizeWindow(driver);
//		wUtil.waitForDom(driver);
//		driver.get(url);
//		
//	//4) Login to App
//		LoginPage lp=new LoginPage(driver);
//		lp.loginToApp(username, password);
		
	//5) Navigate to contacts link
		Homepage hp=new Homepage(driver);
		hp.contactLnk();
		Reporter.log("clicked on contacts link", true);
		
	//6) click on create contact Img
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnNewContactImgLnk();
		Reporter.log("clicked on create new contacts img link", true);
	
	//7) create new contact with leadSource
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContactWithLeadSource(lastName+jUtil.getRandomNumber(), leadSource);
		Reporter.log("created new contact with lead source", true);
		
	//8) Validate that contact is created or not
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String conHeader = cip.getContactHeader();
		System.out.println(conHeader);
		
		Assert.assertEquals(conHeader.contains(lastName), true);
//		if (conHeader.contains(lastName)) {
//			System.out.println("contact created");
//			Reporter.log("created contacts validated", true);
//		}else {
//			System.out.println("Contact not created");
//			Reporter.log("failed to validate created contact", true);
//		}
	//9) signOut
	//	hp.signOutOApp();
		
		
//		driver.close();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   }
}
