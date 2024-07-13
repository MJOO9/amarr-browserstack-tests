package com.browserstack;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
	public static WebDriver driver;
	
	public static WebDriverWait wait;
	public ExtentSparkReporter htmlReport;
	public static ExtentReports extentreports;
	public static ExtentTest logger;
    
	

	
	@BeforeTest
	public void beforeTestMethods() {
		htmlReport = new ExtentSparkReporter("./extentreports/report.html");
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setDocumentTitle("Amarr Automation Report");
		htmlReport.config().setTheme(Theme.DARK);
		extentreports = new ExtentReports();
		extentreports.attachReporter(htmlReport);

	}
    
    @BeforeMethod(alwaysRun = true)
    @SuppressWarnings("unchecked")
    public void setUp(@Optional String browserName, Method testMethod) throws Exception {
    	logger = extentreports.createTest(testMethod.getName());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       //The constructor WebDriverWait(WebDriver, int) is undefined qa2-atotaldoor.amarr.com/us/en/login
    	String username = "amarr";
		String password = "Amarrebusiness@123";
		String URL = "https://" + username + ":" + password + "@" + "qa2-atotaldoor.amarr.com/";
		driver.get(URL);

	
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Exception {
    	if (result.getStatus() == ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			String logTest = "Test case " + methodName + " Passed";
			Markup m = MarkupHelper.createLabel(logTest, ExtentColor.GREEN);
			logger.log(Status.PASS, m);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			String logTest = "Test case " + methodName + " Failed";
			Markup m = MarkupHelper.createLabel(logTest, ExtentColor.RED);
			logger.log(Status.FAIL, m);
		} else if (result.getStatus() == ITestResult.SKIP) {
			String methodName = result.getMethod().getMethodName();
			String logTest = "Test case " + methodName + " Skipped";
			Markup m = MarkupHelper.createLabel(logTest, ExtentColor.YELLOW);
			logger.log(Status.SKIP, m);
		}
		driver.quit();
    }
	@AfterTest
	public void afterTestMethod() {

		extentreports.flush();
	}
	
    public static WebElement waitUntilElementIsVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);  // Return the WebElement after waiting
    }
}
