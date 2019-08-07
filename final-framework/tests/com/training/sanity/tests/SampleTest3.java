package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.SecondPOM;
import com.training.pom.ThirdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SampleTest3 {
	private WebDriver driver; 
	private String baseUrl; 
	private ThirdPOM thirdPOM;
	private static Properties properties; 
	private ScreenShot screenShot; 
	private SecondPOM secondPOM;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		thirdPOM = new ThirdPOM(driver); 
		secondPOM=  new SecondPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		secondPOM.sendUserName("admin");
		secondPOM.sendPassword("admin@123");
		secondPOM.clickLoginBttn();
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test(enabled=false)
	public void displaysAddedCategory(String codeData,String categoryData,String titleData) {
			
		thirdPOM.clickAdminTab();
		thirdPOM.clickCourseCategory();
		thirdPOM.clickAddCategory();
		thirdPOM.giveCategoryCode("BL");
		thirdPOM.giveCategoryName("Blended Learning");
		thirdPOM.selectRadioCourse();
		thirdPOM.clickAddButton();
		thirdPOM.clickAdminTab();
		thirdPOM.clickAddCourse();
		thirdPOM.giveTitle("testing");
		thirdPOM.giveCode("tes");
		thirdPOM.clickCategoryList();
		thirdPOM.giveCategoryData(codeData);
		thirdPOM.clickLang();
		thirdPOM.giveLangData("English");
		thirdPOM.clickSubmitCourse();
		
		screenShot.captureScreenShot("First");
		
		
		
		
		
		
	}
	
	
	
	@Test(dataProvider="elearningData1")
	public void multipleCategory1(String codeData1,String categoryData1,String titleData1){
		thirdPOM.clickCourseCategory();
		thirdPOM.clickAddCategory();
		thirdPOM.giveCategoryCode(codeData1);
		thirdPOM.giveCategoryName(categoryData1);
		thirdPOM.selectRadioCourse();
		thirdPOM.clickAddButton();
		thirdPOM.clickAddCategory();
		thirdPOM.clickAdminTab();
		thirdPOM.clickAddCourse();
		thirdPOM.giveTitle(titleData1);
		thirdPOM.giveCode(codeData1);
		thirdPOM.clickCategoryList();
		thirdPOM.giveCategoryData(codeData1);
		thirdPOM.clickLang();
		thirdPOM.giveLangData("English");
		thirdPOM.clickSubmitCourse();
		
     
		
	}
	
	
	
	@Test(dataProvider="elearningData2",enabled=false)
	public void multipleCategory2(String codeData2,String categoryData2,String titleData2){
		thirdPOM.clickCourseCategory();
		thirdPOM.clickAddCategory();
		thirdPOM.giveCategoryCode(codeData2);
		thirdPOM.giveCategoryName(categoryData2);
		thirdPOM.selectRadioCourse();
		thirdPOM.clickAddButton();
		thirdPOM.clickAddCategory();
		thirdPOM.clickAdminTab();
		thirdPOM.clickAddCourse();
		thirdPOM.giveTitle(titleData2);
		thirdPOM.giveCode(codeData2);
		thirdPOM.clickCategoryList();
		thirdPOM.giveCategoryData(codeData2);
		thirdPOM.clickLang();
		thirdPOM.giveLangData("English");
		thirdPOM.clickSubmitCourse();
		
     
		
	}
	
	
	
	@DataProvider(name="elearningData1")
	public Object[][] giveData1(){
		Object[][] dataValue1= new Object[4][3];
		
		dataValue1[0][0]="@!";
		dataValue1[0][1]="";
		dataValue1[0][2]="";
		
		dataValue1[1][0]="BL";
		dataValue1[1][1]="asd#@!#";
		dataValue1[1][2]="";
		
		dataValue1[2][0]="BL";
		dataValue1[2][1]="Blended Learning";
		dataValue1[2][2]="!@##!@";
		
		dataValue1[3][0]="BL";
		dataValue1[3][1]="Blended Learning";
		dataValue1[3][2]="Selenium";
		
		return dataValue1;
		
		
	}
	
	
	
	
	@DataProvider(name="elearningData2")
	public Object[][] giveData2(){
		Object[][] dataValue2= new Object[4][3];
		
		dataValue2[0][0]="BL";
		dataValue2[0][1]="Blended Learning";
		dataValue2[0][2]="Selenium";
		
		dataValue2[1][0]="WL";
		dataValue2[1][1]="WebILT";
		dataValue2[1][2]="Selenium Course";
		
		dataValue2[2][0]="CL";
		dataValue2[2][1]="ClassRoom";
		dataValue2[2][2]="Testing";
		
		dataValue2[3][0]="PJP";
		dataValue2[3][1]="Pre Joining";
		dataValue2[3][2]="JAVA";
		
		return dataValue2;
		
		
	}
       
	
	
	
	
}
