package com.browserstack;

import java.util.Random;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.Test;

public class BStackDemoTest extends SeleniumTest {
	

	
	@Test
	public void loginWithValidCredential() throws Exception {

		// WebDriverManager.chromedriver().setup();

	
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Logo']"));
		Assert.assertTrue(logo.isDisplayed(), "Logo is displayed");
		driver.findElement(By.id("email-address-id")).sendKeys("salmanqc@yahoo.com");
		driver.findElement(By.id("password-id")).sendKeys("Amarr@123");
		driver.findElement(By.xpath("(//button[span[contains(text(),'LOGIN')]])[3]")).click();
		Thread.sleep(5000);
		String accountName = driver
				.findElement(By.xpath("//div[@class='row body-text2 profile-view']/div[contains(text(),'')][2]"))
				.getText();
		Assert.assertEquals(accountName, "salman karim");
		String garageDoor = driver.findElement(By.xpath("(//a[@aria-label='Garage Doors'])[1]")).getText();
		Assert.assertEquals(garageDoor, "Garage Doors");
		String home = driver.findElement(By.xpath("(//a[@aria-label='Home'])[1]")).getText();
		Assert.assertEquals(home, "Home");
		String doorDesign = driver.findElement(By.xpath("(//a[@aria-label='Design Your Door'])[1]")).getText();
		Assert.assertEquals(doorDesign, "Design Your Door");
		String photoGallery = driver.findElement(By.xpath("(//a[@aria-label='Photo Gallery'])[1]")).getText();
		Assert.assertEquals(photoGallery, "Photo Gallery");
		String otherProducts = driver.findElement(By.xpath("(//a[@aria-label='Other Products'])[1]")).getText();
		Assert.assertEquals(otherProducts, "Other Products");
		String videos = driver.findElement(By.xpath("(//a[@aria-label='Videos'])[1]")).getText();
		Assert.assertEquals(videos, "Videos");
		String aboutUs = driver.findElement(By.xpath("(//a[@aria-label='About Us'])[1]")).getText();
		Assert.assertEquals(aboutUs, "About Us");
		String contactUS = driver.findElement(By.xpath("(//a[@aria-label='Contact Us'])[1]")).getText();
		Assert.assertEquals(contactUS, "Contact Us");
		String oderNow = driver.findElement(By.xpath("(//a[@aria-label='ORDER NOW'])[1]")).getText();
		Assert.assertEquals(oderNow, "ORDER NOW");
	}
	
	@Test
	public void loginWithInvalidCredentials() throws InterruptedException {
		
	
		driver.findElement(By.id("email-address-id")).sendKeys("karimqc@yahoo.com");
		driver.findElement(By.id("password-id")).sendKeys("Amarr@123");
		driver.findElement(By.xpath("(//button[span[contains(text(),'LOGIN')]])[3]")).click();
		
		Thread.sleep(3000);
		String errorMsg = driver.findElement(By.xpath("//span[contains(text(),'- Please')]")).getText();
		Assert.assertEquals(errorMsg, "- Please check your email and password and try again.");
	}
	
	@Test
	public void accountCreation() throws InterruptedException {
		driver.findElement(By.xpath("//a[@aria-label='User Account Button']")).click();
		driver.findElement(By.xpath("(//a[@href=\"/us/en/signup\"]/button/span[contains(text(),'UP')])[1]")).click();
		driver.findElement(By.id("first-name-id")).sendKeys("Mark");
		driver.findElement(By.id("last-name-id")).sendKeys("Bejos");
		driver.findElement(By.id("phone-number-id")).sendKeys(generateRandomPhoneNumber());
	
		
		driver.findElement(By.id("email-address-id")).sendKeys("markbejos"+generateRandomPhoneNumber()+ "@gmail.com");
		
		driver.findElement(By.id("password-id")).sendKeys("Mark&bejos");
		
		driver.findElement(By.id("re-enter-password-id")).sendKeys("Mark&bejos");
		driver.findElement(By.xpath("//button/span[text()='CREATE']")).click();
		//tikmark img  xpath (//img[@loading='lazy'])[3] 
		// Accoutn created text
		Thread.sleep(5000);
	    boolean tikMarkVisible=	driver.findElement(By.xpath("(//img[@loading='lazy'])[3]")).isDisplayed();
	    Assert.assertTrue(tikMarkVisible, "Account created tikmark Image is displaying");
	    String msg= driver.findElement(By.xpath(" //h4[contains(text(),'Account')]")).getText();
	    Assert.assertEquals(msg, "Account Created!");
	}
	
    private String generateRandomPhoneNumber() {
        Random random = new Random();
        // Generate a random number between 1000000000 and 9999999999
        long randomLong = 1000000000L + (long) (random.nextDouble() * 8999999999L);
        return String.valueOf(randomLong);
    }
}
