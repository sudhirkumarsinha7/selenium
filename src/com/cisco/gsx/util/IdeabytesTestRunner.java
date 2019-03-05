package com.cisco.gsx.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.TestNG;

public class IdeabytesTestRunner {
	private static Set<String> methodSet = new HashSet<String>();
	public static Properties commonProperties = null;

	static {

		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	@SuppressWarnings("unchecked")
	public static void runGSXTestCases() {

		try {

			Set<String> testMethodSet = null;	
			//methodSet.add("attendeeRegistration");
			//methodSet.add("ChangeReservation");
			//methodSet.add("rejectRoomateRequest");
			//methodSet.add("makeReservation_AcceptHotelRoomateRequest");
			
			//methodSet.add("PrimaryupdateReservation_SecondaryCancel");
			//methodSet.add("cancelReservation");
			
			//methodSet.add("updateContactInformation");
			//methodSet.add("updatekeyQuestions");
			//methodSet.add("updateOnSiteInfo");
			
			//methodSet.add("SupportStaffRegistration");
			//methodSet.add("hubStaffRegistration");
			//methodSet.add("eventStaffRegistration");
			//methodSet.add("executiveRegistration");
			//methodSet.add("updateContactInformation");
			//methodSet.add("updatekeyQuestions");
			//methodSet.add("updateOnSiteInfo");
			//methodSet.add("changeReservationWhenRoomShareNo");
			
			//methodSet.add("eidHolidayRegistration");
			//methodSet.add("RoomShareInformation");
			//methodSet.add("Hub_updatekeyQuestions");
			//methodSet.add("MakeReservation_rejectRoomate");
		 //  methodSet.add("attendee_updateContactInformation");
		   /*methodSet.add("attendee_updatekeyQuestions");
			methodSet.add("attendee_updateOnSiteInfo");
			methodSet.add("executive_updateContactInformation");
			methodSet.add("executive_updateOnSiteInfo");
			methodSet.add("executive_updatekeyQuestions");
			methodSet.add("Hub_updateContactInformation");
			methodSet.add("Hub_updateOnSiteInfo");
			methodSet.add("Hub_updatekeyQuestions");
			methodSet.add("event_updateContactInformation");
			methodSet.add("event_updateOnSiteInfo");
			methodSet.add("event_updatekeyQuestions");
			
			methodSet.add("support_updateContactInformation");
			methodSet.add("support_updateOnSiteInfo");
			methodSet.add("support_updatekeyQuestions");
			
			methodSet.add("updateEIDContactInformation");*/
			
			
			
			
			
			
			
		
			
		// methodSet.add("acceptHotelRoomateRequest");
			//methodSet.add("makeReservation_AcceptHotelRoomateRequest");
			//methodSet.add("rejectRoomateRequest");
			//methodSet.add("MakeReservation_rejectRoomate");
			//methodSet.add("cancelReservation");
			//methodSet.add("ChangeReservation");
			
			//methodSet.add("Negative_additionalquestions");
			//methodSet.add("Negative_Flightonsite");
			//methodSet.add("negative_Contactinfo");
			//methodSet.add("updateContactInformation");
			//methodSet.add("updatekeyQuestions");
			//methodSet.add("updateOnSiteInfo");
			
			//methodSet.add("EndToEnd");
			//methodSet.add("verifySearch");
			//methodSet.add("verifyInterestsAddedInMyInterests");
			methodSet.add("verifySessioncategory");
	      	methodSet.add("verifySessionTrack");
			methodSet.add("verifySessionType");
			methodSet.add("verifySessionPillar");
			//methodSet.add("Login");
			//methodSet.add("eidHolidayRegistration");
			
			
			// methodSet.add("verifyInterestsAddedInMyInterests");
			//methodSet.add("acceptHotelRoomateRequest");
			//methodSet.add("Negative_Flightonsite");
			
			/*
			 * methodSet.add("TestCase3"); 
			 * methodSet.add("TestCase4");
			 */
			Map<String, Set<String>> q2oTestCasesMap = new HashMap<String, Set<String>>();
			q2oTestCasesMap.put("com.cisco.gsx.testsuites.GSX", methodSet);
			System.out.println("0.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			TestNG testng = new TestNG();
			System.out.println("1.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			Class classObj[] = new Class[q2oTestCasesMap.keySet().size()];
			System.out.println("2.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			int i = 0;

			for (Iterator iterator = q2oTestCasesMap.keySet().iterator(); iterator
					.hasNext(); i++) {
				String className = (String) iterator.next();
				System.out.println("vv:" + className);
				classObj[i] = Class.forName(className.trim());

				 methodSet.addAll(q2oTestCasesMap.get(className));
			}

			testng.setTestClasses(classObj);
			testng.addListener(new com.cisco.gsx.reports.IdeabytesListener());

			System.out.println("MethodSet :" + methodSet.size());
			testng.setMethodInterceptor(new IMethodInterceptor() {

				@Override
				public List<IMethodInstance> intercept(
						List<IMethodInstance> inMethod, ITestContext arg1) {
					List<IMethodInstance> methodList = new ArrayList<IMethodInstance>();

					for (IMethodInstance m : inMethod) {
						String methodName = m.getMethod().getMethodName();
						System.out.println("x:" + methodName);
						if (methodSet.contains(methodName)) {
							methodList.add(m);
							System.out.println("If loop in Ideabytes Test RUnner");
						}
						System.out.println("For loop in Ideabytes Test RUnner");
					}
					System.out.println("intercept function in Ideabytes Test RUnner");
					return methodList;
				}
			});
			System.out.println("Testng is about to run"); 
			testng.run();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
