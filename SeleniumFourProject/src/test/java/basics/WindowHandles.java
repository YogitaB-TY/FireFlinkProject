package basics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/User/Downloads/MultipleWindow.html");
		driver.manage().window().maximize();
		String windowHandle= driver.getWindowHandle();
		System.out.println(windowHandle);
		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		Thread.sleep(3000);
		Set<String> windowHandles= driver.getWindowHandles();
		for(String handle:windowHandles) {
			//System.out.println(handle);
			driver.switchTo().window(handle);
			if(driver.getTitle().contains("Olive")) {
				driver.close();
			}
		}
	}

}
