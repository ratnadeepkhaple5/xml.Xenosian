package object.Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebdriverUtility;

public class CreateNewLeadPage extends WebdriverUtility {

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "company")
	private WebElement companyNameEdt;
	
	@FindBy(name = "leadstatus")
	private WebElement LeadStatusDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	public WebElement getCompanyNameEdt() {
		return companyNameEdt;
	}
	public WebElement getLeadStatusDropDown() {
		return LeadStatusDropDown;
	}
	public WebElement getsaveBtn() {
		return saveBtn;
	}
	
	public void createNewlead(String lastname,String companyname) {
		lastNameEdt.sendKeys(lastname);
		companyNameEdt.sendKeys(companyname);
	}
	public void createNewleadWithLeadStatus(String lastname,String companyname,String leadstatus) {
		lastNameEdt.sendKeys(lastname);
		companyNameEdt.sendKeys(companyname);
		handleDropDown(leadstatus, LeadStatusDropDown);
		saveBtn.click();
	}
	
	
}
