package IBM.automation_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class retail_1 {
	
	WebDriver driver;
	@BeforeMethod
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/admin");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		
	}
	
	//Order Module
	
	@Test
	public void select_order_id(){
		
		driver.findElement(By.xpath("//*[@id='menu-sale']")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("//div[@class='form-group']/input")).sendKeys("474");
		
		driver.findElement(By.id("button-filter")).click();
		driver.findElement(By.xpath("//*[@class='col-sm-4']/button")).click();
		
		String actual = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
		String expected = "474";
		Assert.assertEquals(expected, actual);
		System.out.println("The order ID is displayed");
		
	}
	
	
	@Test
	public void select_customer_name(){
		
		driver.findElement(By.xpath("//*[@id='menu-sale']")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("//div[@class='form-group']/input[@id='input-customer']")).sendKeys("Krishna Mohan");
		
		driver.findElement(By.id("button-filter")).click();
		driver.findElement(By.xpath("//*[@class='col-sm-4']/button")).click();
		
		
		String actual = driver.findElement(By.xpath("//tbody/tr/td[3]")).getText();
		String expected = "Krishna Mohan";
		Assert.assertEquals(expected, actual);
		System.out.println("The Customer name is displayed");
		
	}
	
	@Test
	public void select_total(){
		
		driver.findElement(By.xpath("//*[@id='menu-sale']")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("//div[@class='form-group']/input[@id='input-total']")).sendKeys("Rs.85");
		
		driver.findElement(By.id("button-filter")).click();
		driver.findElement(By.xpath("//*[@class='col-sm-4']/button")).click();
		
		String actual = driver.findElement(By.xpath("//tbody/tr/td[4]")).getText();
		String expected = "Rs.85";
		Assert.assertEquals(expected, actual);
		System.out.println("The Total is displayed");
		
	}
	
	@Test
	public void select_mail_option()
	{
		try
		{
		driver.findElement(By.xpath("//*[@id='menu-marketing']")).click();
		driver.findElement(By.xpath("//li[@id='menu-marketing']/ul/li[4]/a")).click();
		String expected = "Mail";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		System.out.println("The mail option selected successfully");
		}
		catch(Exception e)
		{
			System.out.println("An error occoured : "+e);
		}
	}
	
	
	//Product Returns
	
	@Test
	public void select_return_id(){
		
		driver.findElement(By.xpath("//*[@id='menu-sale']")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']/ul/li[3]/a")).click();
		
		driver.findElement(By.xpath("//*[@class ='form-group']/input")).sendKeys("485");
		
		driver.findElement(By.xpath("//*[@class ='col-sm-3']/button")).click();
		
		String actual = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
		String expected = "485";
		
		Assert.assertEquals(expected, actual);
		System.out.println("The Return Id is displayed");
		
		
	}
	
	@Test
	public void select_model(){
		
		driver.findElement(By.xpath("//*[@id='menu-sale']")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']/ul/li[3]/a")).click();
		
		driver.findElement(By.xpath("//*[@id = 'input-model']")).sendKeys("voltas");
		
		driver.findElement(By.xpath("//*[@class ='col-sm-3']/button")).click();
		
		String actual = driver.findElement(By.xpath("//table/tbody/tr/td[6]")).getText();
		String expected = "voltas";
		
		Assert.assertEquals(expected, actual);
		System.out.println("The Model Name is displayed");
		
		
	}
	
	@Test
	public void select_product(){
		
		driver.findElement(By.xpath("//*[@id='menu-sale']")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']/ul/li[3]/a")).click();
		
		driver.findElement(By.xpath("//*[@id = 'input-product']")).sendKeys("ac");
		
		driver.findElement(By.xpath("//*[@class ='col-sm-3']/button")).click();
		
		String actual = driver.findElement(By.xpath("//table/tbody/tr/td[5]")).getText();
		String expected = "ac";
		
		Assert.assertEquals(expected, actual);
		System.out.println("The Product Name is displayed");
		
		
	}
	
	
	@AfterMethod
	public void close(){
		driver.quit();
	}
	
	

}
