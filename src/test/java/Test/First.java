package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class First {
	
	@Test
	public void login() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).sendKeys("chitra.menon1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("hello");
		driver.findElement(By.id("send2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
		String msg=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
		System.out.println(msg);
		if(msg.equals("Invalid login or password.")) {
			
			System.out.println("Test Case passed");
			
		}
		driver.quit();
	}



       @Test
      public void register() {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(driver,30);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://magento.com");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")));
	driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.xpath("//*[@id=\"register\"]/span")).click();
	driver.findElement(By.id("firstname")).sendKeys("Chitra");
	driver.findElement(By.id("lastname")).sendKeys("Menon");
	driver.findElement(By.id("email_address")).sendKeys("chitra.menon1@gmail.com");
	
	
	 Select cp=new Select(driver.findElement(By.id("company_type")));
	 cp.selectByIndex(3);
	
	 Select role=new Select(driver.findElement(By.id("individual_role")));
	 role.selectByValue("technical/developer");
	 
	 Select country=new Select(driver.findElement(By.id("country")));
	 country.selectByValue("AL");
	 
	 
	    driver.findElement(By.id("password")).sendKeys("hello");
		driver.findElement(By.id("password-confirmation")).sendKeys("hello");
		driver.findElement(By.id("agree_terms")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"msp-recaptcha-d84b65fc916e7398083ea5f17089d8f1\"]/div/div/iframe")));
		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));
		driver.switchTo().defaultContent();
		
		
		
	 
	if(driver.findElement(By.id("agree_terms")).isSelected()){
		
		driver.findElement(By.id("agree_terms")).click();
	}
	
	driver.quit();
}
}


     