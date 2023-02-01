package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowElement {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("http://watir.com/examples/shadow_dom.html");
		/*
		 * WebElement shadowHost=driver.findElement(By.xpath("//div[@id='shadow_host']"));
		 * SearchContext shadowRoot = shadowHost.getShadowRoot();
		 * System.out.println(shadowRoot.findElement(By.cssSelector("span[class='info']")).getText());
		 * 
		 * WebElement shadowNestedHost=shadowRoot.findElement(By.cssSelector("div[id='nested_shadow_host']")); 
		 * SearchContext nestedShadowRoot = shadowNestedHost.getShadowRoot();
		 * System.out.println(nestedShadowRoot.findElement(By.cssSelector("#nested_shadow_content > div")).getText());
		 */
        //System.out.println(expandRootElement(driver.findElement(By.xpath("//div[@id='shadow_host']"))).getText());
        
        SearchContext shadowRoot = expandRootElement(driver.findElement(By.xpath("//div[@id='shadow_host']")));
        System.out.println(shadowRoot.findElement(By.cssSelector("span[class='info']")).getText());
	}
	
	
	  public static SearchContext expandRootElement(WebElement element) {
	
		  SearchContext ele = (SearchContext) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element); 
		  return ele; }
	 

}
