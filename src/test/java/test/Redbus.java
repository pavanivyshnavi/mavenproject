package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String user_month="Dec";
		String user_year="2023";
		String user_date="21";

		driver.findElement(By.xpath("//div[@class='sc-ifAKCX gLwVlD']//div//input[@id='src']")).sendKeys("hyd");
		driver.findElement(By.xpath("//li[@class='sc-iwsKbI jTMXri cursorPointing']")).click();
		
		driver.findElement(By.xpath("//div[@class='sc-ifAKCX gLwVlD']//div//input[@id='dest']")).sendKeys("bang");
		driver.findElement(By.xpath("//li[@class='sc-iwsKbI jTMXri cursorPointing']")).click();
		while(true) {
		driver.findElement(By.xpath("//div[@id='onwardCal']")).click();
		String month_year=driver.findElement(By.xpath("//div[text()='Dec']")).getText();
		String[] monthyearsplit=month_year.split(" ");
		String month=monthyearsplit[0];
		String year=monthyearsplit[1];
		if(month.equals(user_month) && (month.equals(user_year))) {
			break;
		}
		else {
			driver.findElement(By.id("Layer_1")).click();
		}
		}
		List<WebElement> dates=driver.findElements(By.xpath("//div//div[@class='DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj']"));
		for(WebElement date:dates) {
		if(date.getText().equals(user_date)) {
		date.click();
		
	}

	}
		}
	}

