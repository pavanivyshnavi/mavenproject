package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Abhibus {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.abhibus.com/");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	String usermonth="December";
	String useryear="2023";
	String userday="26";
	
	driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("hyd");
	driver.findElement(By.xpath("//div[text()='Hyderabad']")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("bangl");
	driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='Onward Journey Date']")).click();
	
	while(true) {
		
	String month_year=driver.findElement(By.xpath("//div[@class=' col'][@style='text-align: center;']")).getText();
	
	String[] monyear_split=month_year.split(" ");
	String month=monyear_split[0];
	String year=monyear_split[1];
	
	if(month.equals(usermonth) && year.equals(useryear)) {
		break;
		
	}else {
		driver.findElement(By.xpath("//span[@class='calender-month-change']")).click();
	}

	}
	
	List<WebElement> dates=driver.findElements(By.xpath("//span[@style='grid-column: auto;']"));
	for(WebElement date:dates) {
		
		if(date.getText().equals(userday)) {
	     date.click();
		}
	}
	

}
}