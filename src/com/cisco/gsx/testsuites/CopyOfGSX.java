package com.cisco.gsx.testsuites;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

//import javax.mail.Session;


import com.cisco.gsx.pageObjects.EID_HolidayList;
import com.cisco.gsx.pageObjects.GSX_HotelReservation;
import com.cisco.gsx.pageObjects.GSX_RegistrationPage;
import com.cisco.gsx.pageObjects.LoginPage;
//import com.cisco.gsx.pageObjects.SessionCatalog;


import com.cisco.gsx.pageObjects.SessionCatalog;

import org.openqa.selenium.html5.SessionStorage;
import org.testng.annotations.Test;

import com.cisco.gsx.excelreader.Dataproviderclass;
import com.cisco.gsx.excelreader.DataPojoClass;
import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class CopyOfGSX {
	// public static AddressManagementHarnessCodeImpl harness = new
	// AddressManagementHarnessCodeImpl();
	/**
	 * Conformiq Designer generated test case Displays Informational message [in
	 * region To Verify that new siteID is created when user creates n~ install
	 * s~ id with n~ s~ address using a~ management option.] Name Digest
	 * (SHA-1), DO NOT REMOVE: 6d77d4f8db0e1134cef2b6385ada5ffb4233f830
	 */
	static Map<?, ?> map = null;
	static List<String> testlist;
	static int count;
	//private String testCaseName = null;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	// private boolean Q2O_ADDRESS_MGMT_ADDLINE = false;

	static {

		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	public void setUp(String testcaseName) {
		System.out.println("=============================" + testcaseName
				+ " Started =============================");
		//String browserType = "chrome";
		//String browserType = "firefox";
		String browserType = "chrome";
		System.out.println("DB - BrowserType" + browserType);
		CommonUtil.openBrowser(browserType);
		CommonUtil.openUrl(commonProperties.getProperty("cisco.gsx.url"));
		
	}

	public void tearDown(String testcaseName) {
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.logout"));
		CommonUtil.closeBrowser();
		System.out.println("=============================" + testcaseName
				+ " Ended =============================");
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void Login(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Login");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			LoginPage.error();
			this.tearDown("Login");
		}
		
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=8)
	public void eidHolidayRegistration(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("EID Holiday Registration");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			EID_HolidayList.validateRegistrationPage();
			EID_HolidayList.enterEIDContactInformation(pojo);
			
			
		
		}
	}
	
	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=1)
	public void executiveRegistration(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Executive Registration");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
			//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
			GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
		   GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			
		    //Select Dates
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
			this.tearDown("Executive Registration");
				
		}
	}
	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=1)
	public void attendeeRegistration(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Attendee Registration");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
		//	//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
		    GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			//Validate Registration confirmation page
			
			//Hotel information
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
			
			
			
			this.tearDown("Attendee Registration");
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=8)
	public void hubStaffRegistration(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("HubStaff Registration");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
		//	//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
		    GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			//Validate Registration confirmation page
			
			//Hotel information
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
			this.tearDown("Hubstaff Registration");
		}
	}
	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=8)
	public void SupportStaffRegistration(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("SupportStaff Registration");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
		//	//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
		    GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			//Validate Registration confirmation page
			
			//Hotel information
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
			this.tearDown("SupportStaff Registration");
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void managerExcellenceRegistration(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Manager Excellence Registration");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
			//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
			GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
		    GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			//Validate Registration confirmation page
			
			
			//Hotel information
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			this.tearDown("Manager Excellence Registration");
		}
	}

	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=8)
	public void eventStaffRegistration(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("eventStaff Registration");
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
		//	//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
		    GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			//Validate Registration confirmation page
			
			//Hotel information
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
			this.tearDown("eventStaffRegistration");
			}
		}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=9)
	public void RoomShareInformation(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Roomshare details ");
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			GSX_HotelReservation.makeHotelReservation();
			
			//Hotel information
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
			this.tearDown("Roomshare details");
			}
		}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void makeHotelReservation(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Roomshare details ");
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			GSX_HotelReservation.makeHotelReservation();
			
			
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
			this.tearDown("Roomshare details");
			}
		}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=6)
	public void cancelReservation(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("cancelReservation details ");
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			GSX_HotelReservation.validatePaymentInfo();
			GSX_HotelReservation.editHotelDetails();
			GSX_HotelReservation.validateCancelReservation();
			GSX_HotelReservation.cancelReservation();
			
			GSX_HotelReservation.validatePaymentInfo();
			this.tearDown("cancelReservation details");
			}
		}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=2)
	public void ChangeReservation(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("change reservation details");
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			GSX_HotelReservation.validatePaymentInfo();
			GSX_HotelReservation.editHotelDetails();
			GSX_HotelReservation.validateCancelReservation();
			GSX_HotelReservation.changeReservation();
			GSX_HotelReservation.validateEditHotelRoomate();
			
			
			GSX_HotelReservation.changeSelectDates(pojo);			
			GSX_HotelReservation.validatePaymentInfo();
			this.tearDown("change reservation details");
			}
		}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=5)
	public void PrimaryChangeReservationw_SecondaryCancel(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Primary Change the reservation when secondary reject");
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			GSX_HotelReservation.validatePaymentInfo();
			GSX_HotelReservation.editHotelDetails();
			//
			GSX_HotelReservation.validateCancelReservation();
			//Change reservation button

			GSX_HotelReservation.changeReservation();
			//Select dates
			System.out.println("###################"+pojo.getRoomSharingInfromation());
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
			
			
			
			
			this.tearDown("Primary Change the reservation when secondary reject");
			}
		}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void negative_Contactinfo(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Contact information Negative validation");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			
			
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.Mandatory_ContactInfo();
			this.tearDown("Contact information Negative validation");
		
		
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void negative_additionalquestions(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Mandatory fields additionalquestions validation");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);

			
			//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
			GSX_RegistrationPage.Mandatory_ContactInfo();			
			//GSX_RegistrationPage.verifyAdditionalQuestionsPage();
		//	GSX_RegistrationPage.enterKeyQuestions(pojo);
			this.tearDown("Additionalquestions Negative validation");
		
		
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void negative_Flightonsite(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("Negative_Flightonsite");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			
			//Contact information
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
						
			//Validate additionalquestions information
			
			GSX_RegistrationPage.validateContactInformation(pojo);
		    GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
		    GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.Mandatory_ContactInfo();

		   
			this.tearDown("Negative_Flightonsite");
		}
	}
	
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void acceptHotelRoomateRequest(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("acceptHotelRoomateRequest");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
			//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
			GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
				
			//Accept Hotel Roomate Request
			GSX_HotelReservation.validateHotelRoommateRequest();
			GSX_HotelReservation.acceptRoomate();		
			
			GSX_HotelReservation.validatePaymentInfo();
			
			this.tearDown("acceptHotelRoomateRequest");
	
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=4)
	public void makeReservation_AcceptHotelRoomateRequest(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("acceptHotelRoomateRequest");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//Validate the login success
			
				
			//Accept Hotel Roomate Request
			GSX_HotelReservation.validateHotelRoommateRequest();
			GSX_HotelReservation.acceptRoomate();		
			
			GSX_HotelReservation.validatePaymentInfo();
			
			this.tearDown("acceptHotelRoomateRequest");
	
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=3)
	public void rejectRoomateRequest(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("rejectRoomateRequest");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
			//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
			GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
				
			//Reject Hotel Roomate Request
			GSX_HotelReservation.validateHotelRoommateRequest();
			GSX_HotelReservation.rejectRoomate();		
			
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
			this.tearDown("rejectRoomateRequest");
	
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void MakeReservation_rejectRoomate(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("rejectRoomateRequest");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//Validate the login success
			
			//Reject Hotel Roomate Request
			GSX_HotelReservation.validateHotelRoommateRequest();
			GSX_HotelReservation.rejectRoomate();		
			
			//Hotel information
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
			
			
			this.tearDown("rejectRoomateRequest");
	
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void allHotelDatesareSoldOut(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("allHotelDatesareSoldOut");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			//GSX_RegistrationPage.validateRegistrationPage();
			//GSX_RegistrationPage.enterContactInformation(pojo);
			
			//Validate contact information
			//GSX_RegistrationPage.validateContactInformation(pojo);
			//GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			//GSX_RegistrationPage.validateKeyQuestionsInformation();
		   // GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			//Validate Registration confirmation page
			
			
			//Hotel information
			GSX_HotelReservation.makeHotelReservation();
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
		
			this.tearDown("allHotelDatesareSoldOut");
				
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=7)
	public void updateContactInformation(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("updateContactInformation");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_HotelReservation.validatePaymentInfo();
			
			//Click on Edit Contact information
			GSX_RegistrationPage.updateContactInformation();
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
		
			this.tearDown("updateContactInformation");
				
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=7)
	public void updateOnSiteInfo(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("updateOnSiteInfo");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_HotelReservation.validatePaymentInfo();
			GSX_RegistrationPage.updateOnSiteInfo();
			GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			
		
			this.tearDown("updateOnSiteInfo");
				
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class,priority=7)
	public void updatekeyQuestions(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("updatekeyQuestions");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_HotelReservation.validatePaymentInfo();
			GSX_RegistrationPage.updatekeyQuestions();
			GSX_RegistrationPage.validateContactInformation(pojo);
			GSX_RegistrationPage.enterKeyQuestions(pojo);		
			
			GSX_HotelReservation.validatePaymentInfo();
			
			this.tearDown("updatekeyQuestionsInformation");
				
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyInterestsAddedInMyInterests(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
		this.setUp("Verify Interests Added In My Interests");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.login(pojo);
		
		//Validate and Click View Agenda
		SessionCatalog.validateSessionsPage();
		SessionCatalog.clickAgenda();
		
		//Validate Session Catalog Home Page and select any Intrest
		SessionCatalog.validateSessionHomePage();
		SessionCatalog.selectInterest();
		
		//Click My Interests Link
		SessionCatalog.clickMyIntrests();
		SessionCatalog.validateMyIntrestsHomePage();
		
		//Verify whether Intrests are added successfully or not
		SessionCatalog.verifySelectedIntrests();
		SessionCatalog.ValidateSessionType();
		

		this.tearDown("Verify Interests Added In My Interests");
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifySessioncategory(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
		this.setUp("verify Session category");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.login(pojo);
		
		//Validate and Click View Agenda
		SessionCatalog.validateSessionsPage();
		SessionCatalog.clickAgenda();
		
		//Validate Session Catalog Home Page and select any Intrest
		SessionCatalog.validateSessionHomePage();
		SessionCatalog.selectInterest();		
		
		SessionCatalog.SessionCategory();		

		this.tearDown("verify Session category");
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifySessionTrack(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
		this.setUp("verify Session Track");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.login(pojo);
		
		//Validate and Click View Agenda
		SessionCatalog.validateSessionsPage();
		SessionCatalog.clickAgenda();
		
		//Validate Session Catalog Home Page and select any Interest
		SessionCatalog.validateSessionHomePage();
		SessionCatalog.selectInterest();
		
		
		//verifySessionTrack
		SessionCatalog.SessionCatalogTrack();		

		this.tearDown("verify Session Track");
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifySessionType(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
		this.setUp("verify Session Type");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.login(pojo);
		
		//Validate and Click View Agenda
		SessionCatalog.validateSessionsPage();
		SessionCatalog.clickAgenda();
		
		//Validate Session Catalog Home Page and select any Intrest
		SessionCatalog.validateSessionHomePage();
		SessionCatalog.selectInterest();
	
		SessionCatalog.ValidateSessionType();

		this.tearDown("verify Session Type");
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyRegistrationandsessionIntrest(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("VerifyRegistrationandsessionIntrest");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
		//	//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
			GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			//Validate Registration confirmation page
			
			//Hotel information
			//GSX_HotelReservation.makeHotelReservation();
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			//Validate and Click View Agenda
			SessionCatalog.validateSessionsPage();
			SessionCatalog.clickAgenda();
			
			//Validate Session Catalog Home Page and select any Intrest
			SessionCatalog.validateSessionHomePage();
			SessionCatalog.selectInterest();
			
			//Click My Interests Link
			SessionCatalog.clickMyIntrests();
			SessionCatalog.validateMyIntrestsHomePage();
			
			//Verify whether Intrests are added successfully or not
			SessionCatalog.verifySelectedIntrests();
			SessionCatalog.SessionCategory();
			//SessionCatalog.SessionCatalogTrack();
			SessionCatalog.ValidateSessionType();
			this.tearDown("VerifyRegistrationandsessionIntrest");
	
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyRegistrationandandTrack(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("VerifyRegistrationandTrack");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
		//	//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
			GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			//Validate Registration confirmation page
			
			//Hotel information
			//GSX_HotelReservation.makeHotelReservation();
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			//Validate and Click View Agenda
			SessionCatalog.validateSessionsPage();
			SessionCatalog.clickAgenda();
			
			//Validate Session Catalog Home Page and select any Intrest
			SessionCatalog.validateSessionHomePage();
			SessionCatalog.selectInterest();
			
			//Click My Interests Link
			SessionCatalog.clickMyIntrests();
			SessionCatalog.validateMyIntrestsHomePage();
			
			//Verify whether Intrests are added successfully or not
			SessionCatalog.verifySelectedIntrests();
			SessionCatalog.SessionCategory();
			//SessionCatalog.SessionCatalogTrack();
		//	SessionCatalog.ValidateSessionType();
			this.tearDown("VerifyRegistrationandTrack");
	
		}
	}
	@Test(dataProvider = "data-provider", dataProviderClass = Dataproviderclass.class)
	public void verifyRegistrationandSessionType(LinkedList<?> pojo1) throws Exception {
		for (int a = 0; a < pojo1.size(); a++) {
			DataPojoClass pojo = (DataPojoClass) pojo1.get(a);
			this.setUp("VerifyRegistrationandSessionType");
			
			//Validate login page
			LoginPage.validateLoginPage();
			LoginPage.login(pojo);
			//CommonUtil.getDimensions();
			//Validate the login success
			GSX_RegistrationPage.validateRegistrationPage();
			GSX_RegistrationPage.enterContactInformation(pojo);
			
		//	//Validate contact information
			GSX_RegistrationPage.validateContactInformation(pojo);
			GSX_RegistrationPage.enterKeyQuestions(pojo);
			
			//Validate key questions
			GSX_RegistrationPage.validateKeyQuestionsInformation();
			GSX_RegistrationPage.enterTravelAndOnsiteInfo(pojo);
			
			//Validate Registration confirmation page
			
			//Hotel information
			//GSX_HotelReservation.makeHotelReservation();
			if(pojo.getRoomSharingInfromation().equalsIgnoreCase("yes")){	
				//Room Information - Step1
				GSX_HotelReservation.enterRoomInfo(pojo);
				
				
			}
			GSX_HotelReservation.validateRoomShareInfo();
			GSX_HotelReservation.selectDates(pojo);
			//Select Hotel - Step3
			GSX_HotelReservation.validateCheckinCheckoutInfo();
			GSX_HotelReservation.selectaHotel(pojo);
			
			// Step4
			GSX_HotelReservation.validateSelectHotelInfo();
					
			//Enter Your payment Info - Step5
			GSX_HotelReservation.enterPaymentInfo(pojo);
			
			GSX_HotelReservation.validatePaymentInfo();
			//Validate and Click View Agenda
			SessionCatalog.validateSessionsPage();
			SessionCatalog.clickAgenda();
			
			//Validate Session Catalog Home Page and select any Intrest
			SessionCatalog.validateSessionHomePage();
			SessionCatalog.selectInterest();
			
			//Click My Interests Link
			SessionCatalog.clickMyIntrests();
			SessionCatalog.validateMyIntrestsHomePage();
			
			//Verify whether Intrests are added successfully or not
			SessionCatalog.verifySelectedIntrests();
			SessionCatalog.SessionCategory();
			//SessionCatalog.SessionCatalogTrack();
			SessionCatalog.ValidateSessionType();
			this.tearDown("VerifyRegistrationandSessionType");
	
		}
	}
	
}
