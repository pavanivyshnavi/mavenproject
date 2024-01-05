package test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		List<WebElement> countries=driver.findElements(By.xpath("//table[@id='countries']//tr//td[@style='width: 134.667px;']"));
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='hasVisited']"));
		
		for(int i=1;i<countries.size();i++) {
			
			if(countries.get(i).getText().equalsIgnoreCase("India")) {
			checkboxes.get(i).click();
		}
		
	}
	}
}
