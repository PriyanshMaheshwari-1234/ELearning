package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdPOM {

private WebDriver driver; 
	
	public ThirdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Administration")
	private WebElement adminTab;
	
	@FindBy(xpath="//*[@id='tabs-2']/div/div[2]/div[2]/ul/li[5]/a")
	private WebElement courseCategory;
	
	@FindBy(xpath="//img[@title='Add category']")
	private WebElement addCategory;
	
	
	@FindBy(id="course_category_code")
	private WebElement categoryCode;
	
	@FindBy(id="course_category_name")     
	private WebElement categoryName;
	
	@FindBy(xpath="//input[ @name='auth_course_child' and @value='TRUE']")
	private WebElement radioCourse;
	
	@FindBy(id="course_category_submit")
	private WebElement addButton;
	
	@FindBy(xpath="//*[@id='tabs-2']/div/div[2]/div[2]/ul/li[2]/a")
	private WebElement addCourse;
	
	@FindBy(id="update_course_title")
	private WebElement title;
	
	@FindBy(id="visual_code")
	private WebElement code;
	
	@FindBy(xpath="//button[@id='update_course_submit']")
	private WebElement submitCourse;
	
	@FindBy(xpath="//*[@id='update_course']/fieldset/div[3]/div[1]/div/button/div")
	private WebElement categoryList;
	
	@FindBy(xpath="//*[@id='update_course']/fieldset/div[3]/div[1]/div/div/div[1]/input")
	private WebElement categoryData;
	
	@FindBy(xpath="//*[@id='update_course']/fieldset/div[7]/div[1]/div/button/div")
	private WebElement langList;
	
	@FindBy(xpath="//*[@id='update_course']/fieldset/div[7]/div[1]/div/div/div[1]/input")
	private WebElement langData;
	
	public void clickLang(){
		this.langList.click();
	}
	
	
	public void giveLangData(String lng){
		this.langData.sendKeys(lng,Keys.RETURN);
	}
	
	public void giveCategoryData(String cdata){
		this.categoryData.sendKeys(cdata,Keys.RETURN);
	}
	
	public void clickCategoryList(){
		this.categoryList.click();
	}
	
	public void clickSubmitCourse(){
		this.submitCourse.click();
	}
	
	public void giveCode(String c){
		this.code.sendKeys(c);
	}
	
	
	public void giveTitle(String ttl){
		this.title.sendKeys(ttl);
	}
	
	public void clickAddCourse(){
		this.addCourse.click();
	}
	
	public void clickAddButton(){
		this.addButton.click();
	}
	
	public void selectRadioCourse(){
		this.radioCourse.click();
	}
	
	
	public void giveCategoryName(String nm){
		this.categoryName.sendKeys(nm);
	}
	
	public void giveCategoryCode(String cod){
		this.categoryCode.sendKeys(cod);
	}
	
	public void clickAdminTab(){
		this.adminTab.click();
	}
	
	public void clickCourseCategory(){
		this.courseCategory.click();
	}
	
	public void clickAddCategory(){
		this.addCategory.click();
	}
	
	
}
