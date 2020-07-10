package automationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Open_Email {
	
	public static void main(String[] args) throws InterruptedException {
		
		// Create a new Firefox webdriver
		// WebDriver foxy = new FirefoxDriver();
		WebDriver chrome = new ChromeDriver();
		
		// Run script
		// openemail(foxy);
		openemail(chrome);
		
		// Pause 5 seconds
		Thread.sleep(5000);
		
		// Quit
		// foxy.quit();
		chrome.quit();
		
	}

	public static void openemail(WebDriver driver) throws InterruptedException {

		// Set login parameters
		String email = "dougtest2017";
		String password = "dougisbest";
		
		// Login to gmail
		Login.login(driver, email, password);
		
		// Pause 5 sec
		Thread.sleep(5000);
		
		// Click on first email
		List<WebElement> elements = driver.findElements(By.cssSelector("div.xS"));
		if(elements.isEmpty()) {
			System.out.println("List is empty");
		} else {
			elements.get(0).click();
		}
		
		// Pause 5 sec
		Thread.sleep(5000);
		
		// Click on back button
		driver.findElement(By.cssSelector("div[act='19']")).click();

	}

}
