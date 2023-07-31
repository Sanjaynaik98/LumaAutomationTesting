package LUMA.Luma;

import java.time.Duration;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Register {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
	}
	@Test
	public void regiter() {
		driver.findElement(By.xpath("//div[@class='panel wrapper']//li[3]//a[1][text()='Create an Account']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sanjay");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Naik");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sanju@gmail.com");
		driver.findElement(By.xpath("//input[1][@title='Password']")).sendKeys("Sanjay123@");
		driver.findElement(By.xpath("//input[1][@title='Confirm Password']")).sendKeys("Sanjay123@");
		driver.findElement(By.xpath("//button//span[contains(text(),'Create an Account')]")).click();		
	}
	@AfterClass
	public void quit() {
		driver.quit();
	}
	}


