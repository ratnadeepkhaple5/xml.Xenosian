package vtiger.Leads.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.Reposiratory.CreateNewLeadPage;
import object.Reposiratory.Homepage;
import object.Reposiratory.LeadsInfoPage;
import object.Reposiratory.LeadsPage;
import object.Reposiratory.LoginPage;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebdriverUtility;

public class createLeadWithLeadStatus {

	@Test
	public static void createLeadsWithLeadStatus() throws IOException {
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
				//TC_06
				String lastname = eUtil.readDataFromExcel("Leads", 4, 2);
				String companyname = eUtil.readDataFromExcel("Leads", 4, 3);
				String leadstatus = eUtil.readDataFromExcel("Leads", 4, 4);
				
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
				
			//5) Navigate to Leads link	
				Homepage hp=new Homepage(driver);
				hp.leadsLnk();
				
			//click on create new lead image
				LeadsPage lsp=new LeadsPage(driver);
				lsp.clickOnCreateLeadImgLnk();
				
			//create new lead with leadStatus & save
				CreateNewLeadPage cnl=new CreateNewLeadPage(driver);
				cnl.createNewleadWithLeadStatus(lastname+jUtil.getRandomNumber(), companyname,leadstatus);
				
			//validate newly created leads
				LeadsInfoPage lip=new LeadsInfoPage(driver);
				String leadsheader = lip.getLeadsHeader();
				if (leadsheader.contains(lastname)) {
					System.out.println("leads created succesfully..");
				}else {
					System.out.println("Failed to create new lead");
				}
			//signout
				hp.signOutOApp();
				
				driver.close();
				
	}

}
