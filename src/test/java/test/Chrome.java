package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {

	public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver",
      "C:\\Users\\admin\\eclipse-workspace\\mavenproject\\chromedriver.exe");
    
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getWindowHandles());
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
    //driver.findElement(By.xpath("//h5[text()='Login']"));
    driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin123");
    driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    Thread.sleep(5000);
    driver.navigate().back();
    Thread.sleep(3000);
    driver.navigate().forward();
    //Thread.sleep(3000);
    System.out.println(driver.getWindowHandle());
    driver.close();
	}

}
