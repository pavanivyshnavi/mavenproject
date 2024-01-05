package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datavalidation {
@Test(dataProvider = "usercredentials",dataProviderClass = Excel.class)
public void LoginFunctionality(String username,String password) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://empirehome.myprojectsonline.co.in/");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(username);
	driver.findElement(By.id("pword")).sendKeys(password);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	String url=driver.getCurrentUrl();
	Assert.assertEquals(url,"http://empirehome.myprojectsonline.co.in/EmpireHome/Dashboard");
	
}
}
