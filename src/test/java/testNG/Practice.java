package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	
    @Test
	public void Testgoogle() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	driver.findElement(By.id("APjFqb")).sendKeys("testng",Keys.ENTER);
	System.out.println(driver.getTitle());
	driver.quit();
	}
    @Test
    public void testfacebook() throws Exception {
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.facebook.com/");
    	driver.findElement(By.id("email")).sendKeys("vyshu",Keys.ENTER);
    	System.out.println(driver.getTitle());
    	Thread.sleep(2000);
    	driver.close();
    }

}
