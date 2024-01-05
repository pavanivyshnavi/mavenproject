package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge {

	 public static void main(String[] args) {
	System.setProperty("webdriver.edge.driver", 
		"C:\\Users\\admin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	WebDriver driver=new EdgeDriver();
	driver.get("https://www.instagram.com/?hl=en");
	driver.manage().window().maximize();
	System.out.println("title:"+ driver.getTitle());
	System.out.println("url:"+driver.getCurrentUrl());
	System.out.println("window handle id:"+driver.getWindowHandle());
	//System.out.println(driver.getPageSource());
	driver.findElement(By.xpath("//span[@class='_ap3a _aaco _aacw _aad0 _aad7']")).click();
	}
}
