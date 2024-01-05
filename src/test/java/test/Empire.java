package test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Empire {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://empirehome.myprojectsonline.co.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@title='Enter email / mobile number']"))
				.sendKeys("sureshbabuemp@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ZPMHQHIA");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//i[@class='fa fa-houzz']")).click();
		driver.findElement(By.xpath("//a[text()='All Inventory']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn btn-add']")).click();
		Thread.sleep(3000);

		WebElement category = driver.findElement(By.id("catDD"));
		Select s = new Select(category);
		s.selectByVisibleText("Chair");

		WebElement subcategory = driver.findElement(By.id("subcatDD"));
		Select se = new Select(subcategory);
		se.selectByIndex(1);

		driver.findElement(By.xpath("//input[@placeholder='Enter Model Number']")).sendKeys("901047688");
		driver.findElement(By.xpath("//textarea[@name='Title']")).sendKeys("Chair");
		driver.findElement(By.xpath("//textarea[@name='ItemDescription']")).sendKeys("black colour Chair");
		driver.findElement(By.xpath("//input[@name='Brand']")).sendKeys("vyshu");
		driver.findElement(By.xpath("//input[@name='Height']")).sendKeys("4'9");
		driver.findElement(By.xpath("//input[@name='Width']")).sendKeys("5");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Breadth']")).sendKeys("7");
		driver.findElement(By.xpath("//input[@name='ColorName']")).sendKeys("black");

		WebElement inventory = driver.findElement(By.id("InventoryStatusId"));
		Select st = new Select(inventory);
		st.selectByVisibleText("status");

		WebElement inventoryid = driver.findElement(By.id("InventoryConditonId"));
		Select select = new Select(inventoryid);
		select.selectByVisibleText("Very Good");

		WebElement inventorylocation = driver.findElement(By.id("InventoryLocationId"));
		Select sel = new Select(inventorylocation);
		sel.selectByVisibleText("hyderabad");

		driver.findElement(By.id("RecievedDate")).sendKeys("18-08-2020");
		driver.findElement(By.id("actual")).sendKeys("5000");

		WebElement factor = driver.findElement(By.id("factor"));
		Select sl = new Select(factor);
		sl.selectByValue("127");

		driver.findElement(By.id("mrp")).sendKeys("7000");
		driver.findElement(By.xpath("//input[@placeholder='Enter HSN code']")).sendKeys("HSN001");
		driver.findElement(By.xpath("//input[@placeholder='Enter Rack Name ']")).sendKeys("001");
		driver.findElement(By.xpath("//input[@placeholder='Enter Supplier Details']")).sendKeys("smitha");
		driver.findElement(By.xpath("//input[@placeholder='Enter Invoice Number']")).sendKeys("IN445578");
		driver.findElement(By.xpath("//input[@placeholder='Enter Qty ']")).sendKeys("5");
		Thread.sleep(3000);

		WebElement colorfile=driver.findElement(By.xpath("//input[@class='form-control'][@type='file']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", colorfile);//to click the file
		
		Robot rb=new Robot();
		rb.delay(3000);
		StringSelection ss=new StringSelection("C:\\Users\\admin\\Desktop\\vyshu marolix\\Selenium Full Material.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//copy to clipboard
		
		//ctrl+v action
		rb.keyPress(KeyEvent.VK_CONTROL);//press on ctrl key
		rb.keyPress(KeyEvent.VK_V);//ctrlv action
		rb.delay(3000);
		 
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(3000);
		
		//enter key
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
		WebElement doc=driver.findElement(By.xpath("//input[@type='file'][@name='DocumentsUploaded']"));
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", doc);
		doc.click();
		
		Robot r=new Robot();
		r.delay(3000);
		StringSelection str=new StringSelection("C:\\Users\\admin\\Desktop\\vyshu marolix\\Selenium Full Material.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		//ctrl+v action
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.delay(3000);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.delay(3000);
		
		//enter action
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		
	
		
		
		
		
		
	}

}
