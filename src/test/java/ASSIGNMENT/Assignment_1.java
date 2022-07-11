package ASSIGNMENT;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_1 {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

	}	 
	
	@Test
	//1.For RadioButton
	public void radiobutton()
	{
		 //Code to find Radio button with text Radio2 using XPath
        WebElement radio2=driver.findElement(By.xpath("//input[@value='radio2']"));
        radio2.click();
        Assert.assertEquals(true, radio2.isSelected()); 
         System.out.println(" radio buttton is selected");
         }
	
	@Test
	//2.For Drop Down Handling
	public void dropDown()
	{
		WebElement dropDown =driver.findElement(By.id("dropdown-class-example"));
	Select option3 =new Select(dropDown);
		option3.selectByValue("option3");
		
	}
	
	@Test
	//3. For Check box selection 
	public void checkBoxselection()
	{
	WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		checkBox.click();
		Assert.assertEquals("CheckBox is not selected", true, checkBox.isSelected());
		System.out.println("checkbox is selected");
	}

	
	@Test
	//4. For Switch to new browser window
	public void SwitchWindow() throws InterruptedException
	{
		
			WebElement OpenWindowClik = driver.findElement(By.xpath("//button[@id='openwindow']"));
			OpenWindowClik.click();
			System.out.println("Current Window Title (ParentWindow) is :-" + driver.getTitle());
			
			ArrayList<String>handles = new ArrayList<String>(driver.getWindowHandles());
			String ParentWindowID = handles.get(0);
			String ChildWindowID1 = handles.get(1);
			
			driver.switchTo().window(ChildWindowID1);
			System.out.println("Child Window Title is" + driver.getTitle());
			String Url = "http://www.qaclickacademy.com/";
			
			Assert.assertEquals("URL is not matching",Url, driver.getCurrentUrl());
			
			System.out.println("URL is  matching");
			driver.close();
			driver.switchTo().window(ParentWindowID);
	}
	
	@Test
	//5.For Alert Handling
	public void alertHandling() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hi");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Alert alt = driver.switchTo().alert();
		System.out.println("Text on alert popUp is: "+ alt.getText());
		Assert.assertEquals("Text is not matched", "Hello Hi, share this practice page and share your knowledge", alt.getText());
		alt.accept();
	System.out.println("Text -matched");
		
	}
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}

