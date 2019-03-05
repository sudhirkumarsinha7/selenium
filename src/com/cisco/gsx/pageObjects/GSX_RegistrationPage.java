package com.cisco.gsx.pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.excelreader.DataPojoClass;
import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_RegistrationPage {
	private static WebElement webElement = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String locator = null;
	private static String field = null;
	private static String value = null;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	public static boolean elements;
	public static boolean result ;
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	public static void validateRegistrationPage() throws InterruptedException {
		CommonUtil.waitForPageload();
		 CommonUtil.explicitlyWait(5);
		 System.out.println("Contact Information");
		 actualMsg = "Contact Information";
			expectedMsg = CommonUtil
					.getText(elementProperties
							.getProperty("cisco.gsx.registration.contactInformation"));

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			 System.out.println("Contact Information");
			actualMsg = actualMsg+" screen is displays successfully";
			expectedMsg = actualMsg+" Screen should be displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User login is not succeed";
			expectedMsg = "User should be login to the GSX successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	public static void enterContactInformation(DataPojoClass pojo) throws InterruptedException {
		
		
		CommonUtil.waitForPageload();
		// CommonUtil.takeScreenShot();
		
		 verifyContactinformationPage(pojo);
    CommonUtil
				.enterText(
						elementProperties
								.getProperty("cisco.gsx.registration.contactinfo.preferedfirstname"),
						pojo.getFirstName());
		if (stateField(pojo)) {
			System.out.println("State field");
			
		}
		
	
		//Vijaya : Country field changed as dropdown and province code
		System.out.println("County "+pojo.getCounty());
    CommonUtil
	.selectValueFromDropDownBox(
			elementProperties
					.getProperty("cisco.gsx.registration.contactinfo.county"),
					pojo.getCounty());
    
    /*if(pojo.getCounty().equals("China"))
    	CommonUtil.enterText(elementProperties
				.getProperty("cisco.gsx.registration.contactinfo.province"),
				commonProperties.getProperty("cisco.province.china"));
    else  if(pojo.getCounty().equals("United Kingdom"))
    	
    	System.out.println("United Kingdom");
    	//CommonUtil.enterText(elementProperties
				//.getProperty("cisco.gsx.registration.contactinfo.province"),
				//commonProperties.getProperty("cisco.province.UnitedKingDom"));
	*/
	System.out.println("getCity "+pojo.getCity());

    CommonUtil.enterText(elementProperties
				.getProperty("cisco.gsx.registration.contactinfo.city"), pojo
				.getCity());
		CommonUtil
				.enterText(
						elementProperties
								.getProperty("cisco.gsx.registration.contactinfo.emergencycontactname"),
						pojo.getContactName());
		CommonUtil
				.enterText(
						elementProperties
								.getProperty("cisco.gsx.registration.contactinfo.emergencycontactphonenumber"),
						pojo.getPhoneNumber());
		String scenario = pojo.getRegCode();
		if ((scenario.equalsIgnoreCase(commonProperties
				.getProperty("cisco.regcode.eventstaff")))
				|| (scenario.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.supportstaff")))
				|| (scenario.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.hubstaff")))) {
			System.out.println("Reg Code Loop");
			// do nthg
		} else {
			CommonUtil
					.enterText(
							elementProperties
									.getProperty("cisco.gsx.registration.contactinfo.emailaddress"),
							pojo.getEmailAddress());
		}
	//CommonUtil.takeScreenShot();
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.contactinfo.continue"));
		

	}

	public static void validateContactInformation(DataPojoClass pojo) {
		CommonUtil.waitForPageload();
		
		String attendee = pojo.getRegCode();
		if ((attendee.equalsIgnoreCase(commonProperties
				.getProperty("cisco.regcode.eventstaff")))
				||(attendee.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.supportstaff")))
				|| (attendee.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.hubstaff")))) {
		actualMsg = "Additional Questions";
		}else{
			actualMsg = "Areas of Interest";
		}
	
		expectedMsg = CommonUtil
				.getText(elementProperties
						.getProperty("cisco.gsx.registration.keyquestions.keyquestionstext"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Additional Questions screen displays successfully";
			expectedMsg = "Additional Questions screen should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to enter contact information";
			expectedMsg = "User should enter contact information successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();

	}

	public static boolean stateField(DataPojoClass pojo) {
		System.out.println("States field is present"+pojo.getState());
		System.out.println("State field is present");
		String expectedCountry = pojo.getTravelingFrom();
		System.out.println("expectedCountry"+expectedCountry);
		if(expectedCountry.equalsIgnoreCase("Australia")){
			actualMsg = "State/Territory";
			expectedMsg = CommonUtil.getText(elementProperties
					.getProperty("cisco.gsx.registration.contactinfo.state.text1"));
			System.out.println("*************"+expectedMsg);
			System.out.println("Australia State field is present");
		}else{

			actualMsg = "State/Territory";
			System.out.println("*************"+actualMsg);
			expectedMsg = CommonUtil.getText(elementProperties
					.getProperty("cisco.gsx.registration.contactinfo.state.text"));
			System.out.println("*************"+expectedMsg);
			System.out.println("States field is present"+expectedMsg);
		}		
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {

			System.out.println("if loop State field is present"+pojo.getState());
			if(expectedCountry.equalsIgnoreCase("Australia")){
				CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.registration.contactinfo.state.dropdown1"),
						pojo.getState());
			}else{				

				System.out.println("States field is present"+pojo.getState());

				CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.registration.contactinfo.state.dropdown"),
								pojo.getState());
			}
			return true;
		} else
			return false;
	}
	public static void updateContactInformation() throws InterruptedException {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.contactInfromation"));
	}
	public static void updatekeyQuestions() {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.additionalquestions"));
	}
	public static void updateOnSiteInfo() {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.editOnsiteInfo"));
	}
	public static void enterKeyQuestions(DataPojoClass pojo) throws InterruptedException {
		CommonUtil.waitForPageload();
		//verifyKeyQuestionsPage();
		String scenario1 = pojo.getRegCode();
		if ((scenario1.equalsIgnoreCase(commonProperties
				.getProperty("cisco.regcode.eventstaff")))
				||(scenario1.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.supportstaff")))
				|| (scenario1.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.hubstaff")))) {
			System.out.println("1");
			if(scenario1.equalsIgnoreCase(commonProperties.getProperty("cisco.regcode.hubstaff"))){
				CommonUtil
				.selectValueFromDropDownBox(elementProperties.getProperty("Cisco.gsx.hubstaff.jobTitle"),pojo.getJobTitle());
				
					hubStaffuser(pojo);
					
				
			}
			
			System.out.println("2");
			CommonUtil
			.selectValueFromDropDownBox(
					elementProperties
							.getProperty("cisco.gsx.registration.keyquestions.tshirtsize"),
					pojo.getTshirtSize());
			System.out.println("3");
			if ((scenario1.equalsIgnoreCase(commonProperties
					.getProperty("cisco.regcode.eventstaff")))
					||(scenario1.equalsIgnoreCase(commonProperties
							.getProperty("cisco.regcode.supportstaff")))) {
				tshirtParagraphValidation();
			}
			
			
			CommonUtil.click(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.continue"));
		} else {
			System.out.println("4");
			CommonUtil.selectValueFromDropDownBox(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.role"),
					pojo.getRole());
			String scenario = pojo.getRegCode();
			String jobRole = pojo.getRole();
			if(jobRole.equalsIgnoreCase(commonProperties.getProperty("cisco.gsx.role.director"))||
					jobRole.equalsIgnoreCase(commonProperties.getProperty("cisco.gsx.role.Manager"))||
					jobRole.equalsIgnoreCase(commonProperties.getProperty("cisco.gsx.role.vp"))||
					jobRole.equalsIgnoreCase(commonProperties.getProperty("cisco.gsx.role.other"))){
					if (jobRole(pojo)) {
						System.out.println("Role Type : "+jobRole);
						
					}
			}	
			System.out.println("Role Type : "+commonProperties.getProperty("cisco.gsx.primary"));
			
			
	
			
			CommonUtil
			.selectValueFromDropDownBox(
					elementProperties
							.getProperty("cisco.gsx.registration.Additional.primary"),
							commonProperties.getProperty("cisco.gsx.primary"));
			CommonUtil
			.selectValueFromDropDownBox(
					elementProperties
							.getProperty("cisco.gsx.registration.Additional.alternative"),
							commonProperties.getProperty("cisco.gsx.Secondary"));
			
			System.out.println("**************CSAP BloCk-------------***************"+pojo.getMemberOfCSAP());
			String memberOfCSAP = pojo.getMemberOfCSAP();
			if(memberOfCSAP.equalsIgnoreCase(commonProperties
					.getProperty("cisco.csap.currentlyincsap"))){
				
				System.out.println("**************CSAP BloCk***************");
				CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.keyquestions.AreyouamemberofCSAP.currentlyinCSAP"));
				CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.keyquestions.whichyearoftheprogramareyoucurrentlyin.First"));				
				
			}else{
				CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.keyquestions.AreyouamemberofCSAP.Notamember"));
			
			}
			//Select other areas of interest at GSX: CSAP
			CommonUtil
			.isChecked(elementProperties
							.getProperty("cisco.gsx.registration.keyquestions.SelectotherareasofinterestatGSX.CSAP"));
			//Health/Wellness Check box
			CommonUtil
			.isChecked(elementProperties
							.getProperty("cisco.gsx.registration.keyquestions.SelectotherareasofinterestatGSX.HealthWellness"));
			CommonUtil
			.isChecked(elementProperties
							.getProperty("cisco.gsx.registration.keyquestions.SelectotherareasofinterestatGSX.HealthyEating"));
		
			CommonUtil
			.click(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.HowmanyCiscoGlobalSalesMeetings(GSM).None"));		

			
			//CommonUtil
			//.click(elementProperties
			//		.getProperty("cisco.gsx.registration.keyquestions.HowmanyyearshaveyoubeenatCisco.Fewerthan6months"));
			
			
			CommonUtil
			.click(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.Twitter.Donthaveone"));
		//	CommonUtil
			//.click(elementProperties
			//		.getProperty("cisco.gsx.registration.keyquestions.Facebook.Donthaveone"));
			CommonUtil
			.click(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.LinkedIn.Donthaveone"));
			CommonUtil
			.click(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.Instagram.Donthaveone"));
			System.out.println("Instagram");

			CommonUtil
			.isChecked(elementProperties.getProperty("cisco.joinWebExSpace.Yes"));
		System.out.println("tshirtSize");
		/*	CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.keyquestions.tshirtsize"),
							pojo.getTshirtSize());*/
		
			
			
			//verifyAdditionalQuestionsPage();
			CommonUtil.click(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.continue"));
			CommonUtil.explicitlyWait(1);
		
		}
		CommonUtil.waitForPageload();
	}
	
	public static void hubStaffuser(DataPojoClass pojo){
		//System.out.println("Hub Competitive Win Room Validation");
		if((pojo.getJobTitle()).equalsIgnoreCase(commonProperties.getProperty("cisco.jobtitle.other")))
		{
			
			CommonUtil.enterText(
					elementProperties.getProperty("Cisco.gsx.hubstaff.pleasespecify"),
							commonProperties.getProperty("cisco.jobtitle.other"));
		}
		CommonUtil.isChecked(elementProperties
				.getProperty("cisco.Additional.Hubcompetitive.Yes"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(1);
		//validateHotelRoommateRequestParagraph();
		//Business Entity
		CommonUtil.isChecked(elementProperties
				.getProperty("cisco.Additional.BusinessEntity.Analytics"));
		CommonUtil.isChecked(elementProperties
				.getProperty("cisco.Additional.BusinessEntity.CiscoCapital"));
		
		//Cisco Competitor
		System.out.println("Cisco Competitor");
		CommonUtil.isChecked(elementProperties
				.getProperty("cisco.Additional.CiscoCompetitor.Citrix"));
		CommonUtil.isChecked(elementProperties
				.getProperty("cisco.Additional.CiscoCompetitor.Dell"));
		
		//Regional Segment		
		System.out.println("Regional Segment");
		CommonUtil.isChecked(elementProperties
				.getProperty("cisco.Additional.RegionalSegment.Americas"));
		//SectorAlignClosely
		System.out.println("SectorAlignClosely");

		CommonUtil.isChecked(elementProperties
				.getProperty("cisco.Additional.SectorAlignClosely.EnterPrice"));
		//Industry
		System.out.println("Industry");
		CommonUtil.isChecked(elementProperties
				.getProperty("cisco.Additional.Industry.Cities"));

	}
	public static void tshirtParagraphValidation(){
		CommonUtil.waitForPageload();
		
		actualMsg = commonProperties.getProperty("cisco.tshirt.Paragraph");
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.additionalquestions.tshirtParagraph"));
		System.out.println("actualMsg"+actualMsg);
		System.out.println("expectedmessage"+expectedMsg);
		
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = expectedMsg+"message displays successfully";
			expectedMsg = expectedMsg+" message should display ";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = expectedMsg+" message displays successfully";
			expectedMsg = expectedMsg+" message should display ";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	public static void validateHotelRoommateRequestParagraph() {
		CommonUtil.waitForPageload();
		
		
		actualMsg = commonProperties.getProperty("cisco.winroom.text");
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.Additional.winRoom.Paragraph"));
		System.out.println("actualMsg"+actualMsg);
		System.out.println("expectedmessage"+expectedMsg);
		
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = expectedMsg+"message displays successfully";
			expectedMsg = expectedMsg+" message should display ";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = expectedMsg+" message displays successfully";
			expectedMsg = expectedMsg+" message should display ";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	
	public static boolean jobRole(DataPojoClass pojo) {
		String jobRole = pojo.getRole();
		
			actualMsg = "Which learning track is most relevant to your job role?";
			expectedMsg = CommonUtil.getText(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.Whichsessiontrackismostrelevanttoyourjobrole.text"));
			System.out.println("Which session track is most relevant to your job role dropdown field is presented");
			
		
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			
			System.out.println("Session Track field is present");
			if(jobRole.equalsIgnoreCase(commonProperties.getProperty("cisco.gsx.role.director"))||
					jobRole.equalsIgnoreCase(commonProperties.getProperty("cisco.gsx.role.Manager"))||
					jobRole.equalsIgnoreCase(commonProperties.getProperty("cisco.gsx.role.vp"))||
					jobRole.equalsIgnoreCase(commonProperties.getProperty("cisco.gsx.role.other"))){
				System.out.println("1");
				CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.registration.keyquestions.Whichsessiontrackismostrelevanttoyourjobrole"),
								commonProperties.getProperty("cisco.gsx.sessiontrack"));
			}
			return true;
		} else
			return false;
	}

	public static void validateKeyQuestionsInformation() {
		CommonUtil.waitForPageload();
			actualMsg = "Flight and Onsite Information";
		
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.travelonsiteinfo.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User entered key questions screen successfully";
			expectedMsg = "User should enter key questions screen successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to enter key questions information";
			expectedMsg = "User should enter key questions successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	public static void enterTravelAndOnsiteInfo(DataPojoClass pojo) throws InterruptedException {
		CommonUtil.waitForPageload();
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.travelonsiteinfo.dietaryrequirements.Vegan"));
	
		System.out.println("1"+pojo.getTravelArrangements());
		CommonUtil
				.selectValueFromDropDownBox(elementProperties
						.getProperty("cisco.gsx.registration.travelonsiteinfo.travelarrangements.yes"),
						pojo.getTravelArrangements());
		//System.out.println("2");
		//Vijaya : Need to add "Howdoyou plan to arrive in LasVegas" and What type of Travel is needed radio buttons
		/*String scenario1 = pojo.getRegCode();
		if ((scenario1.equalsIgnoreCase(commonProperties
				.getProperty("cisco.regcode.eventstaff")))
				|| (scenario1.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.supportstaff")))
				|| (scenario1.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.hubstaff")))) {
			
			CommonUtil.click(elementProperties		
					.getProperty("cisco.gsx.registration.travelonsiteinfo.Travelneeded.FlightAndHotel"));*/
		
			CommonUtil.click(elementProperties		
				.getProperty("cisco.gsx.registration.travelonsiteinfo.HowdoyouplantoarriveinLasVegas.Airtravel"));
		
		//validateFlightAndOnsigtText1();
		//Vijaya
		CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.registration.travelonsiteinfo.countryTravelingFrom"),
						pojo.getTravelingFrom());
		String scenario = pojo.getCountries();
		if (scenario.equalsIgnoreCase(commonProperties
				.getProperty("cisco.scenario.NonCTN"))) {
			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.travelonsiteinfo.visainvitationletter.yes"));
			verifyLinkForInvitationLetter(pojo);
		} else {
			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.travelonsiteinfo.visainvitationletter.no"));
		}
		CommonUtil
		.isChecked(elementProperties
						.getProperty("cisco.gsx.registration.travelonsiteinfo.dietaryrequirements.Vegan"));
		//CommonUtil.explicitlyWait(1);
		String scenario1 = pojo.getRegCode();
		System.out.println("Hot lunch"+scenario1);
		if ((scenario1.equalsIgnoreCase(commonProperties
				.getProperty("cisco.regcode.attendee")))
				
				|| (scenario1.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.executive")))) {
			CommonUtil.wait(elementProperties.getProperty("ciscolunch"));
		
			CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("ciscolunch"),pojo.getLunchPreferenceatGSX());
		}
		
		CommonUtil
		.isChecked(elementProperties
						.getProperty("cisco.gsx.registration.travelonsiteinfo.additionalonsiteassistance.ADHHotelaccoommodation"));
		
		
		//validateFlightAndOnsigtText2();
		Thread.sleep(1000);

		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.travelonsiteinfo.continue"));
		
		CommonUtil.explicitlyWait(1);
		CommonUtil.waitForPageload();
	}

	

	public static void confirmedRegistrationPage() {
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.confirmation.yes"));
		CommonUtil.waitForPageload();		
	}
	
	
	public static void verifyLinkForInvitationLetter(DataPojoClass pojo) {
		CommonUtil.waitForPageload();
		actualMsg = "Click here to request your invitation letter and review any additional VISA requirements you may have.  Employees are responsible for ensuring that their passport, entry/exit visas and travel documents are in order and are in alignment with current security requirements.";
	
			expectedMsg = CommonUtil
					.getText(elementProperties
							.getProperty("cisco.gsx.registration.travelonsiteinfo.visainvitationletter.linkText"));
		
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Displayed link for invitation letter");
			actualMsg = "Link displayed to get the invitation letter";
			expectedMsg = "Link should display to get the invitation letter";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("Link is not displayed for invitation letter");
			actualMsg = "Link is not displayed to get the invitation letter";
			expectedMsg = "Link should display to get the invitation letter";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}

	}
	//Vijaya
	public static void verifyAdditionalQuestionsPage() {
		//CommonUtil.waitForPageload();
		
		actualMsg = 
			"To help facilitate networking at GSX please provide your social media usernames."+"\nNote: Your social media usernames may be posted in CiscoGSX.com and GSX Mobile, unless you do not have one or prefer not to provide.";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.additionalquestions.Text"));
		System.out.println(""+expectedMsg);
		System.out.println(""+actualMsg);
		
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Social media text is displays successfully";
			expectedMsg = "Social media text should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Social media text is not displayed ";
			expectedMsg = "Social media text should display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}
	public static void verifyContactinformationPage(DataPojoClass pojo) {
			
	actualMsg = commonProperties.getProperty("Cisco.ContactInformation.other");
	expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.contactinformation.Text"));
		System.out.println(""+actualMsg);
		System.out.println(""+expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Welcome GSX FY19 registration message displays successfully";
			expectedMsg = "Welcome GSX FY19 registration message should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Welcome GSX FY19 registration message not displayed";
			expectedMsg = "Welcome GSX FY19 registration message should display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}
	public static void verifyKeyQuestionsPage() {
		
		actualMsg = commonProperties.getProperty("Cisco.KeyQuestions.text");
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.additionalquestions.Text"));
		System.out.println(""+actualMsg);
		System.out.println(""+expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = actualMsg +" message displays successfully";
			expectedMsg = actualMsg+" message should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = actualMsg+" message is not displayed";
			expectedMsg = actualMsg +" message should display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}


public static void mandataoryFieldCountValidation(String LowerMessage,String uppermessage){
	  CommonUtil.waitForPageload();
	  CommonUtil.
	   	click(elementProperties.getProperty("cisco.gsx.registration.contactinfo.continue"));
	  CommonUtil.explicitlyWait(2);
	  List<WebElement>upperlist=CommonUtil.findElements(elementProperties.getProperty(uppermessage));
	  System.out.println("Error Message count : "+upperlist.size());
	  List<WebElement> lowerList=CommonUtil.findElements(elementProperties.getProperty(LowerMessage));
	  System.out.println("Number of error fields count : "+lowerList.size());
	  
	  if(upperlist.size()==lowerList.size())	  {
		  
		   System.out.println("Expected error messages are displayed sussessfully");
		   actualMsg = "Expected error messages  are displayed sussessfully";
		   expectedMsg = "Expected error messages should display";
		   status = "PASS";
		   CommonUtil.logMessage(expectedMsg, actualMsg, status);
	  } else
	  {
		   System.out.println("Error messages are not displayed ");
		   actualMsg = "Error messages are not displayed";
		   expectedMsg = "Expected error messages should display";
		   status = "FAIL";
		   CommonUtil.logMessage(expectedMsg, actualMsg, status);
	  }
	     
}
	public static void Mandatory_ContactInfo(){
		mandataoryField_contact("cisco.gsx.registration.manadataryfilds.lowerlist","cisco.gsx.registration.manadataryfildserorrs.upperlist");
		//mandataoryFieldCountValidation("ccisco.gsx.additionalquestions.manadataryfilds.lowerlist","cisco.gsx.AdditionalQuestions.error");
	
	}
	public static void validateFlightAndOnsigtText1() {
		//CommonUtil.waitForPageload();
		actualMsg = "Due to Cisco safety and welfare policies all air travel arrangements must be booked through the Cisco Global Travel program.  Attendees must book their hotel through GSX. No hotels or flights booked outside of these processes will be permitted.";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.onsitetext1"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Cisco global travel program text is displayed successfully";
			expectedMsg = "Cisco global travel program text should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Cisco global travel program text is not displayed";
			expectedMsg = "Cisco global travel program text should display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
	}
	public static void validateFlightAndOnsigtText2() {
		//CommonUtil.waitForPageload();
		actualMsg = "*Note: By submitting your registration, you are acknowledging that GSX can share your session, and celebration information with other attendees. For more information, please email Contact Center.";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.onsitetext3"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Contact center link is displayed successfully";
			expectedMsg = "Contact center link should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Contact center link is not displayed";
			expectedMsg = "Contact center link should display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
	}
	public static void mandataoryField_contact(String LowerMessage,String uppermessage){
		  
		  CommonUtil.
		    click(elementProperties.getProperty("cisco.gsx.registration.contactinfo.continue"));
		  CommonUtil.waitForPageload();
		  CommonUtil.explicitlyWait(2);
		  List<WebElement>upperlist=CommonUtil.findElements(elementProperties.getProperty(uppermessage));
		  System.out.println(upperlist.size());
		  
		  List<String> upperlistarray = new ArrayList<>();
		  for(int i=0; i<upperlist.size(); i++) {
			  upperlistarray.add(upperlist.get(i).getText());
		  } 
		  	System.out.println(upperlist.get(0));
		  
		  for(String upperlistindividule:upperlistarray){
			  System.out.println(upperlistindividule);
		  }
		  List<WebElement>lowerlist=CommonUtil.findElements(elementProperties.getProperty(LowerMessage));
		  System.out.println(lowerlist.size());
		  
		  List<String> lowerlistarray = new ArrayList<>();
		  	for(int i=0; i<lowerlist.size(); i++) {
		   lowerlistarray.add(lowerlist.get(i).getText());
		  } 
		  
		  	for(String lowerlistindividule:upperlistarray){
		   System.out.println(lowerlistindividule);
		
		  }
		 
		  for(int i=0; i<lowerlist.size(); i++)
		  {
			  if(upperlistarray.get(i).contains(lowerlistarray.get(i)))
	
			  {
				  
				  result =true;
				  
			  }
			 else
			 {
				  System.out.println("UpperList :"+upperlistarray.get(i)+"LowerList :"+lowerlistarray.get(i));
				 result =false;
				  
		     }
		  }
		  if(result){
			  System.out.println("Expected error messages are displayed sussessfully");
			   actualMsg = "Expected error messages  are displayed sussessfully";
			   expectedMsg = "Expected error messages should display";
			   status = "PASS";
			   CommonUtil.logMessage(expectedMsg, actualMsg, status);
		  }else{
			   actualMsg = "Error messages are not displayed";
			   expectedMsg = "Expected error messages should display";
			   status = "FAIL";
			   CommonUtil.logMessage(expectedMsg, actualMsg, status);
		  }
		  
	}
}

