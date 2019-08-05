package com.training.generics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ApplicationMethods {
WebDriver driver ; 
static int b=0;
	
	public ApplicationMethods(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this);
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
