package test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggestions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("APjFqb")).sendKeys("selenium");
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='pcTkSc']//b"));
		System.out.println(options.size());

		for (WebElement autosuggestions : options) {
			System.out.println(autosuggestions.getText());
			if (autosuggestions.getText().contains("testing")) {
				autosuggestions.click();
				break;

			}
		}
		driver.close();

	}

}
