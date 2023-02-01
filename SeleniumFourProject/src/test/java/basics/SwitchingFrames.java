package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/User/Downloads/iframe.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("(//img[contains(@alt,'Facebook')])[1]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Google']")).click();

	}

}
