package pageObjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.IFlightNeo_HomePage;

public class IFlightNeo_Gantt {
	static WebDriverWait wait;
	static WebElement element;
	private static By locator;
	public static utilities.CommonLibrary com = new utilities.CommonLibrary();
	public static utilities.ReportLibrary report = new utilities.ReportLibrary();
	public static utilities.BusinessFunctions bizCom = new utilities.BusinessFunctions();
	
	
	
	public static WebElement tab_GANTT(WebDriver driver) {
		List<WebElement> tab_GANTT = driver.findElements(By.xpath("//li//a[text()='OPS GANTT']"));
		return tab_GANTT.get(0);
	}
	
	/**	Toggle Dropdown Arrow in Local World Gantt Screen */
	public static WebElement btn_ToggleArrowInLWGantt(WebDriver driver) {
		wait = new WebDriverWait(driver, 400);
		List<WebElement> elements = null;
		try {
			elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@id, 'GanttWorldMenu_ActListBtn')]")));
		}
		catch(TimeoutException toe) {}
		return elements.get(elements.size()-1);
	}
	
	/**	New Scenario Mode Option Link under Gantt Filter in Gantt Screen */
	public static WebElement link_NewScenarioModeOptionInGanttFilter(WebDriver driver) {
		wait = new WebDriverWait(driver, 60);
		List<WebElement> elements = null;
		try {
			elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text()='New Scenario Mode']")));
		}
		catch(TimeoutException toe) {}
		return elements.get(elements.size()-1);
	}
	
	/**	Real World Option Link under Gantt Filter in Gantt Screen */
	public static WebElement link_RealWorldOptionInGanttFilter(WebDriver driver) {
		wait = new WebDriverWait(driver, 60);
		List<WebElement> elements = null;
		try {
			elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text()='Real World']")));
		}
		catch(TimeoutException toe) {}
		return elements.get(elements.size()-1);
	}
	
	/**	Remove Tab Link in Gantt Screen */
	public static List<WebElement> link_RemoveGanttTab(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath("//span[text()='Remove Tab']"));
		return elements;
	}
	
	/**	Gantt Tab in Gantt Screen */
	public static WebElement tab_GanttScreen(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath("//li//a[text()='OPS GANTT']"));
		return elements.get(0);
	}
	
	/** Local World Tab in Gantt screen */
	public static WebElement tab_LocalGantt(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'LW1-OPS GANTT')]"));
		return element;
	}
	
	/** Whole Gantt Horizontal Scroll */
	public static WebElement gantt_GanttCanvas(WebDriver driver) {
		//canvas[contains(@id,'horizontalBarui-scrollBarHorizontalCanvasId')]
		element = driver.findElement(By.xpath("//canvas[@id='chronos_overlayW1_gantt_placeholder_aircraftPaneWidgetui-gantt_holder']"));
		return element;
	}
	
	/** Find flight Image link at the bottom in Gantt Screen */
	public static WebElement imgLink_FindFlight(WebDriver driver) {
		wait = new WebDriverWait(driver, 120);
		locator = By.xpath("//li[@title='Find Flight']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// Actions a5 = new Actions(driver);
		element = driver.findElement(locator);
		return element;
	}
	
	/** Find Flight Dialog in Gantt Screen */
	public static WebElement dialog_FindFlight(WebDriver driver) {
		wait = new WebDriverWait(driver, 80);
		locator = By.xpath("//div[@aria-describedby='findFlight_dialog']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element = driver.findElement(locator);
		return element;
	}
	
	/** Find Flight Inner DIV */
	public static WebElement innerDIV_FindFlight(WebDriver driver) {
		wait = new WebDriverWait(driver, 80);
		locator = By.xpath("//div[@id='findFlight_dialog']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element = driver.findElement(locator);
		return element;
	}
	
	/** Find aircraft Inner DIV */
	public static WebElement innerDIV_FindAircraft(WebDriver driver) {
		wait = new WebDriverWait(driver, 80);
		String ffDivXPath = "//div[@id='findAC_dialog']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ffDivXPath)));
		element = driver.findElement(By.xpath(ffDivXPath));
		return element;
	}
	
	/** Flight No. textbox inside Find Flight Dialog */
	public static WebElement txtBx_FlightNoOnFindFlight(WebDriver driver) {
		wait = new WebDriverWait(driver, 80);
		String fnXPath = "//div[contains(@id,'IATAflightIdLabel')]//input[contains(@id,'fltNo')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fnXPath)));
		element = driver.findElement(By.xpath(fnXPath));
		return element;
	}
	
	/** Date Field On Find Flight Dialog */
	public static WebElement txtbx_DateFieldOnFindFlight(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[contains(@id,'flightDateLabel')]"));
		return element;
	}
	
	/** Departure textbox inside Find Flight Dialog */
	public static WebElement txtBx_DepFieldOnFindFlight(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(@id,'departureAirportLabel')]//span[text()='Dep']"));
		return element;
	}
	
	/** Departure field on Find Flight Dialog in Gantt Screen*/
	public static WebElement txtBx_DepSearchOnFindFlight(WebDriver driver) {
		element = driver.findElement(By.xpath("//body/div[@id='select2-drop']/div//input"));
		return element;
	}
	
	/** Arrival textbox inside Find Flight Dialog */
	public static WebElement txtBx_ArrFieldOnFindFlight(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(@id,'arrivalAirportLabel')]//span[text()='Arr']"));
		return element;
	}
	
	public static WebElement txtBx_ArrSearchOnFindFlight(WebDriver driver) {
		element = driver.findElement(By.xpath("//body/div[@id='select2-drop']/div//input"));
		return element;
	}
	
	/** Departure, Arrival search list in Find Flight Dialog */
	public static WebElement link_FilterResult(WebDriver driver) {
		wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='select2-result-label']")));
		element = driver.findElement(By.xpath("//div[@class='select2-result-label']"));
		return element;
	}
	
	/** Search button on Find Flight in Gantt Screen */
	public static WebElement btn_SearchOnFindFlight(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@ng-click='findFlight()']"));
		return element;
	}
	
	/** Flight Detail Text in Flight Leg Details Dialog */
	public static WebElement label_FlightIDInFLD(WebDriver driver) {
		wait = new WebDriverWait(driver, 200);
		String flightIdXPath = "//label[text()='Flight ID']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flightIdXPath)));
		element = driver.findElement(By.xpath(flightIdXPath));
		return element;
	}
	
	/** Estimated Out Time on Flight Leg Details in Gantt Screen */
	public static WebElement txtBx_EstOutTime(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='flightLegDetailsWidgetModel_outEstTime']"));
		return element;
	}
	
	/** Actual Out Time on Flight Leg Details in Gantt Screen */
	public static WebElement txtBx_ActOutTime(WebDriver driver) {
		try {
			element = driver.findElement(By.xpath("//input[@name='flightLegDetailsWidgetModel_outActTime']"));
			return element;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	/** Estimated Off Time on Flight Leg Details in Gantt Screen */
	public static WebElement txtBx_EstOffTime(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='flightLegDetailsWidgetModel_offEstTime']"));
		return element;
	}
	
	/** Actual Off Time on Flight Leg Details in Gantt Screen */
	public static WebElement txtBx_ActOffTime(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='flightLegDetailsWidgetModel_offActTime']"));
		return element;
	}
	
	/** Estimated On Time on Flight Leg Details in Gantt Screen */
	public static WebElement txtBx_EstOnTime(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='flightLegDetailsWidgetModel_onEstTime']"));
		return element;
	}
	
	/** Actual On Time on Flight Leg Details in Gantt Screen */
	public static WebElement txtBx_ActOnTime(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='flightLegDetailsWidgetModel_onActTime']"));
		return element;
	}
	
	/** Estimated In Time on Flight Leg Details in Gantt Screen */
	public static WebElement txtBx_EstInTime(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='flightLegDetailsWidgetModel_inEstTime']"));
		return element;
	}
	
	/** Actual In Time on Flight Leg Details in Gantt Screen */
	public static WebElement txtBx_ActInTime(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='flightLegDetailsWidgetModel_inActTime']"));
		return element;
	}
	
	/** Delay Reason on Flight Leg Details in Gantt Screen */
	public static WebElement list_DelayReasonList(WebDriver driver) {
		String elemXpath = "//div[@class='row form-group ng-scope']//div[@id='s2id_dl1']/a[@class='select2-choice select2-default']";
		element = driver.findElement(By.xpath(elemXpath));
		return element;
	}
	
	/** Delay Reason Search box on Flight Leg Details in Gantt Screen */
	public static WebElement txtBx_DelayReasonSearchBox(WebDriver driver) {
		String elemXpath = "//div[@id='select2-drop']//input[@class='select2-input']";
		wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemXpath)));
		return element;
	}
	
	/** Delay Reason Item on Flight Leg Details in Gantt Screen */
	public static WebElement link_DelayReasonItem(WebDriver driver, String reasonText) {
		String elemXpath = "//div[text()='"+reasonText+"']";
		wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemXpath)));
		return element;
	}
	
	/** Update button on Find Leg Details Dialog in Gantt Screen */
	public static WebElement btn_Update(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		return element;
	}
	
	/** Update Success Message on Find Leg Details Dialog in Gantt Screen */
	public static WebElement msg_DataSavedSuccess(WebDriver driver) {
		try {
			wait = new WebDriverWait(driver, 40);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Data saved successfully.']")));
		} catch(TimeoutException nse) {System.out.println("msg not appearing");}		
		return element;
	}
	
	/** Update Success Message on Find Leg Details Dialog in Gantt Screen */
	public static WebElement msg_flightLegUnassigned(WebDriver driver) {
		try {
			wait = new WebDriverWait(driver, 5);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text()='The selected flight leg is unassigned.')]")));
		} catch(TimeoutException nse) {}		
		return element;
	}
	
	/** Close Flight Leg Dialog */
	public static WebElement btn_CloseFlightLegDetail(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Flight Leg Details')]/following-sibling::div/button"));
		return elements.get(0);
	}

	/** Cancel Flight Option in Flight Puck (right click) */
	static WebElement link_cancelOption(WebDriver driver) {
		return driver.findElement(By.xpath("//li//span[text()='Cancel']"));
	}
	
	/** Cancel Option under Cancel flight in Flight Puck (right click) */
	static WebElement link_cancelFlightOption(WebDriver driver) {
		return driver.findElement(By.xpath("//li//span[text()='Cancel Flight']"));
	}
	
	/**
	 * Crew Connection Detail button in 
	 * @param driver
	 * @return
	 */
	public static WebElement btn_CrewConnDetails(WebDriver driver){
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Crew Connection View']")));
        element = driver.findElement(By.xpath("//li[@title='Crew Connection View']"));
        return element;
	}
	
	/** Flight Connection Detail window in Gantt */
	public static WebElement window_FlightConnDetails(WebDriver driver){
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Flight Connection Details')]")));
        element = driver.findElement(By.xpath("//span[contains(text(),'Flight Connection Details')]"));
        return element;
	}
	
	/** Dayzoom link in Gantt Page */
	public static WebElement link_DayZoom(WebDriver driver) {
		wait = new WebDriverWait(driver, 100);
		locator = By.xpath("//li[@title='Day zoom']//a[@class='tool_icon icon18']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element = driver.findElement(locator);
		return element;
	}
	
	/**
	 * View Dropdown list inside Flight Leg Details Window
	 */
	public static WebElement btn_ViewDropdownInFlightLegDetails(WebDriver driver){
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='W1_FLDMenu_ActListBtn']")));
        element = driver.findElement(By.xpath("//button[@id='W1_FLDMenu_ActListBtn']"));
        return element;
	}
	
	/** Static label text 'Cock Pit Crew' under Flight Connection Details Window */
	public static WebElement label_CockPitCrewUnderFlightConnDetails(WebDriver driver){
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Cockpit Crew')]")));
        element = driver.findElement(By.xpath("//th[contains(text(),'Cockpit Crew')]"));
        return element;
	}
	
	/**
	 * 
	 */
	public static WebElement btn_CrewTabUnderFlightConnDetails(WebDriver driver){
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@heading='Crew']")));
        element = driver.findElement(By.xpath("//li[@heading='Crew']"));
        return element;
	}
	
	/**
	 * 
	 */
	public static WebElement msg_DeleteFlightSuccess(WebDriver driver){

		wait=new WebDriverWait(driver,80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='sp-msg-box']//span[contains(text(),'Flight(s) deleted successfully.')]")));
        element = driver.findElement(By.xpath("//ul[@class='sp-msg-box']//span[contains(text(),'Flight(s) deleted successfully.')]"));
        return element;
	}
	
	/**
	 * 
	 */
	public static WebElement msg_FlightNotAvailable(WebDriver driver){
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Flight does not exist within the filter criteria.')]")));
        element = driver.findElement(By.xpath("//span[contains(text(),'Flight does not exist within the filter criteria.')]"));
        return element;
	}
	
	/**
	 * 
	 */
	public static WebElement dialog_RuleWarning(WebDriver driver){
		wait=new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Rule Warning')]")));
        return element;
	}
	
	public static WebElement dialog_geographicaldiscontinuity(WebDriver driver){
		wait=new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Confirmation Message')]")));
        return element;
	}
	/**
	 * 
	 */
	public static WebElement link_PanRectangleOptionInGantt(WebDriver driver){
		wait=new WebDriverWait(driver,30);
        element = driver.findElement(By.xpath("//li[@title='Pan/Rectangle Select']"));
        return element;
	}
	
	/*******************************************************
	 * Description: Remarks tab in Flight Leg Details window
	 *******************************************************/
	public static WebElement link_RemarksTab(WebDriver driver){
        element = driver.findElement(By.xpath("//a//div[contains(text(),'Remarks')]"));
        return element;
	}
	
	/*******************************************************
	 * Description: Remarks type drop down in Flight Leg Details window
	 *******************************************************/
	public static WebElement list_RemarksTypeInFlightLegDetailsWindow(WebDriver driver){
        element = driver.findElement(By.xpath("//label[contains(text(),'Remarks')]/following-sibling::div/a"));
        return element;
	}
	
	/** Remarks Description Text box In Flight Leg Details Window */
	public static WebElement txtBx_RemarksDescriptionInFlightLegDetailsWindow(WebDriver driver){
        element = driver.findElement(By.xpath("//textarea[@ng-model='flightLegDetailsWidgetModel.remarkDescription']"));
        return element;
	}
	
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement btn_AddButtonInRemarksTab(WebDriver driver){
        element = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        return element;
	}
	
	/**
	 * Description: Find Aircraft button in gantt screen
	 * @param driver
	 * @return
	 */
	public static WebElement btn_FindAircraft(WebDriver driver){
        element = driver.findElement(By.xpath("//li[@title='Find Aircraft']"));
        return element;
	}
	
	/**
	 * Description: Find Aircraft registration drop down in gantt screen
	 * @param driver
	 * @return
	 */
	public static WebElement list_AircraftRegistration(WebDriver driver){
		wait=new WebDriverWait(driver,30);
        element = driver.findElement(By.xpath("//label[contains(text(),'A/C Registration')]/following-sibling::div"));
        return element;
	}
	
	/** Description: search button in aircraft registration filter window in gantt screen */
	public static WebElement btn_SearchButton(WebDriver driver){
        element = driver.findElement(By.xpath("//button//span[contains(text(),'Search')]"));
        return element;
	}
	
	/**
	 * Change Gantt Mode to Real World or New Scenario Mode
	 * return the dropdown element SYD out of a dropdown list
	 */
	public static WebElement list_SYDElement(WebDriver driver) {
		String xpathDropdownItem = "//div[contains(text(),'SYD')]";
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathDropdownItem)));
		
		element = driver.findElement(By.xpath(xpathDropdownItem));
		return element;
	}
	
	/** Reason Code for flight cancellation*/
	private static WebElement reasonCode(WebDriver driver) {
		return driver.findElements(By.xpath("//td[@class='ng-scope']")).get(0);
	}
	
	/**
	 * TODO HANNU merge
	 * 
	 * find the dropdown for airports
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement list_Airport(WebDriver driver) {
		//changed path because of application upgrade in third week of August
		//String xpath = "//th[contains(text(),'Filter Name  - generic airport name')]/../../../tbody/tr/td/table/tbody/tr/td/div/div[5]/div/div/div/div/a";
		String xpath = "(//a[@class='select2-choice'])[last()]";
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	/**
	 * TODO HANNU merge
	 * 
	 * find the textbox for the filtername in the dropdown searching for an existing filter
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement txtBx_ForFilter(WebDriver driver) {
		String xpath = "//div[@id='select2-drop']/div/input";
		
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	/**
	 * TODO HANNU merge
	 * 
	 * find the apply button
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement btn_Apply(WebDriver driver) {
		String xpath = "//th[contains(text(),'Filter Name  - generic airport name')]/../../../../../div[2]/div/ul/li/button";
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	/** CTOT text box on Flight Leg Details Window in Gantt Page */
	public static WebElement txtBx_CTOTime(WebDriver driver) {
		element = driver.findElement(By.name("flightLegDetailsWidgetModel_ctot"));
		return element;
	}
	
	/** Add Pane drop down list available in Gantt toolbar to select available panes */
	public static WebElement link_AddPanes(WebDriver driver) {
		wait = new WebDriverWait(driver, 50);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='W1_GanttPaneMenu_ActListBtn']")));
		return element;
	}
	
	/** Available Pane options inside Add Pane */
	public static WebElement link_AvailablePanes(WebDriver driver, String paneName) {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='dropdown-menu']//a[text()='"+paneName+"']")));
		return element;
	}
	
	/** ForcePublish button in Rule Warning dialog */
	public static WebElement btn_ForcePublish(WebDriver driver){
		wait=new WebDriverWait(driver,30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='forcePublish()']")));
        return element;
	}
	
	/** Confirmation button in Geographical discontinuity dialog */
	public static WebElement btn_discontinuity(WebDriver driver){
		wait=new WebDriverWait(driver,30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'YES')]")));
        return element;
	}
	
