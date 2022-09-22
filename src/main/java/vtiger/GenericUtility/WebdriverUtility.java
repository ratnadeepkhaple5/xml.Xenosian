package vtiger.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods related to 'WebDriver' actions
 * 
 * @author Ratnadeep_Khaple
 * 
 */
public class WebdriverUtility {

//Window Operations
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {

		driver.manage().window().maximize();
	}
	
//Waits	
	/**
	 * This method will wait until entire Dom(page source) to load
	 * @param driver
	 */
	public void waitForDom(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * This method will until element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToLoad(WebDriver driver,WebElement element) {

		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will until element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method represent the 'Custom Wait' where it will for the particular element
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClickOnElement(WebElement element) throws InterruptedException {
		int count =0;
		while (count<10) {

			try {
				element.click();
				break;
			} catch (Exception e) {

				Thread.sleep(1000);
				count++;
			}
		}
	}
	
//DropDowns-Select class
	/**
	 * this method will handle dropdown by using select class based on Index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select sl=new Select(element);
		sl.selectByIndex(index);
	}
	/**
	 * this method will handle dropdown by using select class based on visibleText
	 * @param element
	 * @param visibleText
	 */
	public void handleDropDown(WebElement element,String visibleText) {
		Select sl=new Select(element);
		sl.selectByValue(visibleText);
	}
	/**
	 * this method will handle dropdown by using select class based on value
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value,WebElement element) {
		Select sl=new Select(element);
		sl.selectByValue(value);
	}
	
//Actions Class method
	/**
	 * this method will perform mouse hover actions on particular element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOn(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * this method will perform double click on Webpage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		Actions actions =new Actions(driver);
		actions.doubleClick().perform();
	}
	/**
	 * this method will perform double click on particular webElement
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	/**
	 * this method will right click on WebPage
	 * @param driver
	 */
	public void rightClickOnPage(WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.contextClick().perform();
	}
	/**
	 * this method will right click on WebElement
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	/**
	 * this method will perform drag and drop operations on element from source
	 * element location to target(dest) element location
	 * @param driver
	 * @param Srcelement
	 * @param destElement
	 */
	public void dragAndDropOn(WebDriver driver,WebElement Srcelement,WebElement destElement) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(Srcelement, destElement).perform();
	}
	
//Robot Class
	/**
	 * this method will press 'Enter'Key & release EnterKey
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
//Handle Alerts
	/**
	 * This method will Accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will Dismiss(Cancel) Alert popup
	 * @param driver
	 */
	public void dissmissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this will get the text of alert popUp
	 * @param driver
	 * @return
	 */
	public String getTextOFAlert(WebDriver driver) {
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
//Frame Handling
	/**
	 * this will handle frame based on Index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * this will handle frame based on nameOrId
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * this will handle frame based on FrameElement
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
//Control Back to ParentFrame
	/**
	 * this will switch control back to immediate ParentFrame
	 * @param driver
	 */
	public void toParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * this method will come out all the frames
	 * @param driver
	 */
	public void toDefaultWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
//switch window based on partial window title
	/**
	 * this method will switch window from one to another based on partialwindowTitle
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle) {
		//1. get all the window ids
		Set<String> allIds = driver.getWindowHandles();

		//2. iterate through all window id's
		Iterator<String> id = allIds.iterator();

		//3. navigate to each window and check the title
		while (id.hasNext()) {

			// capture the individual window id
			String winId = id.next();
			String currentTitle = driver.switchTo().window(winId).getTitle();

			//	compare the current window title with partial window title
			if (currentTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	
//TakesSceenshot
	/**
	 * this will take ScreenShot and save in screenshot folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takesSceenshot(WebDriver driver,String screenShotName) throws IOException {
	
		TakesScreenshot ts=(TakesScreenshot) driver;
		File tempsrnshot = ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshots\\"+screenShotName+".png";
		 File destfile=new File(path);
		FileUtils.copyFile(tempsrnshot, destfile);
		
		return destfile.getAbsolutePath();//used for 'Reporting' purpose
	}
	
//window scrolling by using javaScriptExecutor
	/**
	 * this will scroll windows by using JavascriptExecutor until 500 units
	 * @param driver
	 */
	public void scrollActions(WebDriver driver) {
		
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)","");	
	}
	/**
	 * this method will scroll until the element
	 * @param driver
	 * @param element
	 */
	public void scrollActions(WebDriver driver,WebElement element) {
		
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();",	element);
	//OR
		int y=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")",element);
	}
}
