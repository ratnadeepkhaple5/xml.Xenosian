package object.Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement LeadsHeaderTxt;
	
	public LeadsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLeadsHeaderTxt() {
		return LeadsHeaderTxt;
	}
	public String getLeadsHeader() {
		return LeadsHeaderTxt.getText();
	}
	
}

