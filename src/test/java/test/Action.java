package test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Action {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement doubleclick = driver.findElement(By.xpath("//button[text()='Copy Text']"));

		Actions ac = new Actions(driver);
		ac.doubleClick(doubleclick).perform();

		WebElement source = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement destination = driver.findElement(By.id("droppable"));

		ac.dragAndDrop(source, destination).perform();

		WebElement rightclick = driver.findElement(By.xpath("//button[text()='New Browser Window']"));
		ac.contextClick(rightclick).perform();
		
		driver.close();

	}

}
