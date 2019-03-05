package com.cisco.gsx.pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class CopyOfSessionCatalog {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	public static String selectinterest = null;
	public static List<WebElement> checkboxes = null;
	
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	public static void validateSessionsPage() throws InterruptedException {
		
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(10);
		//CommonUtil.wait("cisco.gsx.sessioncatalog.button.viewagenda");
		actualMsg = "My Account Profile";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.Paymentinfo.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User entered My Account Profile screen successfully";
			 expectedMsg = "User should enterMy Account Profile screen successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to enter My Account Profile screen";
			expectedMsg = "User should enter My Account Profile successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	
	public static void clickAgenda() {
		
		//CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(2);
		//CommonUtil.wait("cisco.gsx.sessioncatalog.button.viewagenda");
		CommonUtil.click(elementProperties.getProperty("cisco.MyAccountProfile.SessionCatalog"));
	}
	public static void switchToNewWindow() {
		  CommonUtil.switchToNewWindow();
		 }
	
	public static void validateSessionHomePage() {
		CommonUtil.explicitlyWait(2);
		CommonUtil.waitForPageload();	
		actualMsg = "Session Catalog";
		expectedMsg = CommonUtil.getText(elementProperties.getProperty("cisco.sessioncatalog.sessioncatalog.title"));
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = " User entered Session Catalog screen successfully";
			expectedMsg = "User should enter Session Catalog screen successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = "User failed to enter Session Catalog screen";
			expectedMsg = "User should enter Session Catalog successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
		
	}
	
	public static void selectInterest() throws InterruptedException {
		CommonUtil.explicitlyWait(2);
		//CommonUtil.waitForPageload();
		System.out.println("***************"+CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.session.class"),"class"));
		if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.session.class"),"class").
				equalsIgnoreCase(commonProperties.getProperty("cisco.intrested")))
		{
				System.out.println("class name is verified");
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.session.interest.button"));
				CommonUtil.explicitlyWait(2);
				selectinterest = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.session.name"));
				System.out.println("Interested Session Name"+selectinterest);
				CommonUtil.explicitlyWait(2);
				
				actualMsg = commonProperties.getProperty("cisco.AddtoMyintrest");
				expectedMsg = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.session.class"),"class");
				System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
				if (actualMsg.equalsIgnoreCase(expectedMsg))
				{
					System.out.println("Actual and Expected messages are same");
					actualMsg = "User selected the intrested session";
					expectedMsg = "User should able select the session";
					status = "PASS";
					CommonUtil.logMessage(expectedMsg, actualMsg, status);
					CommonUtil.explicitlyWait(3);
					
					
				} 
				else 
				{
					System.out.println("Actual and Expected messages are not same");
					actualMsg = "User selected the intrested session";
					expectedMsg = "User not able select the intrested session";
					status = "FAIL";
					CommonUtil.logMessage(expectedMsg, actualMsg, status);
			    }
		}
		else
		{
			System.out.println("add to my interests clicked");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.session.AddtoMyinterest.button"));
			CommonUtil.explicitlyWait(2);
			System.out.println("***************"+CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.session.class"),"class"));

			selectinterest = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.session.name"));
			System.out.println("Interested Session Name : "+selectinterest);
			CommonUtil.explicitlyWait(4);
		 //  CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.secondinterest"));
			actualMsg = commonProperties.getProperty("cisco.intrested");
			expectedMsg = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.session.class"),"class");
			System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
			if (actualMsg.equalsIgnoreCase(expectedMsg)) 
			{
				System.out.println("Actual and Expected messages are same");
				actualMsg = "User selected the intrested session";
				expectedMsg = "User should able select the session";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				CommonUtil.explicitlyWait(3);
				
				
			} else 
			{
				System.out.println("Actual and Expected messages are not same");
				actualMsg = "User selected the intrested session";
				expectedMsg = "User not able select the intrested session";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				
			}
		}
	}
		
		
		
		
	
	
	public static void clickMyIntrests() {
		CommonUtil.explicitlyWait(2);
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.myinterests"));
	}
	
	public static void validateMyIntrestsHomePage() {
		CommonUtil.explicitlyWait(2);
		CommonUtil.waitForPageload();
		actualMsg = "My Interests";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.sessioncatalog.myinterestsheading"));
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = "My Interest Home page is displayed";
			expectedMsg = "My Interest Home page is displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = " My Interest Home page failed";
			expectedMsg = " My Interest Home page is displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}
	
	public static void verifySelectedIntrests() {
		CommonUtil.explicitlyWait(2);
		CommonUtil.waitForPageload();	
		List<WebElement> list= CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.sessioncatalog.myintrests.titles"));
		System.out.println("Interest"+selectinterest);

		for(WebElement s:list)
		{
			System.out.println(s.getText()+"****"+selectinterest);
		  if(s.getText().equalsIgnoreCase(selectinterest))
		  { 
			  System.out.println("passed");
		  }
		  
		}
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.SessionCatalog"));
		CommonUtil.waitForPageload();
	}
	
	
	 public static void search(){
		  List<String> myAgendalistarray1 = new ArrayList<>();

		CommonUtil.enterText(elementProperties.getProperty("Cisco.SessionCatalog.Search"),commonProperties.getProperty("cisco.search"));
		CommonUtil.click(elementProperties.getProperty("Search.button"));
		CommonUtil.explicitlyWait(2);
		checkboxes = CommonUtil.findElements(elementProperties.getProperty("Search.results.Count"));
		System.out.println("Type"+checkboxes.size());
		if(checkboxes.size()<=1){
			for(int i=1;i<checkboxes.size();i++){
				
				   actualMsg= CommonUtil.getText(elementProperties.getProperty("Search.results.SessionName").replaceAll("VarX", Integer.toString(i)));
			  
				  		myAgendalistarray1.add(actualMsg);
		
			}
			for(String s:myAgendalistarray1){  
				 System.out.println(s);  
			}  
			 System.out.println(myAgendalistarray1.size());
			 validateSearchResult(checkboxes.size(),myAgendalistarray1.size());
			 
		}else{
			System.out.println("No Search Results");
		} 
	 
	 }
	 public static void validateSearchResult(int totalcount, int sessionNameCount) {
			
		
			if (actualMsg.equalsIgnoreCase(expectedMsg)) 
			{
				System.out.println("Actual and Expected messages are same");
				actualMsg = totalcount + " session details displays successfully";
				expectedMsg =  sessionNameCount + " session details should display";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			} 
			else 
			{
				System.out.println("Actual and Expected messages are not same");
				actualMsg = totalcount + " session details displays successfully";
				expectedMsg =  sessionNameCount + " session details should display";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
	}
	public static void ValidateSessionType()
	{
		CommonUtil.explicitlyWait(2);
		CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Type"));
		CommonUtil.explicitlyWait(2);
		checkboxes = CommonUtil.findElements(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.All"));
		System.out.println("Type"+checkboxes.size());
		CommonUtil.explicitlyWait(1);
		
		for(int i=0;i<checkboxes.size();i++)
		{	
		
		   checkboxes.get(i).getAttribute("name");
		   System.out.println("Type"+checkboxes.get(i).getAttribute("name"));
		
				if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("1820604147")) {
					
					/*CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontype.BreakoutSession"));
					CommonUtil.explicitlyWait(2);
					SessionCatalog.validateSessionTypes(elementProperties.getProperty("cisco.gsx.Sessiontype.Breakname"), "Breakout Session",
							elementProperties.getProperty("cisco.gsx.Sessiontype.Breakname.count"));
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontype.BreakoutSession"));
					CommonUtil.explicitlyWait(1);*/
				} 
				else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("878277136")) {
					System.out.println("DevNetSession");
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontype.DevNetSession"));
					CommonUtil.explicitlyWait(1);
					CopyOfSessionCatalog.validateSessionTypes(elementProperties.getProperty("cisco.gsx.Sessiontype.DevNetSession"), "DevNet Session",
							elementProperties.getProperty("cisco.gsx.Sessiontype.DevNetSession.count"));
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontype.DevNetSession"));
					CommonUtil.explicitlyWait(1);
					
				} else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("1804061741")) {
					
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontype.SuperSession"));
					CommonUtil.explicitlyWait(1);
					CopyOfSessionCatalog.validateSessionTypes(elementProperties.getProperty("cisco.gsx.Sessiontype.SuperSession"), "Super Session"
							,elementProperties.getProperty("cisco.gsx.Sessiontype.SuperSession.count"));
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontype.SuperSession"));
					CommonUtil.explicitlyWait(1);
					
					
				}
		}
		CommonUtil.waitForPageload();
	}
	
	public static void validateSessionTypes(String sessionTypeXpath, String sessionTypeName ,String realCount) {
		
		CommonUtil.explicitlyWait(1);
		String count =CommonUtil.getText(realCount);
	
		
		String [] arrOfStr = count.split(" ");
		 
        for (String a : arrOfStr){
            System.out.println(a);
        }
       // System.out.println(">>>>>>>>>>>>>>"+arrOfStr[2].substring(1, 2));
       String sessions = arrOfStr[2].substring(1, 2);
		
		/*List<WebElement> SessionTitles=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.Sessiontype.titles"));
		System.out.println("Session Titles Count "+SessionTitles.size());
		CommonUtil.explicitlyWait(1);*/
		List<WebElement> sessionTypeNames=CommonUtil.findElements(sessionTypeXpath);
		actualMsg = sessions;
		expectedMsg = Integer.toString(sessionTypeNames.size());
		System.out.println("Number "+actualMsg+"*****"+expectedMsg);
		
		if (actualMsg.equalsIgnoreCase(expectedMsg)) 
		{
			System.out.println("Actual and Expected messages are same");
			actualMsg = sessionTypeName + " session details displays successfully";
			expectedMsg =  sessionTypeName + " session details should display";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} 
		else 
		{
			System.out.println("Actual and Expected messages are not same");
			actualMsg = sessionTypeName+ " session details are not displayed";
			expectedMsg =  sessionTypeName + " session details should display";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
}

	
		public static void SessionCatalogTrack() {
		CommonUtil.explicitlyWait(2);
		System.out.println("Track");
			CommonUtil.explicitlyWait(2);
			CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Track"));
			CommonUtil.explicitlyWait(2);
			
			checkboxes = CommonUtil.findElements(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontrack.All"));
			System.out.println("Track"+checkboxes.size());
			CommonUtil.explicitlyWait(1);
			
			for(int i=0;i<checkboxes.size();i++)
			{	
				System.out.println(checkboxes.get(i).getAttribute("name"));
				if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("161354688")) {
	//				
						System.out.println("stageric");
						CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontrack.AMGoToMarket"));
						System.out.println("click is working");
						CommonUtil.waitForPageload();
						CommonUtil.ESCAPE();
						CommonUtil.explicitlyWait(3);
						CommonUtil.click(elementProperties.getProperty("cisco.Track.link"));
						CommonUtil.explicitlyWait(3);
						System.out.println("Alert");
						//CommonUtil.switchToFrame();
						CommonUtil.isAlertPresent();
						System.out.println("Alert");
						CopyOfSessionCatalog.validateTrack(elementProperties.getProperty("cisco.Track.text.count"), "AM - Go To Market");
						
						CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Track"));
						CommonUtil.explicitlyWait(2);
						CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontrack.AMGoToMarket"));
						CommonUtil.explicitlyWait(1);
						
					
					
				}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("960130518")) {
					
						
						CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontype.SETechnicalSolutions"));
						CommonUtil.waitForPageload();
						CommonUtil.ESCAPE();
						CommonUtil.explicitlyWait(3);
						CommonUtil.click(elementProperties.getProperty("cisco.Track.link"));
						CommonUtil.explicitlyWait(2);
						CopyOfSessionCatalog.validateTrack(elementProperties.getProperty("cisco.Track.text.count"), "SE - Technical Solutions" );
						CommonUtil.waitForPageload();
						CommonUtil.explicitlyWait(1);
						CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Track"));
						CommonUtil.explicitlyWait(2);
						CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontype.SETechnicalSolutions"));
						CommonUtil.explicitlyWait(1);
					}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("1412006845")) {
						System.out.println("sucess");
							
						CommonUtil.click(elementProperties.getProperty("Cisco.Sessiontype.SalesCulture"));
						CommonUtil.waitForPageload();
						CommonUtil.ESCAPE();
						CommonUtil.explicitlyWait(3);
						CommonUtil.click(elementProperties.getProperty("cisco.Track.link"));
						CommonUtil.explicitlyWait(1);
						//CommonUtil.switchToFrame();
						CommonUtil.isAlertPresent();
						CopyOfSessionCatalog.validateTrack(elementProperties.getProperty("cisco.Track.text.count"), "Sales Culture and Enablement" );
						CommonUtil.waitForPageload();
						CommonUtil.explicitlyWait(1);
						
						
					} 
			
					CommonUtil.waitForPageload();
			}
	}
	
	public static void validateTrack(String sessionTypeXpath, String sessionTypeName)
	{
			CommonUtil.explicitlyWait(1);
			expectedMsg = sessionTypeName;//AM - Go To Market
			System.out.println("Expected Message : "+expectedMsg);
			
			  List<WebElement> list=CommonUtil.findElements(elementProperties.getProperty("cisco.Track.text.count"));
			   System.out.println("Track List Count : "+list.size());
	
			  for(int i=1;i<=list.size();i++){
			   
			   actualMsg= CommonUtil.getText(elementProperties.getProperty("cisco.Track.text").replaceAll("VarX", Integer.toString(i)));
			   System.out.println("actualMsg"+i+actualMsg);
			   if (actualMsg.contains(expectedMsg)) 
				   break;
			  }
			System.out.println("Actual Message : "+actualMsg);
			
			CommonUtil.scroll(CommonUtil.findElement(elementProperties.getProperty("Cisco.Category.Paragraph")));
			CommonUtil.explicitlyWait(1);
			System.out.println("Actual Message : "+actualMsg);
			if (actualMsg.contains(expectedMsg)) 
			{
				System.out.println("Actual and Expected messages are same");
				actualMsg = sessionTypeName + " Track is successfully verified";
				expectedMsg =  sessionTypeName + " Track is verified successfully";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				CommonUtil.click(elementProperties.getProperty("cisco.session.Close"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(2);
	
				
			} 
			else 
			{
				System.out.println("Actual and Expected messages are not same");
				actualMsg = sessionTypeName+ " Track verification is failed";
				expectedMsg =  sessionTypeName + " Track is verified successfully";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
	}
	


	public static void SessionCategory() {
		
		CommonUtil.explicitlyWait(2);
		System.out.println("Category");
			CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
			CommonUtil.explicitlyWait(2);
			
			checkboxes = CommonUtil.findElements(elementProperties.getProperty("Cisco.Sessioncatalog.Sessioncategory.All"));
			System.out.println("Track"+checkboxes.size());
			CommonUtil.explicitlyWait(1);
	
			for(int i=0;i<checkboxes.size();i++)
			{	
				System.out.println(checkboxes.get(i).getAttribute("name"));
				if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("1748198443")) {
	
					System.out.println("Analytics");
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.Analytics"));
					System.out.println("Selected Analytics checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(3);
					CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);
					//CommonUtil.switchToFrame();
					boolean b = CommonUtil.isAlertPresent();
					System.out.println("boolean"+b);
					CopyOfSessionCatalog.validateCategory(elementProperties.getProperty("Cisco.Category.text"), "Analytics");
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.Analytics"));
					CommonUtil.explicitlyWait(1);
					
				
				
				}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("2144933529")) {
	
					System.out.println("Cisco Captial");
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.CiscoCaptial"));
					System.out.println("Selected Cisco Capital checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);
					//CommonUtil.switchToFrame();
					CommonUtil.isAlertPresent();
					CopyOfSessionCatalog.validateCategory(elementProperties.getProperty("Cisco.Category.text"), "Cisco Capital");
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.CiscoCaptial"));
					CommonUtil.explicitlyWait(1);
					
				
				
			}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("194422088")) {
				System.out.println("EnetPriseNetworking");
				
				CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.DataAndCloud"));
				System.out.println("Selected EnetPrise Networking checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				//CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				CopyOfSessionCatalog.validateCategory(elementProperties.getProperty("Cisco.Category.text"), "Data Center and Cloud");
				CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.DataAndCloud"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);
				
				
		}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("539655506")) {
					System.out.println("EnetPriseNetworking");
					
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.EnetPriseNetworking"));
					System.out.println("Selected EnetPrise Networking checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);
					//CommonUtil.switchToFrame();
					CommonUtil.isAlertPresent();
					CopyOfSessionCatalog.validateCategory(elementProperties.getProperty("Cisco.Category.text"), "Enterprise Networking");
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.EnetPriseNetworking"));
					CommonUtil.waitForPageload();
					CommonUtil.explicitlyWait(1);
					
					
			}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("716796379")) {
				System.out.println("People and Culture");
				
				CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.PeopleAndCulture"));
				System.out.println("Selected People and Culture checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				//CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				CopyOfSessionCatalog.validateCategory(elementProperties.getProperty("Cisco.Category.text"), "People and Culture");
				CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.PeopleAndCulture"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);			
				
			}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("1022211991")) {
				System.out.println("Security");
				
				CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.Security"));
				System.out.println("Selected Security checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				//CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				CopyOfSessionCatalog.validateCategory(elementProperties.getProperty("Cisco.Category.text"), "Security");
				CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.Security"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);			
				
			}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("105940206")) {
				System.out.println("SellerEnablement");
				
				CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.SellerEnablement"));
				System.out.println("Selected SellerEnablement checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				//CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				CopyOfSessionCatalog.validateCategory(elementProperties.getProperty("Cisco.Category.text"), "Seller Enablement");
				CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.SellerEnablement"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);			
				
			}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("602215160")) {
				System.out.println("SellerEnablement");
				
				CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.SellingSoftWare"));
				System.out.println("Selected Selling Software checkbox");
				CommonUtil.waitForPageload();
				CommonUtil.ESCAPE();
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
				CommonUtil.explicitlyWait(1);
				//CommonUtil.switchToFrame();
				CommonUtil.isAlertPresent();
				CopyOfSessionCatalog.validateCategory(elementProperties.getProperty("Cisco.Category.text"), "Selling Software");
				CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Category"));
				CommonUtil.explicitlyWait(2);
				CommonUtil.click(elementProperties.getProperty("Cisco.SessionCategory.SellingSoftWare"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(1);			
				
			}
				
		
			}
	}
	public static void validateCategory(String sessionTypeXpath, String sessionTypeName)
	{
			CommonUtil.explicitlyWait(3);
			expectedMsg = sessionTypeName;
			System.out.println("Expected Message : "+expectedMsg);
			
			actualMsg = CommonUtil.getText(sessionTypeXpath);	
			CommonUtil.scroll(CommonUtil.findElement(elementProperties.getProperty("Cisco.Category.Paragraph")));
			CommonUtil.explicitlyWait(1);
			System.out.println("Actual Message : "+actualMsg);
			
			System.out.println("Description :"+CommonUtil.getText(elementProperties.getProperty("Cisco.Category.Paragraph")));
			if (actualMsg.equalsIgnoreCase(expectedMsg)) 
			{
				System.out.println("Actual and Expected messages are same");
				actualMsg = sessionTypeName + " Category is successfully verified";
				expectedMsg =  sessionTypeName + " Category is verified successfully";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				CommonUtil.click(elementProperties.getProperty("cisco.session.Close"));
				//CommonUtil.ESCAPE();
				//CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.close"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(2);
				
			} 
			else 
			{
				System.out.println("Actual and Expected messages are not same");
				actualMsg = sessionTypeName+ " Category verification is failed";
				expectedMsg =  sessionTypeName + " Category is verified successfully";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
	}
	public static void sessionPillar(){
		CommonUtil.explicitlyWait(2);
		System.out.println("Category");
			CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
			CommonUtil.explicitlyWait(2);
			
			checkboxes = CommonUtil.findElements(elementProperties.getProperty("Cisco.Sessioncatalog.SessionPillar.All"));
			System.out.println("Track"+checkboxes.size());
			CommonUtil.explicitlyWait(1);
	
			for(int i=0;i<checkboxes.size();i++)
			{	
				System.out.println(checkboxes.get(i).getAttribute("name"));
				if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("1631722066")) {
	
					System.out.println("Reinvent");
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCatalog.ReinventtheNetwork"));
					System.out.println("Selected Analytics checkbox");
					CommonUtil.waitForPageload();
					//CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(3);
					CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);
					//CommonUtil.switchToFrame();
					CommonUtil.isAlertPresent();
					CopyOfSessionCatalog.validatePillar(elementProperties.getProperty("Cisco.Pillar.text"), "Reinvent the Network");
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCatalog.ReinventtheNetwork"));
					CommonUtil.explicitlyWait(1);
					
				
				
				}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("1529707701")) {
	
					System.out.println("CIsco Captial");
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCatalog.MeaningFullExperience"));
					System.out.println("Selected Cisco Capital checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);
					//CommonUtil.switchToFrame();
					CommonUtil.isAlertPresent();
					CopyOfSessionCatalog.validatePillar(elementProperties.getProperty("Cisco.Pillar.text"), "Create Meaningful Experiences");
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCatalog.MeaningFullExperience"));
					CommonUtil.explicitlyWait(1);
				
				}else if(checkboxes.get(i).getAttribute("name").equalsIgnoreCase("1837182961")) {
	
					System.out.println("CIsco Captial");
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCatalog.SecurityFoundational"));
					System.out.println("Selected Cisco Capital checkbox");
					CommonUtil.waitForPageload();
					CommonUtil.ESCAPE();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("cisco.Category.link"));
					CommonUtil.explicitlyWait(1);
					//CommonUtil.switchToFrame();
					CommonUtil.isAlertPresent();
					CopyOfSessionCatalog.validatePillar(elementProperties.getProperty("Cisco.Pillar.text"), "Security is Foundational");
					CommonUtil.click(elementProperties.getProperty("Cisco.Sessioncatalog.Sessiontype.Pillar"));
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("Cisco.SessionCatalog.SecurityFoundational"));
					CommonUtil.explicitlyWait(1);
				
			}
		}
	 }
	public static void validatePillar(String sessionTypeXpath, String sessionTypeName)
	{
			CommonUtil.explicitlyWait(1);
			expectedMsg = sessionTypeName;//AM - Go To Market
			System.out.println("Expected Message : "+expectedMsg);
			
			  List<WebElement> list=CommonUtil.findElements(elementProperties.getProperty("Cisco.Pillar.text.count"));
			   System.out.println("Track List Count : "+list.size());
	
			  for(int i=1;i<=list.size();i++){
			   
				 // if(sessionTypeName.equals("Reinvent the Network")) 
					  actualMsg= CommonUtil.getText(elementProperties.getProperty("Cisco.Pillar.text").replaceAll("VarX", Integer.toString(i)));
				//  else
					//  actualMsg= CommonUtil.getText(elementProperties.getProperty("Cisco.Pillar.Second.text").replaceAll("VarX", Integer.toString(i)));
  
				   if (actualMsg.contains(expectedMsg)) 
					   break;
			  }
			System.out.println("Actual Message : "+actualMsg);
			
			if (actualMsg.contains(expectedMsg)) 
			{
				System.out.println("Actual and Expected messages are same");
				actualMsg = sessionTypeName + " Track is successfully verified";
				expectedMsg =  sessionTypeName + " Track is verified successfully";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				CommonUtil.click(elementProperties.getProperty("cisco.session.Close"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(2);
	
				
			} 
			else 
			{
				System.out.println("Actual and Expected messages are not same");
				actualMsg = sessionTypeName+ " Track verification is failed";
				expectedMsg =  sessionTypeName + " Track is verified successfully";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
	}
	
	

}


