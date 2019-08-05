package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondPOM {
private WebDriver driver; 
	
	public SecondPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@name='submitAuth']")
	private WebElement loginBttn; 
	
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement catalog;
	
	@FindBy(xpath="//div[@class='input-group-btn']/button")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement search;
	
	@FindBy(xpath="//a[contains(@class,'btn btn-lg btn-success btn-block')]")
	private WebElement subscribe;
	
	@FindBy(id="istooldesc_2969")
	private WebElement assignment;
	
	@FindBy(linkText="hands on exercises")
	private WebElement handsOn;
	
	@FindBy(xpath="//a[@class='btn-toolbar']")
	private WebElement uploadAssign;
	
	@FindBy(id="istooldesc_2967")
	private WebElement groups;
	
	@FindBy(linkText="rockers")
	private WebElement rockers;
	
	@FindBy(xpath="//img[@title='Chat']")
	private WebElement chat;
	
	@FindBy(xpath="//*[@id='tab1']/div/div[1]/div")
	private WebElement chatText;
	
	@FindBy(id="chat-send-message")
	private WebElement sendMSG;
	
	@FindBy(id="istooldesc_2964")
	private WebElement forum;
	
	@FindBy(xpath="//img[@title='Create thread']")
	private WebElement createThread;
	
	@FindBy(id="thread_post_title")
	private WebElement textValue;
	
	@FindBy(xpath="//html[@dir='ltr']//body")
	private WebElement bodyText;
	
	@FindBy(id="thread_SubmitPost")
	private WebElement submitPost;
	
	@FindBy(xpath="//a[@title='Reply to this message']")
	private WebElement reply;
	
	
	
	public void clickReply(){
		this.reply.click();
	}
	
	public void clickSubmitPost(){
		this.submitPost.click();
	}
	
	public void giveBodyText(String body){
		this.bodyText.sendKeys(body);
	}
	
	public void giveTextValue(){
		this.textValue.sendKeys("text");
	}
	
	public void clickCreateThread(){
		this.createThread.click();
	}
	
	public void clickForum(){
		this.forum.click();
	}
	
	public void clickSendMSG(){
		this.sendMSG.click();
	}
	
	public void chatTextValue(){
		this.chatText.sendKeys("hello");
	}
	
	public void clickChat(){
		this.chat.click();
	}
	
	
	
	public void clickRockers(){
		this.rockers.click();
	}
	
	public void clickGroups(){
		this.groups.click();
	}
	
	public void clickUploadAssign(){
		this.uploadAssign.click();
	}
	
	public void clickHanhsOn(){
		this.handsOn.click();
	}
	
	public void clickAssgignment(){
		this.assignment.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBttn() {
		this.loginBttn.click(); 
	}
	
	public void pressCatalog(){
		 this.catalog.click();
	 }
	
	public void clickSearch(){
		this.searchButton.click();
	}
	
	public void openSelected(String data1){
		driver.findElement(By.linkText(data1)).click();
}
	public void searchCourse(String data)
	{
		this.search.sendKeys(data);
	}
	
	public void subscribeClick(){
		this.subscribe.click();
	}
	 public void switchWindow(){
		 for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
		 }
	 
	 public void scrollDown(WebElement location){
		 JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", location);
		 
	 }
}
