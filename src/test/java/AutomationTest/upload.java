package AutomationTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class upload {

	public static void main(String[] args) {
		

	
System.setProperty("webdriver.chromedriver.driver", "D://Java//automate//chromedriver.exe");
		
		
		
		WebDriver driver1=new ChromeDriver();
		
		driver1.get ("https://www.demo.guru99.com/test/upload/");
		
		
		driver1.manage().window().maximize();
		
		
		WebElement choosefile=driver1.findElement(By.xpath("//input[@id='uploadfile_0']"));
		
		choosefile.sendKeys("D:\\selenium-java-3.141.59 (1)");
		
		WebElement acceptbutton=driver1.findElement(By.xpath("//input[@id='terms']"));

		acceptbutton.click();
		
		WebElement submitbutton=driver1.findElement(By.xpath("//button[@id='submitbutton']"));
		
		submitbutton.click();
		
		try {
			
			WebDriverWait wait=new WebDriverWait(driver1, Duration.ofSeconds(10));
		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//center[normalize-space()='1 file has been successfully uploaded.']")));
		
		String messageText = successMessage.getText().trim().replaceAll("\\s+", " ");
		
		if (messageText.contains("1 file has been successfully uploaded.")) {
		    System.out.println("success");
		}else {
			System.out.println("not a success");
		}
		}catch (Exception e) {
			System.out.println("also not a success");
		}
		
		
	}

}
