package frames;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/windows");

		driver.findElement(By.xpath("//a[text() ='Click Here']")).click();

		String originalWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {

			if (!window.equals(originalWindow)) {

				driver.switchTo().window(window);

				break;
			}
		}

		String pageText = driver.findElement(By.tagName("h3")).getText();

		if (pageText.contains("New Window")) {

			System.out.println("Verification PASSED: Found text 'New Window'.");

		} else {
			System.out.println("Verification FAILED: Text not found.");
		}

		driver.close();

		System.out.println("Closed new window.");

		driver.switchTo().window(originalWindow);

		System.out.println("Switched back to original window.");

		if (driver.getTitle().contains("The Internet")) {
			System.out.println("Original window is active");
		} else {
			System.out.println("Original window is NOT active");
		}

		driver.quit();
		System.out.println("Browser closed.");
	}

}
