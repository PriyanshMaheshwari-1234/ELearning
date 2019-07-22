package com.training.pom;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePagePOM {
private WebDriver driver; 
static int b=0;



	
	public HomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Homepage')]")
	private WebElement homeScreen;
	
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement catalog;
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement myCourses;
	
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement loggingOut;
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[5]")
	private WebElement loggingOut2;
	
	public void getOut() throws InterruptedException{
		
		this.loggingOut.click();
		Thread.sleep(3000);
		this.loggingOut2.click();
		
	}
	
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void pressHome(){
		this.homeScreen.click();
	}
	
	 public void pressCatalog(){
		 this.catalog.click();
	 }
	 
	 public void clickMyCourses(){
		 this.myCourses.click();
	 }
	 
	 public void selectedCourse(WebDriver driver){
			List<WebElement> courses= driver.findElements(By.xpath("//h4[@class='course-items-title']"));
			 int num=courses.size();
			 System.out.println(num);
			 for( int m=0;m<num;m++){
		       	 
			       WebElement data1=courses.get(m);
			       	//System.out.println(data);
			       if (data1.isDisplayed()){
			       	System.out.println("present: "+data1.getText());
			       	
			       }
			      
			       }
		 }
	 
	 
	 public void displayCheck(WebDriver driver)
		{
			
			
			List<WebElement> listOfElements = driver.findElements(By.xpath("//h4[@class='title']"));
	        int size= listOfElements.size();
	        System.out.println(size);
	        b=b+size;
	        for( int i=0;i<size;i++){
	       	 
	       WebElement data=listOfElements.get(i);
	       	//System.out.println(data);
	       if (data.isDisplayed()){
	       	System.out.println("present: "+data.getText());
	       	
	       }
	      
	       }
	        System.out.println("Number of courses available are: "+b);
		}
	
	 
	 public void countAvailableCourses() throws InterruptedException{
		 for(int j=2;j<=10;j++){
				int er=j;
				String rt=Integer.toString(er);
				driver.findElement(By.xpath("//ul[@class='pagination']//a[text()=  '"+rt+"' ]")).click();
				Thread.sleep(2000);
			   displayCheck(driver);	  }
	 }
	
}
