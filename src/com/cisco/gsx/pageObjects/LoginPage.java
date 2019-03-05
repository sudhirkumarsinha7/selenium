package com.cisco.gsx.pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.excelreader.DataPojoClass;
import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class LoginPage {
	private static WebElement webElement = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String locator = null;
	private static String field = null;
	private static String value = null;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	public static void validateLoginPage() throws InterruptedException {
		CommonUtil.waitForPageload();	
		CommonUtil.explicitlyWait(7);
		
		actualMsg = "Cisco.com Login Page";
		expectedMsg =CommonUtil.getTitle();
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("In If loop");
			actualMsg = "LoginPage is displayed to the user";
			expectedMsg = "LoginPage should be displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			expectedMsg = CommonUtil.getTitle();
			System.out.println("***"+expectedMsg);
			System.out.println("Not In If loop");
		
			actualMsg = "LoginPage is not Display to User";
			expectedMsg = "LoginPage should Display to User";
			status = "FAIL";
			
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			
		}
		
		CommonUtil.waitForPageload();	
	}
	
	public static void login(DataPojoClass pojo){
		CommonUtil.waitForPageload();	
		CommonUtil.enterText(
				elementProperties.getProperty("cisco.gsx.username"),
				pojo.getUserName());
		
		CommonUtil.enterText(
				elementProperties.getProperty("cisco.gsx.password"),
				pojo.getPassword());
		CommonUtil.explicitlyWait(1);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
		CommonUtil.explicitlyWait(2);
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
		cookies();
		
	}
	public static void cookies(){
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.cookiesPopUp"));
		CommonUtil.explicitlyWait(1);
	}
	public static void error(){
		CommonUtil.waitForPageload();
		CommonUtil.takeScreenShot();
		String Text=CommonUtil.getText(elementProperties.getProperty("error"));
		System.out.println(Text);
		actualMsg = "GSX FY18";
		String actualMsg1 = "We’re sorry but your name is not found on the pre-approved list to attend GSX FY18";
		expectedMsg = Text;
		//System.out.println(str);
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (expectedMsg.contains(actualMsg)) {
			System.out.println("In If loop");
			actualMsg = "Error message is displayed";
			expectedMsg = "Error should be displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Error message is not displayed";
			expectedMsg = "Error should be displayed";
			status = "FAIL";
			
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			
		}
	}
	public static void lanyonError(){
		CommonUtil.waitForPageload();	
		String error=CommonUtil.getText("cisco.gsx.error");
		System.out.println(error);
		CommonUtil.takeScreenShot();
		
	}
	
	public static void enterCredentials() {
		CommonUtil.waitForPageload();
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.login.username"));
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.login.password"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
		
		CommonUtil.waitForPageload();
	}

}
