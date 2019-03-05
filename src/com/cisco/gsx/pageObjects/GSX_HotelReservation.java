package com.cisco.gsx.pageObjects;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.excelreader.DataPojoClass;
import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_HotelReservation {
	private static WebElement webElement = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String locator = null;
	private static String field = null;
	private static String value = null;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String checkIn =null;
	private static String checkOut =null;

	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	public static void validateRegistration() {
		//makeHotelReservation();
		CommonUtil.waitForPageload();
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.roominformation.text"));
		
		actualMsg = "Room Share Information";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.roominformation.text"));
		System.out.println("***"+expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User registered to GSX successfully";
			expectedMsg = "User should register to GSX successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to register to GSX";
			expectedMsg = "User should register to GSX successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	public static void makeHotelReservation(){
		CommonUtil.waitForPageload();
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.MakeHotelreservation"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.registration.MakeHotelreservation"));
		CommonUtil.waitForPageload();
	
	}
	public static void validateCancelReservation() {
		CommonUtil.waitForPageload();
		
		
		actualMsg = "Hotel Reservation Details";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.EditHotel.title"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = expectedMsg+" screen displays successfully";
			expectedMsg = expectedMsg+" screen should display ";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = expectedMsg+" screen displays successfully";
			expectedMsg = expectedMsg+" screen should display ";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	public static void editHotelDetails(){
		CommonUtil.waitForPageload();
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.EditHotel"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.registration.EditHotel"));
		CommonUtil.waitForPageload();
	
	}
	public static void cancelReservation() throws InterruptedException{
		CommonUtil.waitForPageload();
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.cancelreservation"));
		CommonUtil.takeScreenShot();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.registration.cancelreservation"));
		CommonUtil.waitForPageload();
		CommonUtil.takeScreenShot();
		CommonUtil.wait(elementProperties.getProperty("cisco.gsx.registration.cancelreservation.ok"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.registration.cancelreservation.ok"));
		Thread.sleep(1000);
		CommonUtil.waitForPageload();

	
	}
	public static void validateEditHotelRoomate() {
		//makeHotelReservation();
		CommonUtil.waitForPageload();
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.EditRoommate"));
		
		actualMsg = "Edit Hotel Booking";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.EditRoommate"));
		System.out.println("***"+expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = actualMsg+" screen should be displayed";
			expectedMsg = expectedMsg+" screen displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Not displayed Edit Roommate Hotel Booking ";
			expectedMsg = expectedMsg+" screen displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	public static void changeReservation() throws InterruptedException{
		CommonUtil.waitForPageload();
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.changereservation"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.registration.changereservation"));
		CommonUtil.waitForPageload();
		CommonUtil.takeScreenShot();
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.cancelreservation.ok"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.registration.cancelreservation.ok"));
		Thread.sleep(1000);
		CommonUtil.waitForPageload();
		

	}
