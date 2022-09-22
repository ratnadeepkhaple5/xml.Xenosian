package vtiger.Organization.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import object.Reposiratory.CreateNewOrganisationPage;
import object.Reposiratory.Homepage;
import object.Reposiratory.LoginPage;
import object.Reposiratory.OrganizationInfoPage;
import object.Reposiratory.OrganizationsPage;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebdriverUtility;

public class CreateOrgWithIndustry {

	@Test
	public void createOrganization() throws Exception {
		
		WebDriver driver=null;
		
	//1) Create object of all the utilities
		JavaUtility jUtil=new JavaUtility();
		WebdriverUtility wUtil=new WebdriverUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		
	//2) Read all the necessary data
		String browser=pUtil.readDataFromFile("browser");
		String url = pUtil.readDataFromFile("url");
		String username = pUtil.readDataFromFile("username");
		String password = pUtil.readDataFromFile("password");
		
		String OrgName=eUtil.readDataFromExcel("Organisation", 4, 2);
		String Industry = eUtil.readDataFromExcel("Organisation", 4, 3);
		
	//3) launch the browser
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser name");
		}
		
		//wUtil.maximizeWindow(driver);
		wUtil.waitForDom(driver);
		driver.get(url);
		
	//4) Login to app
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(username, password);
		
	//5) Navigate to Organization link
		Homepage hp=new Homepage(driver);
		hp.orgLnk();
	
	//6) click on create new organization	
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnOrgImgLnk();
		
	//7) create new Org with industry & save	
		CreateNewOrganisationPage cno=new CreateNewOrganisationPage(driver);
		cno.createNewOrg(OrgName+jUtil.getRandomNumber(), Industry);
		
	//8) validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		System.out.println(orgHeader);
		if (orgHeader.contains(OrgName)) {
			System.out.println("Orgisation created with industry..Passed");
		}else {
			System.out.println("failed to create organization..");
		}
		
	//9) signOut
		hp.signOutOApp();
		
		driver.close();
	}

}
