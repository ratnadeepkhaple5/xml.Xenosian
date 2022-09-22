package object.Reposiratory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	@FindBy(linkText = "Calendar")
	private WebElement calenderLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutLnk;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutBtn;
	
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	public WebElement getCalenderLnk() {
		return calenderLnk;
	}
	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	public WebElement getOrgLnk() {
		return orgLnk;
	}
	public WebElement getContactLnk() {
		return contactLnk;
	}
	public WebElement getOpportLnk() {
		return opportLnk;
	}
	public WebElement getProductLnk() {
		return productLnk;
	}
//constructor	
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
//Action Methods//business logic	

	public void orgLnk() {
		orgLnk.click();
	//	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}
	public void calenderLnk() {
		calenderLnk.click();
	}
	public void leadsLnk() {
		leadsLnk.click();
	}
	public void contactLnk() {
		contactLnk.click();
	}
	public void opportLnk() {
		opportLnk.click();
	}
	public void productLnk() {
		productLnk.click();
	}

	public void signOutOApp() {
		signOutLnk.click();
		signOutBtn.click();
	}
}
