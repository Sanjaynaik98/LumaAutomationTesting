package LUMA.Luma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shopping {
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
	@Test(priority = 2)
	public void selection() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//span[text()='Men'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Tops']")).click();
		driver.findElement(By.xpath("(//div[@class='filter-options-title'])[1]")).click();
		driver.findElement(By.xpath("//li[@class='item']//a[contains(text(),'Hoodies')]")).click();
		driver.findElement(By.xpath("(//span[@class='product-image-wrapper']//img[@class='product-image-photo'])[6]")).click();
		driver.findElement(By.xpath("//div[@option-id='169']")).click();
		driver.findElement(By.xpath("//div[@option-id='51']")).click();
		WebElement Quantity1 = driver.findElement(By.xpath("(//div[@class='control'])//input[@id='qty']"));
		Quantity1.clear();
		Quantity1.sendKeys("2");
		driver.findElement(By.xpath("(//div[@class='actions'])//button[@title='Add to Cart']")).click();
		WebElement search = driver.findElement(By.xpath("//div[@class='field search']//input[@id='search']"));
		search.click();
		search.sendKeys("Aether Gym Pant");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='actions']//button[@title='Search']")).click();
		driver.findElement(By.xpath("(//img[@class='product-image-photo'])[1]")).click();
		driver.findElement(By.xpath("//div[@option-label='36']")).click();
		driver.findElement(By.xpath("//div[@option-id='50']")).click();
		WebElement Quantity2 = driver.findElement(By.xpath("(//div[@class='control'])//input[@id='qty']"));
		Quantity2.clear();
		Quantity2.sendKeys("2");
		driver.findElement(By.xpath("(//div[@class='actions'])//button[@title='Add to Cart']")).click();	
	}
	@Test(priority = 3)
	public void cart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='action showcart'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='primary']//button[text()='Proceed to Checkout']")).click();
		//firstname
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstname.clear();
		firstname.sendKeys("Sanjay");
		//lastname
		WebElement lastname=driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.clear();
		lastname.sendKeys("Naik");
		//company details
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Kodnest");
		//stree address
		driver.findElement(By.xpath("(//input[@name='street[0]'])[1]")).sendKeys("Hoodi");
		//city
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bangalore");
		//automating dropdown box
		WebElement state = driver.findElement(By.xpath("//select[@name='region_id']"));
		Select se1=new Select(state);
		se1.selectByVisibleText("Indiana");
		//postal code
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("12345-6789");
		//automating dropdown box
		WebElement country = driver.findElement(By.xpath("//select[@name='country_id']"));
		Select se2=new Select(country);
		se1.selectByIndex(10);
		//phonenumber
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("1234567899");
		//radio button
		driver.findElement(By.xpath("//input[@name='ko_unique_1']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	}
	@Test(priority = 4)
	public void payment() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		//placing the order
		driver.findElement(By.xpath("//div[@class='primary']//following-sibling::button[@title='Place Order']")).click();
		//viewing order placed messsage
		boolean OrderPlacedmsg=driver.findElement(By.xpath("//span[contains(text(),'Thank')]")).isDisplayed();
		Assert.assertTrue(OrderPlacedmsg);
	}
	@AfterTest
	public void quit() {
	driver.quit();
	}
}
