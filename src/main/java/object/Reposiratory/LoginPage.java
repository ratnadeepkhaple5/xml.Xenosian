package object.Reposiratory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//	WebDriver driver;
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement submitBtn;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
	}
	/**
	 * Business Library
	 * 
	 * this method will login to app
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
	}
}
