package practice;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import object.Reposiratory.Homepage;
import object.Reposiratory.LoginPage;
import vtiger.GenericUtility.PropertyFileUtility;

public class PomPractice {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String url = pUtil.readDataFromFile("url");
		
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin", "admin");
		
		Homepage hp=new Homepage(driver);
		hp.calenderLnk();
		hp.contactLnk();
		hp.leadsLnk();
		hp.opportLnk();
		hp.productLnk();
		hp.orgLnk();
	
	}

}
