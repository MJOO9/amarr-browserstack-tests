package com.browserstack;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
    public WebDriver driver;
  
    @BeforeMethod(alwaysRun = true)
    @SuppressWarnings("unchecked")
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(this.driver,Duration.ofSeconds(10));//The constructor WebDriverWait(WebDriver, int) is undefined
    	String username = "amarr";
		String password = "Amarrebusiness@123";
		String URL = "https://" + username + ":" + password + "@" + "qa2-atotaldoor.amarr.com/us/en/login";
		driver.get(URL);

	
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
