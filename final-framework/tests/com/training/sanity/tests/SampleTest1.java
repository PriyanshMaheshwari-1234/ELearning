package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SampleTest1 {
	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM homePagePOM; 
	private static Properties properties; 
	private ScreenShot screenShot; 
	
	
	
	
	 
	 
	 
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homePagePOM = new HomePagePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		homePagePOM.sendUserName("Priyansh");
		homePagePOM.sendPassword("Priyansh@1234");
		homePagePOM.clickLoginBtn(); 
		Thread.sleep(3000);
	}

	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		//driver.quit();
		
		System.out.println("After method executed");
	}
	
	
	
	
	@Test(priority=1)
	public void loginPassTest() throws InterruptedException {
		
		
			screenShot.captureScreenShot("First");
		homePagePOM.pressHome();
		homePagePOM.pressCatalog();
		homePagePOM.displayCheck(driver);
		  homePagePOM.countAvailableCourses();
		  
	}
		
		
		
	@Test(priority=2)
	public void myCourseTest(){
		homePagePOM.clickMyCourses();
		homePagePOM.selectedCourse(driver);
		 
	}
	
	
	
	@Test(priority=3)
	public void logOut() throws InterruptedException{
		homePagePOM.getOut();
		
		
		
	}
	
	
}
