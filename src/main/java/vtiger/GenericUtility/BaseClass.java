package vtiger.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.Reposiratory.Homepage;
import object.Reposiratory.LoginPage;

/**
 * This class consists of all basic configuration annotations of testNG
 * to perform common functionalities.
 * 
 * @author Ratnadeep
 *
 */
public class BaseClass {

	//1) load all the data
	public JavaUtility jUtil=new JavaUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebdriverUtility wUtil=new WebdriverUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public DataBaseUtility dbUtil=new DataBaseUtility();
	
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"smokeSuite","regressionSuite"})
	public void bsConfig() throws SQLException {
		
	//	dbUtil.connectDB();
		Reporter.log("---dbConnection successful---", true);
	}
	
//@Parameters("browser")//it will read value from suite xml file
	//use when u want to do Compatibility testing only
@BeforeTest //use when u want to do parallel execution only
	
//	@BeforeClass(groups = {"smokeSuite","regressionSuite"})
//	public void bcConfig(String browser) throws IOException {
	public void bcConfig() throws IOException {
		
		String browser = pUtil.readDataFromFile("browser");
		String url=pUtil.readDataFromFile("url");
		
		//3) Launch the browser- Run Time PolyMorphism
		
				if (browser.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					 driver=new ChromeDriver();
					 Reporter.log("--chrome-browser launched", true);
				}else if(browser.equalsIgnoreCase("Edge")) {
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
					Reporter.log("--edge-brower launched", true);
				}else if (browser.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
					Reporter.log("--firefox-brower launched", true);
				}else {
					System.out.println("Invalid browser name");
				}
//				wUtil.maximizeWindow(driver);
				wUtil.waitForDom(driver);
				driver.get(url);
				sDriver=driver;
	}
	
	@BeforeMethod(groups = {"smokeSuite","regressionSuite"})
	public void bmConfig() throws IOException {
		String username = pUtil.readDataFromFile("username");
		String password=pUtil.readDataFromFile("password");
		
		//4) Login to app
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(username, password);
				Reporter.log("---LogIn successful---", true);
	}
	
	@AfterMethod(groups = {"smokeSuite","regressionSuite"})
	public void amConfig() {
		Homepage hp=new Homepage(driver);
		hp.signOutOApp();
		Reporter.log("---LogOut successful---", true);
	}
	
	@AfterTest
//	@AfterClass(groups = {"smokeSuite","regressionSuite"})
	public void acConfig() {
		
		driver.close();
		Reporter.log("browser closed", true);
	}
	@AfterSuite(groups = {"smokeSuite","regressionSuite"})
	public void asConfig() throws SQLException {
	//	dbUtil.close();
		Reporter.log("dbclosed successfully", true);
		
	}
	
}