//*******************************************************************************************************************/ 
//						SPACE FOR METHOD DEFINITION
//*******************************************************************************************************************/
	
	/*******************************************************
	 * Change Gantt Mode to Real World or New Scenario Mode
	 *******************************************************/
	public static boolean changeGanttMode(WebDriver driver, String ganttMode) throws InterruptedException {
		wait = new WebDriverWait(driver, 400);
		boolean ganttOpen = true;
		try{
			// Toggle to Real World
			//com.performAction(driver, btn_ToggleArrowInLWGantt(driver), "Click", "", "Toggle Dropdown Arrow"); comments: after new build 3.46.20.0 deployment this code not working hence added below action code
			Actions action = new Actions(driver);
			action.moveToElement(btn_ToggleArrowInLWGantt(driver));
			Thread.sleep(1000);
			btn_ToggleArrowInLWGantt(driver).click();
			if(ganttMode.contains("Real World")) {
				com.performAction(driver, link_RealWorldOptionInGanttFilter(driver), "Click", "", "Real World Option");
			}
			else if(ganttMode.contains("New Scenario")) {
				com.performAction(driver, link_NewScenarioModeOptionInGanttFilter(driver), "Click", "", "New Scenario Mode");
			}
			// Wait
			int waitTime=1;
			for(; waitTime<=60; waitTime++) {
				List<WebElement> ganttTabs = driver.findElements(By.xpath("//li[@text='pagevo.title']"));
				if(ganttTabs.size()>1) {
					try {
						Thread.sleep(1000);
						WebElement errMessage = driver.findElement(By.xpath("//span[contains(text(),'Maximum Number of allowable local world count reached')]"));
						if(errMessage.isDisplayed()) {
							report.logReport("Verify "+ganttMode+" Open Successfully", ganttMode+ " Does NOT Open", "FAIL", driver, true);
							ganttOpen = false;
							break;
						}
					}
					catch(Exception ex) {
						report.logReport("Verify "+ganttMode+" Open Successfully", ganttMode+ " Open Successful", "INFO", driver, true);
						break;
					}
				}
				else {
					Thread.sleep(1000);
				}
			}
			if(waitTime>60) {
				report.logReport("Verify "+ganttMode+" Open Successfully", ganttMode+ " Does NOT Open", "FAIL", driver, true);
				ganttOpen = false;
			}
		}
		catch(NullPointerException npe) {
			ganttOpen = false;
		}
		return ganttOpen;
	}
	
	/*******************************************************
	 * Method to Find Flight in Gantt Screen
	 *******************************************************/
	public static void findFlightInGantt(WebDriver driver, String flightNo, String date, String depCode, String arrCode) {
		try {
			imgLink_FindFlight(driver).click();
			//find_Flight(driver).click();
			Actions action = new Actions(driver);
			action.moveToElement(innerDIV_FindFlight(driver));
			// Flight No.
			txtBx_FlightNoOnFindFlight(driver).sendKeys(flightNo);
			// Flight Date
			txtbx_DateFieldOnFindFlight(driver).clear();
			txtbx_DateFieldOnFindFlight(driver).sendKeys(date);
			// Departure 
			if(depCode.length()!=0)
			{
			txtBx_DepFieldOnFindFlight(driver).click();
			txtBx_DepSearchOnFindFlight(driver).sendKeys(depCode);
			link_FilterResult(driver).click();
			}
			// Arrival
			if(arrCode.length()!=0)
			{
			txtBx_ArrFieldOnFindFlight(driver).click();
			txtBx_ArrSearchOnFindFlight(driver).sendKeys(arrCode);
			link_FilterResult(driver).click();
			}
			report.logReport("Capture Flight Search Data Points", "Flight Search Data Captured", "INFO", driver, true);
			//adding wait to allow loading of the gantt screen
			Thread.sleep(5000);
			// Search
			btn_SearchOnFindFlight(driver).click();
			// Close Dialog
			dialog_FindFlight(driver).sendKeys(Keys.ESCAPE);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			report.logReport("Find Flight in Gantt", "Unable to Find Flight due to Exception "+ex.getMessage(), "FATAL", driver, true);
		}
	}
	
	/*******************************************************
	 * Method to go to Tabular Pane in Gantt Screen
	 *******************************************************/
	public static void gotoTabularPane(WebDriver driver) {
		// Pane options drop down link
		com.performAction(driver, link_AddPanes(driver), "click", "", "Add Pane Option");
		// Tabular Pane
		com.performAction(driver, link_AvailablePanes(driver, "Tabular Pane"), "click", "", "Tabular Pane");
	}
	
	/*******************************************************
	 * Method to go to Unassinged Pane in Gantt Screen
	 *******************************************************/
	public static void gotoUnassignedPane(WebDriver driver) {
		// Pane options drop down link
		com.performAction(driver, link_AddPanes(driver), "click", "", "Add Pane Option");
		// Tabular Pane
		com.performAction(driver, link_AvailablePanes(driver, "Unassigned Pane"), "click", "", "Unassigned Pane");
	}
	
	/*******************************************************
	 * Method to go to Trip View in Gantt Screen
	 *******************************************************/
	public static void goToTripViewWindow(WebDriver driver) {
		WebElement tripwindow=driver.findElement(By.xpath("//button[@id='W1_TripViewMenu_ActListBtn']"));
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(tripwindow));
		tripwindow.click();
		driver.findElement(By.xpath("//li[@id='W1_TripViewMenu_2']")).click();	
	}
	
	/*******************************************************
	 * Method to Find Flight in Trip View in Gantt Screen
	 *******************************************************/
	public static void findFlightInTripView(WebDriver driver, String flightNo, String Date) {
		imgLink_FindFlight(driver);
		//find_Flight(driver).click();
		Actions action = new Actions(driver);
		action.moveToElement(dialog_FindFlight(driver));
		txtBx_FlightNoOnFindFlight(driver).sendKeys(flightNo);
		txtbx_DateFieldOnFindFlight(driver).clear();
		txtbx_DateFieldOnFindFlight(driver).sendKeys(Date);
		dialog_FindFlight(driver).sendKeys(Keys.ESCAPE);
	}
	
	/*******************************************************
	 * Method to navigate to flight leg details in Gantt screen 
	 *******************************************************/
	public static boolean selectFlightInGantt(WebDriver driver, String flightImageLocation, String clickType) {
		boolean imageFound = true;
		try {
			Screen scn = new Screen();
			Pattern defaultFlight = new Pattern(flightImageLocation);
			scn.wait(defaultFlight, 90);
			Match match = scn.exists(defaultFlight.similar(0.70));
			if(match!=null) {
				switch(clickType.toUpperCase()) {
				case "RIGHTCLICK":
					scn.rightClick(defaultFlight);
					report.logReport("Verify Right Click Operation on Flight", "Options Applicable on Flight is Displayed", "INFO", driver, false);
					break;
				case "SINGLECLICK":
					scn.click(defaultFlight);
					report.logReport("Verify Single Click Operation on Flight", "Flight is Selected", "INFO", driver, true);
					break;
				case "HOVER":
					scn.hover(defaultFlight);
					// Adding below code to capture hover screenshot ( 1st sep,21 by Moumita)
					Thread.sleep(2000);
					report.logReport("Verify Hover Operation on Flight", "Hover performed over flight", "INFO", driver, true);
					break;
				default:
					// scn.hover();
					Thread.sleep(1000);
					scn.doubleClick(defaultFlight);
					// Wait
					label_FlightIDInFLD(driver);
                    report.logReport("Verify Flight Leg Detail Dialog Opens", "Flight Leg Detail Dialog Opened", "INFO", driver, true);

				}
			}
			else {
				System.out.println("***IMAGE NOT FOUND TO SELECT***");
				report.logReport("Verify Flight Leg Detail Dialog Opens", "Flight Leg Detail Dialog Does NOT Open", "FAIL", driver, true);
				imageFound = false;
			}
		}
		catch(NoSuchElementException nsee) {
			imageFound = false;
			System.out.println("NO SUCH ELEMENT FOUND");
			report.logReport("Verify Image is Present", "The Required Image is Not Present", "FAIL", null, true);
		}
		catch(Exception e) {
			imageFound = false;
			report.logReport("Verify Image is Present", "There is a Fatal Error - "+ e.getMessage(), "FATAL", null, true);
		}
		return imageFound;
	}

	/*******************************************************
	 * Method to Cancel flight in Gantt screen 
	 *******************************************************/
	public static void cancelFlight(WebDriver driver, String imagePath) throws InterruptedException
	{   
		Thread.sleep(2000);
		if(bizCom.getImageWithSikuli(imagePath)!=null)
		{
		// Right Click on flight puck
		IFlightNeo_Gantt.selectFlightInGantt(driver, imagePath, "rightClick");
		}
		// Select Cancel Option
		Actions a5 = new Actions(driver);
	    a5.moveToElement(link_cancelOption(driver)).perform();
		// Cancel
        com.performAction(driver, link_cancelFlightOption(driver), "Click", "", "Cancel Flight");
        //driver.switchTo().alert().accept(); 
        Thread.sleep(4000);
        
       
        try
        {
        	//Click Yes if geographical discontinuity appears
         boolean ifgeographicalDiscontinuity=driver.findElement(By.xpath("//div[contains(text(),'Do you want to continue?')]")).isDisplayed();
         if (ifgeographicalDiscontinuity==true)
         {
         driver.findElement(By.xpath("//span[text()='YES']")).click();
         }
         else
         {
         Thread.sleep(4000);
         }
         
        
        //Click Yes for cancellation confirmation
       
        boolean ifcancelPopupappear= driver.findElement(By.xpath("//div[text()='Do you want to cancel the Flight?']")).isDisplayed();
        
        if (ifcancelPopupappear==true)
        	
        {
        	driver.findElement(By.xpath("//span[text()='YES']")).click();
        	com.performAction(driver, reasonCode(driver), "click", "", "Select Reason Code");
            driver.findElement(By.xpath("//div[text()='ATC']")).click();
            driver.findElement(By.xpath("//li//button[text()='Publish']")).click();

        }
        
        else
        	
        {    
        com.performAction(driver, reasonCode(driver), "click", "", "Select Reason Code");
        driver.findElement(By.xpath("//div[text()='ATC']")).click();
        driver.findElement(By.xpath("//li//button[text()='Publish']")).click();
	      }
        
        
        
        }
        
        catch(Exception e)
        {
        	boolean ifcancelPopupappear= driver.findElement(By.xpath("//div[text()='Do you want to cancel the Flight?']")).isDisplayed();
            
            if (ifcancelPopupappear==true)
            	
            {
            	driver.findElement(By.xpath("//span[text()='YES']")).click();
            	com.performAction(driver, reasonCode(driver), "click", "", "Select Reason Code");
                driver.findElement(By.xpath("//div[text()='ATC']")).click();
                driver.findElement(By.xpath("//li//button[text()='Publish']")).click();

            }
            
            else
            	
            {    
            com.performAction(driver, reasonCode(driver), "click", "", "Select Reason Code");
            driver.findElement(By.xpath("//div[text()='ATC']")).click();
            driver.findElement(By.xpath("//li//button[text()='Publish']")).click();
    	      }
            
            
        }
       
        Thread.sleep(10000);
        
        try {
        	if (bizCom.getImageWithSikuli(imagePath)==null)
        	//change in code after upgrade in Aug,2021
        	report.logReport("Verify Flight Cancelled", "Flight Cancelled Successfully", "Pass", driver, true);
        	else 
        	report.logReport("Verify Flight Cancelled", "Flight not Cancelled Successfully", "Pass", driver, true);
        	
        }
        catch (NullPointerException npe) {

        	report.logReport("Verify Flight Cancelled", "Flight Cancellation Successfully", "Pass", driver, true);
		}

	}
	
	/**************************************************************************
	 * Description: Method to swap flights in 2 different aircraft registration
	 **************************************************************************/
	public static void unassignFlight(final WebDriver driver) throws Exception {
		WebElement unassign = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']//span[text()='Unassign']"));
	    // Mouse over Unassign option 
		Actions action = new Actions(driver);
	    action.moveToElement(unassign).build().perform();
	    // Select Unassign leg
	    WebElement subOption = driver.findElement(By.xpath("//ul[@class='context-menu-list']//span[text()='Unassign Leg']"));
	    com.performAction(driver, subOption, "Click", "", "Unassign Leg");
	    // Wait for Rule warning (if exists)
	    try {   
	    	IFlightNeo_HomePage.geographicaldiscontinuity(driver);
	    	Thread.sleep(3000);
	    	IFlightNeo_HomePage.forcepublish(driver);	
        	//To handle rule warning
	       Thread.sleep(1000);
	       
	    }
         catch(Exception e) 
	            {
        	e.printStackTrace();
        	
        	        }
        	
        
    }
	
	/**
	 * this applies a filter in the GANTT chart. the test case NeoOps_AAF_TC001 must have been executed before that.
	 * 
	 * @param driver
	 */
	public static void applyFilter_Gantt(WebDriver driver) {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Aircraft subtype_32']")));
		element = driver.findElement(By.xpath("//li[@title='Aircraft subtype_32']"));
		com.performAction(driver, element, "CLICK","apply filter","apply filter");
	}

	/**
	 * this applies a filter in the GANTT chart. the test case NeoOps_AAF_TC001 must have been executed before that.
	 * 
	 * @param driver
	 */
	public static boolean verifyFilter_Gantt(WebDriver driver) {
		try {
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Aircraft subtype_32']")));
			
			com.performAction(driver,driver.findElement(By.xpath("//li[@title='Aircraft subtype_32']")),"CLICK","apply filter","apply filter");
		}
		catch (TimeoutException te) {
			return false;
		}		

		return true;
	}

	/**
	 * TODO: Hannu to merge and maybe to rename, depending on what others names look like
	 * this applies a filter in the GANTT chart. the test case NeoOps_AAF_TC001 must have been executed before that.
	 * 
	 * @param driver
	 */
	public static void applyGenericAirportFilter_Gantt(WebDriver driver) {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='generic airport name']")));
		
		com.performAction(driver,driver.findElement(By.xpath("//li[@title='generic airport name']")),"CLICK","apply filter","apply filter");
		
		// click on the dropdown for airport
		com.performAction(driver,list_Airport(driver), "CLICK", "select airport", "select airport");
		//type SYD into the textfield to narrow down the search in the drop down
		com.performAction(driver,txtBx_ForFilter(driver), "SET", "SYD", "search for SYD in filter name");
		//click on the button to select an SYD from the dropdown
		com.performAction(driver,list_SYDElement(driver), "CLICK", "select SYD", "select SYD");
		// click on the apply button
		com.performAction(driver,btn_Apply(driver),"CLICK","apply button","apply button");
	}

	public static void publish_Localworld(WebDriver driver) {
		//if(driver.findElement(By.xpath("//span[text()='Confirmation Message']")).isDisplayed())
		//{  
			//com.performAction(driver,confirmationmsg_Geographicalalert(driver),"click","","geographical discontinuety confirmation");
			//span[text()='YES']
			wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Publish Localworld']")));
			// TODO Auto-generated method stub
			com.performAction(driver,icon_Localworldpublish(driver),"click","","publish local world");
		//}
		
		//else if (!driver.findElement(By.xpath("//span[text()='Confirmation Message']")).isDisplayed())
		//{
			//wait = new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Publish Localworld']")));
			// TODO Auto-generated method stub
			//com.performAction(driver,icon_Localworldpublish(driver),"click","","publish local world");
		//}
		
	}

	private static WebElement confirmationmsg_Geographicalalert(WebDriver driver) {
		WebElement element=driver.findElement(By.xpath("//span[text()='YES']"));
		return element;

	}

	private static WebElement icon_Localworldpublish(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(By.xpath("//li[@title='Publish Localworld']"));
		return element;
	}

	public static void dragFlightconnectiondetailswindow(WebDriver driver) {
		// TODO Auto-generated method stub
		Actions action =new Actions(driver);
		WebElement source = driver.findElement(By.xpath("//span[text()='Flight Connection Details']"));
		action.dragAndDropBy(source, 0, -250).perform();
		
	}

	public static void closeFlightconnectiondetailwindow(WebDriver driver) {
		// TODO Auto-generated method stub
		Actions action =new Actions(driver);
		action.moveToElement(IFlightNeo_Gantt.window_FlightConnDetails(driver)).sendKeys(Keys.ESCAPE).build().perform();
		
	}

	public static int Connectiontimetablerowcount(WebDriver driver) {
		// TODO Auto-generated method stub
		List<WebElement> inboundTable=driver.findElements(By.xpath("//table[contains(@id,'InBoundConnectionGrid')]/tbody/tr[contains(@class,'ui-row-ltr')]"));
		int inbountConnection_count=inboundTable.size();
		return inbountConnection_count;
	}
	
	/*****************************************************************************************
	 * Method for dynamic wait between two elements
	 * @throws InterruptedException
	 * ***************************************************************************************/
	//Modified the method on 18th Jan,2022 to give correct connection count

	public static int InboundorOutboundlistexists(WebDriver driver) throws InterruptedException
	     {
			int wait=1;
			
			int InboundorOutboundlistexists = 0;
			for(;wait<90;wait++) {
				try{
					boolean Inconnection=driver.findElement(By.xpath("//table[contains(@id,'InBoundConnectionGrid')]//tr[2]")).isDisplayed();
					
					if(Inconnection==true)
					{InboundorOutboundlistexists=1;
		            break;}
				}
				catch(Exception nse) {
					try {
						boolean Outconnection=driver.findElement(By.xpath("//table[contains(@id,'OutBoundConnectionGrid')]//tr[2]")).isDisplayed();
						if(Outconnection==true)
						{InboundorOutboundlistexists=2;
						break;}
					}
					catch(Exception nse1) {
						InboundorOutboundlistexists=3;
						Thread.sleep(1000);
					}
				}
			}
			return InboundorOutboundlistexists;
	    }

	public static void customized_Zoom(WebDriver driver, String date_zoom) {
		// TODO Auto-generated method stub
		com.performAction(driver,customized_Zoomdate(driver),"CLICK","","Customized Zoom");
		com.performAction(driver,customized_date(driver),"SET",date_zoom+Keys.TAB,"Customized Zoom");
		
	}

	private static WebElement customized_date(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//input[@name='ganttFormsWidgetModel_gotoDate']"));
	}

	private static WebElement customized_Zoomdate(WebDriver driver) {
		// TODO Auto-generated method stub
		//Title has changed to "Go to and Customize zoom" from "Goto and Customize zoom", noticed after 21st Jan,22 build , already changed on 1st feb,22 need confirmation
		return driver.findElement(By.xpath("//li[@title='Go to and Customize zoom']"));
	}

	public static String calculatecustomized_Zoomdate(WebDriver driver, String date_zoom) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");  
		Date newdate_zoom=dateFormat.parse(date_zoom);  
		
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
	    cal.setTime(newdate_zoom);
	    cal.add(Calendar.DATE, -2); //minus number would decrement the days
	    Date Newdate=cal.getTime();
	    
	    String strDate = dateFormat.format(Newdate);  
	    System.out.println(strDate);
	    return strDate;
	
	}

	public static void btn_customized_Zoom(WebDriver driver) {
		com.performAction(driver, btn_apply(driver), "Click", "", "Apply button");
		
	}

	private static WebElement btn_apply(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@ng-click='applyGoToGantt()']"));
	}
	
	/***
	 * function to set filter of the arrival airport to SIN in the tabular pane
	 * 
	 * @param driver
	 * @throws InterruptedException 
	 */
	public static void set_filterarrival(WebDriver driver) throws InterruptedException {
		com.performAction(driver, filter_arrivalairport(driver), "click", "", "click on arrival filter");

		com.performAction(driver, filter_textfieldarrivalairport(driver), "click", "", "click on arrival textfield filter");
		Thread.sleep(3000); 
    	com.performAction(driver, txtBx_arrivalairportfilter(driver), "SET", "SIN", "enter airport name for filter");
    	Thread.sleep(3000); 
    	com.performAction(driver, list_SYD(driver), "click", "", "select SIN");
    	Thread.sleep(2000);		
		com.performAction(driver, btn_arrivalairportfilter(driver), "click", "", "click on search");
	}	
	
	/** Link tabular pane link available in Gantt toolbar in RHS */
	public static WebElement link_LinkTabularpane(WebDriver driver) {
		//changed path because of application upgrade in third week of August
//		element = driver.findElement(By.xpath("//li[@title='Link TabularPane']//a"));
		element = driver.findElement(By.xpath("//li[@title='Link tab']//a"));
		return element;
	}
	
	public static WebElement txtBx_arrivalairportfilter(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='s2id_autogen28']"));
		return element;
	}

	public static WebElement btn_arrivalairportfilter(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='TabularPaneGrid_W1_arrivalAirport_Search']"));
		return element;
	}

	public static WebElement list_SYD(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(text(),'SIN')]"));
		return element;
	}
	
	public static WebElement filter_arrivalairport(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='jqgh_TabularPaneGrid_W1_arrivalAirport']"));
		return element;
	}
	
	public static WebElement filter_textfieldarrivalairport(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='jqgh_TabularPaneGrid_W1_arrivalAirport']/../div[2]/button"));
		return element;
	}

	public static void clearFilter(WebDriver driver) {
		com.performAction(driver,btn_clearFilter(driver),"CLICK","clearFilter button","clearFilter button");
	}

	public static WebElement btn_clearFilter(WebDriver driver) {
		String xpath = "//li[@title='OPS Clear Filters']/a";
		
		element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/**
	 * this function is to verify if one of the elements sent in the second argument
	 * stations is on the current website
	 * 
	 * @param driver
	 * @param stations stations to be searched for on the website
	 * @return
	 */
	public static boolean findStation(WebDriver driver, String[] stations) {		
		for(int stationNumber=0;stationNumber<stations.length;stationNumber++) {
			try {
				driver.findElement(By.xpath("//td[text()='" + stations[stationNumber] + "']"));
				return true;
			}
			catch(Exception e) {}
		}				
		return false;
	}

	/***
	 * this is to open the tabularpane without using W1 in the search. there is a similar function in Gantt
	 * @param driver
	 */
	public static void click_tabularpaneWithoutW1(WebDriver driver) {
		com.performAction(driver, link_tabularpaneWithoutW1(driver), "click", "", "Tab pane options");
		com.performAction(driver, clickon_tabularpaneWithoutW1(driver), "click", "", "Tab pane");
	}
	
	/***
	 * this is to open the tabularpane without using W1 in the search. there is a similar function in Gantt
	 * @param driver
	 * @return
	 */
	public static WebElement link_tabularpaneWithoutW1(WebDriver driver) {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='gantt_menu_dropdown'])[2]/div/iflight-action-menu/div/div/button")));
		element = driver.findElement(By.xpath("(//div[@class='gantt_menu_dropdown'])[2]/div/iflight-action-menu/div/div/button"));
		return element;
	}

	/***
	 * this is to open the tabularpane without using W1 in the search. there is a similar function in Gantt
	 * @param driver
	 * @return
	 */
	public static WebElement clickon_tabularpaneWithoutW1(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='dropdown-menu'])[4]/li[3]")));
		element = driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[4]/li[3]"));
		return element;
	}

	
	/***
	 * this is to link the tabular pane to the gantt
	 * @param driver
	 * @return
	 */
	public static WebElement link_LinkTabularpaneToGantt(WebDriver driver) {
		wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Link TabularPane']/a")));
//		element = driver.findElement(By.xpath("//li[@title='Link TabularPane']/a"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Link tab']/a")));
		element = driver.findElement(By.xpath("//li[@title='Link tab']/a"));
		return element;
	}
	
	/***
	 * this is to link the tabular pane to the gantt
	 * @param driver
	 */
	public static void click_LinkTabularpaneToGantt(WebDriver driver) {
		com.performAction(driver, link_LinkTabularpaneToGantt(driver), "click", "", "click to link TabularPane to Gantt");
	}

	/***
	 * this is to REVERSE link the tabular pane to the gantt
	 * @param driver
	 * @return
	 */
	public static WebElement link_ReverseLinkTabularpaneToGantt(WebDriver driver) {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iflight-action-menu[@title='Reverse Link']")));
		element = driver.findElement(By.xpath("//iflight-action-menu[@title='Reverse Link']"));
		return element;
	}
	
	/***
	 * this is to REVERSE link the tabular pane to the gantt
	 * @param driver
	 */
	public static void click_ReverseLinkTabularpaneToGantt(WebDriver driver) {
		com.performAction(driver, link_ReverseLinkTabularpaneToGantt(driver), "click", "", "click to Reverse link TabularPane to Gantt");
	}

	/**
	 * this cancels a flight. 
	 * pre-requisite: someone must have right click on the flight in the Gantt
	 * 
	 * @param driver
	 * @return
	 * @throws InterruptedException 
	 */
	public static void cancelFlightFromGantt(WebDriver driver) throws InterruptedException {
		// click on "Cancel"
		com.performAction(driver, dropdown_CancelElement(driver), "CLICK", "Click on Cancel", "Click on Cancel");
		Thread.sleep(1000);
		// click on "Cancel All"
		com.performAction(driver, dropdown_CancelAllElement(driver), "CLICK", "Click on Cancel All", "Click on Cancel All");
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		// click on the confirmation to cancel
		com.performAction(driver, btn_confirmCancellation(driver), "CLICK", "confirm flight cancellation", "confirm flight cancellation");
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		// Force publish
		IFlightNeo_HomePage.forcepublish(driver);
		Thread.sleep(1000);
		
		// click on dropdown to select a reason
		com.performAction(driver, dropdown_reason(driver), "CLICK", "click on reason dropdown", "click on reason dropdown");
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		// select ATC from dropdown
		com.performAction(driver, dropdown_ATC(driver), "CLICK", "select ATC", "select ATC");
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		// click on PUBLISH button
		com.performAction(driver, btn_publish(driver), "CLICK", "click on publish button", "click on publish button");
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
	}
	
	/**
	 * click on the dropdown for the publish reason
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement dropdown_reason(WebDriver driver) {
		String xpath = "(//th[contains(text(),'RC1')])[1]/../../../tbody/tr[1]/td[2]/div/a";
		
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	/**
	 * select ATC from the dropdown for the publish reason
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement dropdown_ATC(WebDriver driver) {
		String xpath = "//div[text()='ATC']";
		
		element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/**
	 * click on the publish button
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement btn_publish(WebDriver driver) {
		String xpath = "//button[@ng-click='publish()']";
		
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	/**
	 * find the item for Cancel
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement dropdown_CancelElement(WebDriver driver) {
		String xpath = "(//span[contains(text(), 'Cancel')])[1]";
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	/**
	 * find the item for Cancel
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement dropdown_CancelAllElement(WebDriver driver) {
		String xpath = "//span[contains(text(), 'Cancel All')]";
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	/**
	 * confirm the cancellation in the popup
	 *  
	 * @param driver
	 * @return
	 */
	public static WebElement btn_confirmCancellation(WebDriver driver) {
		String xpath = "//span[contains(text(),'YES')]";
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	
	/*******************************************************
	 * Close Gantt Tab of Your Choice
	 *******************************************************/
	public static void closeGanttTab(WebDriver driver, int tabIndex) {
		link_RemoveGanttTab(driver).get(tabIndex).click();
	}
}

    


	/*public static boolean selectFlightLegDetails(WebDriver driver, String flightImageLocation) {
		Screen scn = new Screen();
		Pattern defaultFlight = new Pattern(flightImageLocation);
		Match match = scn.exists(defaultFlight);
		if(match!=null) {
			scn.doubleClick();
			// Wait
			label_FlightDetails(driver);
			htmlLib.logReport("Verify Flight Leg Detail Dialog Opens", "Flight Leg Detail Dialog Opened", "INFO", driver, false);
			return true;
		}
		else {
			htmlLib.logReport("Verify Flight Leg Detail Dialog Opens", "Flight Leg Detail Dialog Does NOT Open", "FAIL", driver, true);
			return false;
		}
	}*/


