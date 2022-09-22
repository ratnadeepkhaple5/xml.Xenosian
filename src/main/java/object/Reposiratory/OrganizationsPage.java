package object.Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	//identification
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement OrgImgLnk;
	
	//initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrgImgLnk() {
		return OrgImgLnk;
	}
	//business logic
	public void clickOnOrgImgLnk() {
		OrgImgLnk.click();
	}
}
