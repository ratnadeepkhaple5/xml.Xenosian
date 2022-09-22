package object.Reposiratory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebdriverUtility;

public class CreateNewContactPage extends WebdriverUtility{

	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropdown;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement OrganizationImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchNowBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getOrganizationImg() {
		return OrganizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * this method will create contact
	 * @param lastname
	 */
	public void createNewContact(String lastname) {
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	/**
	 * this method will create contact with leadSource dropDown
	 * @param lastname
	 * @param leadSource
	 */
	public void createNewContactWithLeadSource(String lastname,String leadSource) {
		lastNameEdt.sendKeys(lastname);
		handleDropDown(leadSource, leadSourceDropdown);
		saveBtn.click();
	}
	/**
	 * this method will create contact with organization
	 * @param lastname
	 * @param driver
	 * @param orgname
	 */
	public void createNewContactWithOrganization(String lastname,WebDriver driver,String orgname) {
		lastNameEdt.sendKeys(lastname);
		OrganizationImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(orgname);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
}
