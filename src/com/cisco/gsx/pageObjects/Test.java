package com.cisco.gsx.pageObjects;


import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Test {
	public static void main(String args[]) throws Exception{
		WebDriver driver;
	    //Modify the path of the GeckoDriver in the below step based on your local system path
          //  System.setProperty("webdriver.gecko.driver","D://Selenium Environment//Drivers//geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:/vijaya-Cisco-2016/Chromedriver_Cisco/chromedriver.exe");
		//driver = new ChromeDriver();  
		// Instantiation of driver object. To launch Firefox browser
	     driver = new ChromeDriver();
            // To oepn URL "http://softwaretestingmaterial.com"
	    driver.get("https://www.softwaretestingmaterial.com");
	    Thread.sleep(2000);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination 
				File DestFile=new File("D:\1.jpg");
				
				//Copy file at destination
				FileUtils.copyFile(SrcFile, DestFile);
	    Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	    ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D:\\FullPageScreenshot.png"));
        }
}