public static void changeSelectDates(DataPojoClass pojo) throws InterruptedException {
	
		
	//	checkoutdate = pojo.getCheckin();
		//System.out.println("Select Dates :" +checkoutdate);

		CommonUtil
		.selectValueFromDropDownBox(
				elementProperties
						.getProperty("cisco.gsx.registration.EditRoommate.datecheckin"),
						pojo.getCheckin());
		Thread.sleep(100);
		System.out.println("Select Dates :" +pojo.getCheckout());
		
		CommonUtil.selectValueFromDropDownBox(elementProperties
				.getProperty("cisco.gsx.registration.EditRoommate.datecheckout"),
				pojo.getCheckout());
		if((pojo.getRoomSharingInfromation().equalsIgnoreCase("no"))||
			    (pojo.getRoomShareInfo().equalsIgnoreCase(
			    commonProperties
			      .getProperty("cisco.gsx.roominfo.iwantmyownroom")))){ 
		
			   CommonUtil.click(elementProperties  
			     .getProperty("Cisco.gsx.MobileHotelCheckin"));
		}
		CommonUtil
		.click(elementProperties
				.getProperty("cisco.gsx.registration.EditRoommate.Next"));
	
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		actualMsg = "No hotels/room types are available for the selected dates. Please reselect your dates.";
		expectedMsg = CommonUtil.getText(elementProperties
			.getProperty("cisco.gsx.registration.popup.text"));
		System.out.println("MSG :       "+expectedMsg);

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Hotel Dates are not available");
			System.out.println("No hotels/room types are available for the selected dates");
			CommonUtil.explicitlyWait(2);
			CommonUtil
			.click(elementProperties
					.getProperty("cisco.gsx.registration.popup.cancel"));
			CommonUtil.explicitlyWait(2);
		}else{
			System.out.println("Hotel Dates are available");
			CommonUtil.explicitlyWait(1);

			CommonUtil
			.click(elementProperties
				.getProperty("cisco.gsx.registration.continue"));
      		CommonUtil.explicitlyWait(1);
		}
	}

	public static void enterRoomInfo(DataPojoClass pojo) throws InterruptedException {
		System.out.println("***************Roomshare************************");
		
		CommonUtil.waitForPageload();
		
		validateRegistration();		
		verifyRoomShareInfoPage();
		//verifyRoomShareInfoMsg();
		
		if (pojo.getRoomShareInfo()
				.equalsIgnoreCase(
						commonProperties
								.getProperty("cisco.gsx.roominfo.autoassignmearoommate"))) {
			System.out
					.println("********Auto Assign Me a Roommate*************");
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.roomshareinfo"),
							pojo.getRoomShareInfo());
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.gender"),
							pojo.getHotelGender());
					
		
		} else if (pojo.getRoomShareInfo().equalsIgnoreCase(
				commonProperties
						.getProperty("cisco.gsx.roominfo.iwantmyownroom"))) {
			System.out.println("********I Want My Own Room*************");
			CommonUtil.selectValueFromDropDownBox(elementProperties
					.getProperty("cisco.gsx.registration.roominformation.roomshareinfo"), pojo
					.getRoomShareInfo());
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.gender"),
							pojo.getHotelGender());
			Thread.sleep(4000);

			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.roominformation.singleroomrequest.payingrateonown"));
			Thread.sleep(4000);
			CommonUtil
			.isChecked(elementProperties
							.getProperty("cisco.gsx.registration.SingleRoomRequest.agree"));
			Thread.sleep(4000);
		} else {
			System.out
					.println("********I Will Choose My Own Roommate*************");
			// System.out.println(pojo.getRoomShareInfo());
			// System.out.println(commonProperties.getProperty("cisco.gsx.roominfo.autoassignmearoommate"));
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.roomshareinfo"),
							pojo.getRoomShareInfo());
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.gender"),
							pojo.getHotelGender());

			//CommonUtil
			//.click(elementProperties
			//		.getProperty("cisco.gsx.registration.roominformation.acknowledgemaybereassigned.yes"));
			
			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.roominformation.selectarommate.click"));
			CommonUtil
					.enterText(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.selectarommate.text"),
							pojo.getSearchOrSelectRoommate());
             Thread.sleep(1000);
			CommonUtil
			.clickEnter(
					elementProperties
							.getProperty("cisco.gsx.registration.roominformation.selectarommate.text"),
					"");
		}
		CommonUtil.takeScreenShot();
		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.roominformation.continue"));
		CommonUtil.waitForPageload();

	}

	public static void validateRoomShareInfo() throws InterruptedException {
		CommonUtil.waitForPageload();
	    //makeHotelReservation();
		CommonUtil.explicitlyWait(5);
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.selectyourdates.text"));
	
		
		System.out.println("Select Date page");
		actualMsg = "Select Your Dates";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.selectyourdates.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User provided room share info and selected rommate successfully";
			expectedMsg = "User should able to select room share info and select roomate accordingly";
			status = "PASS";
			System.out.println("PASS");
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to provided room share info and selected rommate";
			expectedMsg = "User should able to select room share info and select roomate accordingly";
			status = "FAIL";
			System.out.println("FAIL");
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
		
		//Validating the HotelNight Text in Select your Dates screen
		validateSlectdatetextMsg();
	}

	public static void selectDates(DataPojoClass pojo) throws InterruptedException {
	
		
		 
		  checkIn = pojo.getCheckin();
		  System.out.println("Select Dates :" +checkIn);
		  checkOut = pojo.getCheckout();
		  System.out.println("Select Dates :" +checkOut);
		  Thread.sleep(100);
		  CommonUtil.selectValueFromDropDownBox(elementProperties
		    .getProperty("cisco.gsx.registration.selectyourdates.checkin"),
		    checkIn);
		  Thread.sleep(100);

		CommonUtil
		.selectValueFromDropDownBox(
				elementProperties
						.getProperty("cisco.gsx.registration.selectyourdates.checkout"),
				pojo.getCheckout());
		Thread.sleep(100);
		if((pojo.getRoomSharingInfromation().equalsIgnoreCase("no"))||
	    (pojo.getRoomShareInfo().equalsIgnoreCase(
	    commonProperties
	      .getProperty("cisco.gsx.roominfo.iwantmyownroom")))){ 
		
			CommonUtil.click(elementProperties		
					.getProperty("Cisco.gsx.MobileHotelCheckin"));
		}
		
		CommonUtil
		.click(elementProperties
				.getProperty("cisco.gsx.registration.Next"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		actualMsg = "No hotels/room types are available for the selected dates. Please reselect your dates.";
		expectedMsg = CommonUtil.getText(elementProperties
			.getProperty("cisco.gsx.registration.popup.text"));
		System.out.println("MSG :       "+expectedMsg);

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Hotel Dates are not available");
			System.out.println("No hotels/room types are available for the selected dates");
			CommonUtil.explicitlyWait(2);
			CommonUtil
			.click(elementProperties
					.getProperty("cisco.gsx.registration.popup.cancel"));
			CommonUtil.explicitlyWait(2);
		}else{
			System.out.println("Hotel Dates are available");
			CommonUtil.explicitlyWait(1);

			CommonUtil
			.click(elementProperties
				.getProperty("cisco.gsx.registration.continue"));
      		CommonUtil.explicitlyWait(1);
		}
	}

	public static void validateCheckinCheckoutInfo() throws InterruptedException  {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(1);
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.text"));
		
		
		actualMsg = "Hotel Selection";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.text"));
		System.out.println("*************exp"+expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User selected check-in and check-out dates successfully";
			expectedMsg = "User should able to select check-in and check-out dates successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to select check-in and check-out dates";
			expectedMsg = "User should able to select check-in and check-out dates successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		//validateSelectHotelReservationText();
		CommonUtil.waitForPageload();	
	}	

	public static void selectaHotel(DataPojoClass pojo) throws InterruptedException {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(1);
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.select"));
		
		
		/*CommonUtil.selectValueFromDropDownBox(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.filterby"),
				pojo.getFilterBy());*/
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.select"));
		CommonUtil.waitForPageload();
	}
	
	public static void validateSelectHotelInfo() throws InterruptedException{
		CommonUtil.waitForPageload();
		Thread.sleep(1000);
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.bookhotel.text"));
		
		
		//validateconfomedetailstext();
		actualMsg = "Hotel Confirmation";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.bookhotel.text"));
		System.out.println(expectedMsg);

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User selected a hotel successfully";
			expectedMsg = "User should able to select a hotel successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to select a hotel";
			expectedMsg = "User should able to select a hotel successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		//CommonUtil.waitForPageload();
		//validateconfomedetailstext();

	}
	
	public static void bookaHotel(DataPojoClass pojo) {
		CommonUtil.waitForPageload();	
		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.selecthotel.bookhotel.booknow"));
		CommonUtil.waitForPageload();
	}

	public static void validateHotelBookingInfo() throws InterruptedException {
		CommonUtil.waitForPageload();
	Thread.sleep(2000);
		
		actualMsg = "My Account Profile";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.Paymentinfo.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User selected a hotel successfully";
			expectedMsg = "User should able to select a hotel successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to select a hotel";
			expectedMsg = "User should able to select a hotel successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}

	public static void enterPaymentInfo(DataPojoClass pojo) {
		CommonUtil.waitForPageload();
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.Paymentinfo.processhotelreservation"));
		
		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.Paymentinfo.processhotelreservation"));
		CommonUtil.waitForPageload();
	}
	
	public static void validatePaymentInfo() {
		CommonUtil.waitForPageload();
		CommonUtil.wait(elementProperties
				.getProperty("cisco.gsx.registration.Paymentinfo.text"));
		
		actualMsg = "My Account Profile";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.Paymentinfo.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = expectedMsg+"message displays successfully";
			expectedMsg = expectedMsg+" message should display ";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = expectedMsg+"message displays successfully";
			expectedMsg = expectedMsg+" message should display ";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	public static void verifyRoomShareInfoPage() throws InterruptedException {
		
		actualMsg = "If you’re not ready to book your hotel at this time, you can Return to My Account profile and make your reservation at any time. Please note, the hotel selection is based on availability at the time of booking and cannot be guaranteed at a later time."+"\n\nGSX attendees are required to room share.  Please select your room share preference below.  If you do not wish to room share, you may select “single room” and you will be responsible for 50% of the room fee and taxes.";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.roomshareinfomration.text"));
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
//		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
//			actualMsg = "Book your hotel message displayed successfully";
//			expectedMsg = "Book your hotel message should display";
//			status = "PASS";
//			CommonUtil.logMessage(expectedMsg, actualMsg, status);
//		} else {
//			actualMsg = "Book your hotel message is not displayed";
//			expectedMsg = "Book your hotel message should display";
//			status = "FAIL";
//			CommonUtil.logMessage(expectedMsg, actualMsg, status);
//		}
	}
	public static void verifyRoomShareInfoMsg() throws InterruptedException {
		actualMsg = "GSX attendees are required to room share.  Please select your room share preference below.  If you do not wish to room share, you may select “single room” and you will be responsible for 50% of the room fee and taxes.";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.roomshareinfomration.GSXattenedeerequired.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "GSX attendees are required to room share message is displayed successfully";
			expectedMsg = "GSX attendees are required to room share message should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "GSX attendees are required to room share message is not displayed";
			expectedMsg = "GSX attendees are required to room share message should display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}
	
	public static void validateconfomedetailstext() {
		
		//CommonUtil.waitForPageload();
		actualMsg = "Final hotel details will be sent the week of July 18, 2016."+"\n\nCANCELLATION POLICY:  Individual hotel cancellations must be received no later than 72 hours prior to your scheduled arrival date.  If you do not arrive or \u201Cno show\u201D on your scheduled arrival date, your department may be charged at minimum one night\u2019s room and tax and the remainder of your reservation will be cancelled.";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.confomedetails.textmsg"));
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Hotel Reservations details text is displayed successfully";
			expectedMsg = "Hotel Reservations details message should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Hotel Reservations details text is not displayed successfully";
			expectedMsg = "Hotel Reservations details message should display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}
	public static void validateSlectdatetextMsg() {
		CommonUtil.waitForPageload();
		actualMsg = commonProperties.getProperty("Cisco.SelectYourDates.Hotelnights");
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.selectyoudates.text"));
		System.out.println(actualMsg);

		System.out.println(expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "select date infromation text is displayed successfully";
			expectedMsg = "select date infromation text should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "select date infromation text is not displayed successfully";
			expectedMsg = "select date infromation text should display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	public static void validateHotelRoommateRequest() {
		CommonUtil.waitForPageload();
		//validateHotelRoommateRequestParagraph();
		
		actualMsg = "Hotel Roommate Request";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.hotelroomaterequest"));
		System.out.println("expectedMsg   "+expectedMsg);
	
		if (expectedMsg.contains(actualMsg)) {
			System.out.println("true");

			actualMsg = actualMsg+" screen displays successfully";
			expectedMsg = actualMsg+" screen should display ";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("false");
			actualMsg = actualMsg+" screen displays successfully";
			expectedMsg = expectedMsg+" screen should display ";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
		
	}
	public static void validateHotelRoommateRequestParagraph() {
		CommonUtil.waitForPageload();
		
		
		actualMsg = commonProperties.getProperty("HotelRoommateRequest.text");
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.roommate.text"));
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
	
	
	public static void rejectRoomate(){
		CommonUtil.waitForPageload();		
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.hotelroomaterequest.rejectroommate"));
		CommonUtil.waitForPageload();
	}
	public static void acceptRoomate() throws InterruptedException {
		CommonUtil.waitForPageload();		
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.hotelroomaterequest.acceptroommate"));
		CommonUtil.waitForPageload();
		Thread.sleep(4000);
		
		actualMsg = "No hotels/room types are available for the selected dates. Please reselect your dates.";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.popup.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("No hotels/room types are available for the selected dates");
			Thread.sleep(2000);
			CommonUtil
			.click(elementProperties
					.getProperty("cisco.gsx.registration.popup.cancel"));
			Thread.sleep(2000);
		}else{
			System.out.println("Hotel Dates are available");
			CommonUtil
			.click(elementProperties
					.getProperty("cisco.gsx.registration.continue"));
		}
	}
	

}
