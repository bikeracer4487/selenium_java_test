package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Send_Email {
	
	public static void main(String[] args) throws InterruptedException {
		
		// Create a new Firefox webdriver
		WebDriver foxy = new FirefoxDriver();
		WebDriver chrome = new ChromeDriver();
		
		// Run script
		sendemail(foxy);
		sendemail(chrome);
		
		// Pause 5 seconds
		Thread.sleep(5000);
		
		// Quit
		foxy.quit();
		chrome.quit();
		
	}

	public static void sendemail(WebDriver driver) throws InterruptedException {

		// Set login parameters
		String email = "dougtest2017";
		String password = "dougisbest";
		
		// Set timeouts
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// Login to gmail
		Login.login(driver, email, password);
		
		// Pause 5 sec
		Thread.sleep(5000);
		
		// Click Compose button
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		
		// Enter recipient address
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='to']")));
		driver.findElement(By.cssSelector("textarea[name='to']")).sendKeys("photodoug4487@gmail.com");
		driver.findElement(By.cssSelector("input[name='subjectbox']")).sendKeys("PREPARE TO BE SPAMMED");
		driver.findElement(By.cssSelector("div[role='textbox']")).click();
		driver.switchTo().activeElement().sendKeys("It's just for a day or two. Please don't report me...");
		
		// Pause 5 seconds
		Thread.sleep(5000);
		
		// Hit Send button
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

}
