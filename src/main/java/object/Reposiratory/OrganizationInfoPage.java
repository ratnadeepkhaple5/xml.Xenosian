package object.Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgheaderTxt;
	
	//initialization
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrgheader() {
		return OrgheaderTxt;
	}
	//business logic
	public String getOrgHeader() {
		return OrgheaderTxt.getText();
	}	
}
