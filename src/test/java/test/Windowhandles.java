package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandles {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		String parentwindow = driver.getWindowHandle();
		System.out.println("parent window id is:" + parentwindow);
		driver.findElement(By.xpath("//span[text()='Help']")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		for (String two_windows : windows) {
			if (!parentwindow.equals(two_windows)) {
				driver.switchTo().window(two_windows);
				driver.findElement(By.xpath("//i[@class='icon-close']")).click();
			}
		}
		driver.findElement(By.xpath("//a[text()='Help']")).click();
		Set<String> three_windows = driver.getWindowHandles();
		System.out.println(three_windows);
		List<String> multiple_windows = new ArrayList<String>(three_windows);
		System.out.println("no. of windows opened:" + multiple_windows.size());

		if (multiple_windows.size() <= 3) {
			String third_window = multiple_windows.get(2);
			driver.switchTo().window(third_window);
			driver.findElement(By.xpath("//i[@class='icon-close']")).click();
		}
		driver.close();
	}
}
