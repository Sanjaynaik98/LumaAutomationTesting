package LUMA.Luma;

import java.time.Duration;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
	}@Test(priority = 1)
	public void login() {
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sanju@gmail.com");
		driver.findElement(By.xpath("(//input[@id='pass'])[1]")).sendKeys("Sanjay123@");
		driver.findElement(By.xpath("(//span[contains(text(),'Sign In')])[1]")).click();	
		boolean welcomemsg=driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[1]/span[1]")).isDisplayed();
		Assert.assertTrue(welcomemsg);
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
	
}
