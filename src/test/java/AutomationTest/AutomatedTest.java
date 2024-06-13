package AutomationTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomatedTest {

	public static void main(String[] args) throws Throwable {
	
		System.setProperty("webdriver.chromedriver.driver", "D://Java//automate//chromedriver.exe");
		
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get ("https://www.facebook.com/");
		
		
		
		Thread.sleep(1000);
		
		driver.manage().window().maximize();
		
		 WebElement forgotpassword=driver.findElement(By.xpath("//a[normalize-space()='Forgot password?']"));
		
	forgotpassword.click();
		
	
	/*WebDriverWait wait=new WebDriverWait(forgotpassword. 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""));
	*/
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	
	
	for (WebElement link : links) {
	String url = link.getAttribute("href");
	
	
	CheckLinks(url);
	
	
	
	} driver.quit(); }
	
	
	
	public static void CheckLinks(String url) {
		
		try {
			URL link = new URL(url);
			HttpURLConnection URLConnection = (HttpURLConnection) link.openConnection();
			URLConnection.setConnectTimeout(3000); 
			URLConnection.connect();
			
			if (URLConnection.getResponseCode() == 200) {
				System.out.println(url+ URLConnection.getResponseMessage());
			}else {
				System.out.println(url+ URLConnection.getResponseMessage() + "=" +"is kaput");
		
			}
			} catch(Exception sicis) {
				System.out.println(url+ "=" +  "sicis");
				
				
			}
		
		

	/*List<WebElement> links = driver.findElements(By.tagName("a"));

	//Iterating each link and checking the response status
	for (WebElement link : links) {
	String url = link.getAttribute("href");

	verifyLink(url);
	}

	//driver.quit();
	}

	public static void verifyLink(String url) {
	try {
	URL link = new URL(url);
	HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
	httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
	httpURLConnection.connect();


	if (httpURLConnection.getResponseCode() == 200) {
	System.out.println(url + " - " + httpURLConnection.getResponseMessage());
	} else {
	System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
	}
	} catch (Exception e) {
	System.out.println(url + " - " + "is a broken link");
	}
	}
		
		/* WebElement username=driver.findElement(By.id("email"));
		
		username.sendKeys("candecdeli7@gmail.com");
		
		WebElement Password=driver.findElement(By.id("pass"));
		
		Password.sendKeys("");
		
		Thread.sleep(1000);
		
		WebElement button=driver.findElement(By.name("login"));
		
		button.click();
		
		Thread.sleep(1000);
		
		WebElement create=driver.findElement(By.xpath("//div[@aria-label='Create']"));
		
        create.click();

		*/
		

}
}
