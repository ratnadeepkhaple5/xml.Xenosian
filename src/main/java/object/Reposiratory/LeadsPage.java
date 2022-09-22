package object.Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createLeadImgLnk;
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getcreateLeadImgLnk() {
		return createLeadImgLnk;
	}
	
	public void clickOnCreateLeadImgLnk() {
		createLeadImgLnk.click();
	}
}
