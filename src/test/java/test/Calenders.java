package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenders {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String usermonth="September";
		String useryear="2023";
		String userdate="18";
		
		driver.findElement(By.id("first_date_picker")).click();
		while(true){
		String month_year=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String[] monyearsplit=month_year.split(" ");
		String month=monyearsplit[0];
		String year=monyearsplit[1];
		if(month.equals(usermonth) && year.equals(useryear)) {
			break;
		}
		else {
			driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
		}

	}
		List<WebElement> dates=driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		for(WebElement date:dates) {
			if(date.getText().equals(userdate)) {
				date.click();
			}
		}
	}

}
