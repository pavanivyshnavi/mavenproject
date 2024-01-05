package test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testingpractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("name")).sendKeys("vyshu");
		driver.findElement(By.id("email")).sendKeys("vyshu@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("8499393");
		driver.findElement(By.id("textarea")).sendKeys("45/5 area");
	
		List<WebElement> gender=driver.findElements(By.xpath("//input[@name='gender']"));
	    for(WebElement g:gender) 
		g.click();
	
	    
	    List<WebElement> days=driver.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']"));
	    for(WebElement d:days)
	    d.click();
		
	    driver.findElement(By.xpath("//option[@value='india']")).click();
	    driver.findElement(By.xpath("//option[@value='green']")).click();
	    driver.findElement(By.id("datepicker")).sendKeys("18/09/24");
		
		driver.findElement(By.xpath("//button[text()='Alert']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//button[text()='Prompt']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("vyshu");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		driver.close();

	}

}
