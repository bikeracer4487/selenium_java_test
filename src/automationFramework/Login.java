package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		
		// Set login parameters
		String email = "dougtest2017";
		String password = "dougisbest";
		
		// Path to Gecko Driver
		// System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		
		// Create a new Firefox webdriver
		//WebDriver driver = new FirefoxDriver();
		WebDriver chrome = new ChromeDriver();
		
		// Login to gmail
		//login(driver, email, password);
		login(chrome, email, password);
		
		// Pause 5 sec
		Thread.sleep(5000);
		
		// Quit
		//driver.quit();
		chrome.quit();

	}
	
	public static void login(WebDriver driver, String email, String password){
		
		// Set Timeouts
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// Open gmail page
		driver.get("https://mail.google.com");
		
		// Enter email
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#identifierId")));
		driver.findElement(By.id("Email")).sendKeys(email);
		
		// Click next button
		driver.findElement(By.id("next")).click();
		
		// Enter password
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Passwd")));
		driver.findElement(By.id("Passwd")).sendKeys(password);
				
		// Click sign in button
		driver.findElement(By.id("signIn")).click();
		
	}

}
