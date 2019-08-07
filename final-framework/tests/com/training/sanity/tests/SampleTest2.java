package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.training.generics.ScreenShot;

import com.training.pom.SecondPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;




public class SampleTest2 {
	private WebDriver driver; 
	private String baseUrl; 
	private SecondPOM secondPOM; 
	//private HomePagePOM homePagePOM; 
	private static Properties properties; 
	private ScreenShot screenShot; 
	static int count=1;
	
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException { 
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		secondPOM = new SecondPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		secondPOM.sendUserName("Priyansh");
		secondPOM.sendPassword("Priyansh@1234");
		secondPOM.clickLoginBttn(); 
		secondPOM.pressCatalog();
		secondPOM.searchCourse("Selenium_Learning");
		secondPOM.clickSearch();
		secondPOM.openSelected("Selenium_Learning");
		secondPOM.subscribeClick();
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
	    
	    if(count==1){
	    	System.out.println("first testcase executed successfully ");
	    }
	    else if(count==2){
	    	System.out.println("second testcase executed successfully ");
	    }
	    else if(count==3){
	    	System.out.println("third testcase executed successfully ");
	    }
		count++;
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void completeAssign() {
			
			screenShot.captureScreenShot("last");
			secondPOM.clickAssgignment();
			secondPOM.clickHanhsOn();
			secondPOM.clickUploadAssign();
			}


        @Test(priority=3)
		public void chatGroup() throws InterruptedException{
        	secondPOM.clickGroups();
        	secondPOM.clickRockers();
        	secondPOM.clickChat();
        	secondPOM.switchWindow();
        	driver.manage().window().maximize();
        	Thread.sleep(3000);
        	secondPOM.chatTextValue();
        	Thread.sleep(2000);
        	secondPOM.clickSendMSG();
        	Thread.sleep(4000);
        	driver.close();
        	}


		
		@Test(priority=2)
		public void forumDiscuss() throws InterruptedException
		{
			
			secondPOM.clickForum();
			secondPOM.clickRockers();
			secondPOM.clickCreateThread();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			secondPOM.giveTextValue();
			WebDriverWait waitt= new WebDriverWait(driver, 30);
			waitt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			secondPOM.giveBodyText("need help");
			driver.switchTo().defaultContent();
			secondPOM.clickSubmitPost();
			secondPOM.clickReply();
			waitt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@frameborder='0']")));
			secondPOM.giveBodyText("take google help");
			driver.switchTo().defaultContent();
			secondPOM.clickSubmitPost();
			WebElement downward=driver.findElement(By.xpath("//h3[@class='forum_post_title']//em"));
			Thread.sleep(3000);
			secondPOM.scrollDown(downward);
			
			
			
		}
		
		
		
	
	
}
