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

public class EID_HolidayList {
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
		
		actualMsg = "GSX FY19";
		expectedMsg = CommonUtil.getTitle();
		System.out.println("validateRegistrationPage***"+expectedMsg);

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User loggedin to the GSX successfully";
			expectedMsg = "User should be login to the GSX successfully";
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

	public static void enterEIDContactInformation(DataPojoClass pojo) throws InterruptedException {
		
		
		CommonUtil.waitForPageload();
		 CommonUtil.takeScreenShot();
		
		// verifyContactinformationPage();
   	//Vijaya : Country field changed as dropdown and province code
    CommonUtil.selectValueFromDropDownBox(elementProperties
			.getProperty("cisco.eid.role"),
			pojo.getRole());

    CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.eid.svp"),
    		commonProperties.getProperty("SVP"));
    CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.eid.vp"),
			commonProperties.getProperty("VP"));
    
    
	CommonUtil.takeScreenShot();
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.contactinfo.continue"));
		

	}
	public static void validateMyAccountPage() throws InterruptedException {
		CommonUtil.waitForPageload();
		 CommonUtil.explicitlyWait(5);
		
		actualMsg = "My Account Profile";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.Paymentinfo.text"));
		System.out.println("validateRegistrationPage***"+expectedMsg);

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User registration succeed";
			expectedMsg = "User should able to register successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User registration failed";
			expectedMsg = "User should able to register successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}
	public static void updateEIDContactInformation() throws InterruptedException {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties
				.getProperty("cisco.eid.updatecontactInfo"));
	}

	
}

