package frames;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2 {

	public static void main(String[] args) {

		        // Set up ChromeDriver (make sure chromedriver is in your PATH)
		        WebDriver driver = new ChromeDriver();

		        try {
		            // Open the URL
		            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		            driver.manage().window().maximize();
		            driver.get("http://the-internet.herokuapp.com/nested_frames");

		            // Verify Title
		            String expectedTitle = "Frames";
		            String actualTitle = driver.getTitle();
		            if (actualTitle.equals(expectedTitle)) {
		                System.out.println("Page title verification PASSED: " + actualTitle);
		            } else {
		                System.out.println("Page title verification FAILED. Found: " + actualTitle);
		            }

		            // Switch to top frame
		            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		            System.out.println("Switched to TOP frame.");

		            // Verify that there are 3 frames inside top frame
		            List<WebElement> frames = driver.findElements(By.tagName("frame"));
		            if (frames.size() == 3) {
		                System.out.println("Frame count verification PASSED: Found " + frames.size());
		            } else {
		                System.out.println("Frame count verification FAILED: Found " + frames.size());
		            }

		            // Switch to LEFT frame
		            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));
		            String leftText = driver.findElement(By.tagName("body")).getText();
		            if (leftText.contains("LEFT")) {
		                System.out.println("LEFT frame text verification PASSED");
		            } else {
		                System.out.println("LEFT frame text verification FAILED");
		            }

		            // Switch back to TOP frame
		            driver.switchTo().parentFrame();

		            // Switch to MIDDLE frame
		            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		            String middleText = driver.findElement(By.id("content")).getText();
		            if (middleText.contains("MIDDLE")) {
		                System.out.println("MIDDLE frame text verification PASSED");
		            } else {
		                System.out.println("MIDDLE frame text verification FAILED");
		            }

		            // Switch back to TOP frame
		            driver.switchTo().parentFrame();

		            // Switch to RIGHT frame
		            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));
		            String rightText = driver.findElement(By.tagName("body")).getText();
		            if (rightText.contains("RIGHT")) {
		                System.out.println("RIGHT frame text verification PASSED");
		            } else {
		                System.out.println("RIGHT frame text verification FAILED");
		            }

		            // Switch back to MAIN page (out of top frame)
		            driver.switchTo().defaultContent();

		            // Switch to BOTTOM frame
		            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));
		            String bottomText = driver.findElement(By.tagName("body")).getText();
		            if (bottomText.contains("BOTTOM")) {
		                System.out.println("BOTTOM frame text verification PASSED");
		            } else {
		                System.out.println("BOTTOM frame text verification FAILED");
		            }

		            // Switch back to MAIN page
		            driver.switchTo().defaultContent();

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // Close browser
		            driver.quit();
		        }
		    }

	}

