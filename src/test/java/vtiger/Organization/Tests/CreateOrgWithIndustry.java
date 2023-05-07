package vtiger.Organization.Tests;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import object.Reposiratory.CreateNewOrganisationPage;
import object.Reposiratory.Homepage;
import object.Reposiratory.LoginPage;
import object.Reposiratory.OrganizationInfoPage;
import object.Reposiratory.OrganizationsPage;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebdriverUtility;

@Listeners(vtiger.GenericUtility.ListenerImplementationClass.class)
public class CreateOrgWithIndustry extends BaseClass {
	@Test(groups = {"regressionSuite"},retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void createOrganization() throws Exception  {
		try{	
			String OrgName = eUtil.readDataFromExcel("Organisation", 4, 2)+jUtil.getRandomNumber();
			String Industry = eUtil.readDataFromExcel("Organisation", 4, 3);
			

		//5) Navigate to Organization link
			Homepage hp=new Homepage(driver);
			hp.orgLnk();
			Reporter.log("click on Org link", true);
		
		//6) click on create new organization lookup image	
			OrganizationsPage op=new OrganizationsPage(driver);
			op.clickOnOrgImgLnk();
			Reporter.log("click on create org lookup image", true);
			
		//7) create new Org with industry & save	
			CreateNewOrganisationPage cno=new CreateNewOrganisationPage(driver);
			cno.createNewOrg(OrgName, Industry);
			Reporter.log("New orgnization created", true);
			
		//8) validate
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String orgHeader = oip.getOrgHeader();
			System.out.println(orgHeader);
			
			Assert.assertEquals(orgHeader.contains(OrgName), true);
			//OR
//			if (orgHeader.contains(OrgName)) {
//				System.out.println("Orgisation created with industry..Passed");
//			}else {
//				System.out.println("failed to create organization..");
//			}
			
		}
	 catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
