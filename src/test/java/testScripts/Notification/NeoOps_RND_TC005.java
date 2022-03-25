package testScripts.Notification;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.IFlightNeo_LoginPage;
import pageObjects.IFlightNeo_Notification;
import utilities.CollectTestData;
import utilities.Driver;

public class NeoOps_RND_TC005 {
	


	public utilities.ReportLibrary htmlLib = new utilities.ReportLibrary();
	public utilities.CommonLibrary com = new utilities.CommonLibrary();
	public utilities.BusinessFunctions bizComm = new utilities.BusinessFunctions();
	String[] lists = this.getClass().getName().split("\\.");
	String tcName = lists[lists.length - 1];
	static WebDriver driver;
	static WebDriverWait wait;

	@BeforeMethod
	void setUp() {
		// Set Up Initial Script Requirement
		Driver.setUpTestExecution(tcName, "Notification marked as read by another user in notification browser");
		// launch application
		String browser = CollectTestData.browser;
		String url = CollectTestData.url;
		driver = IFlightNeo_LoginPage.launchApplication(browser, url);
	}
    
	@AfterMethod
	public void closeTest() {
	Driver.tearDownTestExecution(driver);
	}
	
	@Test
	public void login() throws Exception {
		try {

			// Collect Test Data
			String username = CollectTestData.userName;
			String password = CollectTestData.password;
			int rowNum;

			IFlightNeo_LoginPage.login(driver, username, password);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

			IFlightNeo_Notification.navigate_AlertBrowser(driver);
			rowNum= IFlightNeo_Notification.getRowOfUnreadRecord(driver);
			driver.navigate().refresh();
			IFlightNeo_Notification.navigateAgain_AlertBrowser(driver);
			IFlightNeo_Notification.verifyReadRow(driver,rowNum);
			
		} catch (Exception e) {
			System.out.println("The exception occured for this TC is" + e);
			e.printStackTrace();

		}
	}



}
