package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Action1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trytestingthis.netlify.app/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@onclick='alertfunction()']")).click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		WebElement doubleclk = driver.findElement(By.xpath("//button[text()='Double-click me']"));
		Actions ac = new Actions(driver);
		ac.doubleClick(doubleclk).perform();
		Thread.sleep(3000);

		WebElement source = driver.findElement(By.id("drag1"));
		WebElement destination = driver.findElement(By.id("div1"));
		ac.dragAndDrop(source, destination).perform();
		Thread.sleep(3000);

		driver.close();

	}

}
