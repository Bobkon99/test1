package AutomationFramewrk;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
	public static void main(String args[]) throws IOException {


		System.out.println("Browser is Launched");
		//set the ChromeDriver path
		System.setProperty("webdriver.chrome.driver","C:\\Eclipseworkspace\\JavaLearn\\drivers\\chromedriver.exe");

		//Creating an object of ChromeDriver
		WebDriver driver = new ChromeDriver();

		//Navigate to the URL
		driver.navigate().to("https://demoqa.com/automation-practice-form");

		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
}
