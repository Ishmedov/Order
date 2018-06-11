package com.weborder;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pena\\Documents\\Selenium Dependencies\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		//Thread.sleep(10000);//USer name
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		//Thread.sleep(10000);
		//password
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		//click login
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();// 
		//4. Verify URL:
		//navigate to order
		driver.navigate().to("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
		//Quantity random number
		String rndmNum = (int)((System.currentTimeMillis() % 100)+1)+"";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(rndmNum);
		//Costumer name
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("12345");
//		Street
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
//		City
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
//		state
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
//		zipcode
		String zipcode = (int)(System.currentTimeMillis() % 100000)+"";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipcode);
//		driver.findElement(By.name("pwd")).sendKeys("12345");
//		driver.findElement(By.name("pwd")).sendKeys("12345");
//		driver.findElement(By.name("pwd")).sendKeys("12345");
//		driver.findElement(By.name("pwd")).sendKeys("12345");
		
		
		String expected1 = "cybertekschool.";
		// 5.this getCurrentUrl method gets the url of website.
		String actual1 = driver.getCurrentUrl();
		//System.out.println(actual1);
		//http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx

//		
		
	String[] middleName= {"Ken", "Fikri","Mike", "Ali","Ken", "Fikri","Mike", "Ali"};
    int midName = (int)(System.currentTimeMillis() % 10);
    String name="John " +middleName[midName]+" Smith";
    driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("name");
    int cardSelect = (int) (System.currentTimeMillis() % 10);
	 List <WebElement> options=driver.findElements(By.xpath("//*[starts-with(@id, 'ctl00_MainContent_fmwOrder_cardList')]"));
	Random random = new Random();
	int index = random.nextInt(options.size());
	options.get(index).click();

	long randV = (long) (Math.random() * 10000000000000L);
	long visa = 4000000000000000L + randV;

	long randM = (long) (Math.random() * 10000000000000L);
	long master = 5000000000000000L + randM;

	long randA = (long) (Math.random() * 10000000000000L);
	long amex = 3000000000000000L + randA;

	if (index == 1) {
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(String.valueOf(visa));

	} else if (index == 2) {
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(String.valueOf(master));

	} else {
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(String.valueOf(amex));

	}
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("02/19");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	
	String actual = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText();
	String expected ="New order has been successfully added.";
	
	if(actual.equals(expected)) {
		System.out.println("passed");
	}else {
		System.out.println("failed");
	}
	Thread.sleep(10000);
}


}