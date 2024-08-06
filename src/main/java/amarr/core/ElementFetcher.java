package amarr.core;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.browserstack.SeleniumTest;



public class ElementFetcher {

	public WebElement getWebElement(String elementType, String elementIdentifierValue) {
		switch (elementType) {
		case "id":
			return SeleniumTest.driver.findElement(By.id(elementIdentifierValue));
		case "css":
			return SeleniumTest.driver.findElement(By.cssSelector(elementIdentifierValue));
		case "tagname":
			return SeleniumTest.driver.findElement(By.tagName(elementIdentifierValue));
		case "xpath":
			return SeleniumTest.driver.findElement(By.xpath(elementIdentifierValue));
		default:
			return null;

		}

	}

	public void click(String elementType, String elementIdentifier) {
		switch (elementType) {
		case "id":
			SeleniumTest.driver.findElement(By.id(elementIdentifier)).click();
			break;
		case "css":
			SeleniumTest.driver.findElement(By.cssSelector(elementIdentifier)).click();
			break;
		case "tagname":
			SeleniumTest.driver.findElement(By.tagName(elementIdentifier)).click();
			break;
		case "xpath":
			SeleniumTest.driver.findElement(By.xpath(elementIdentifier)).click();
			break;
		default:
			System.err.println("No such element to click on ");
		}
	}

	public void sendKeys(String elementType, String elementIdentifier, String textToEnter) {
		switch (elementType) {
		case "id":
			SeleniumTest.driver.findElement(By.id(elementIdentifier)).sendKeys(textToEnter);
			break;
		case "css":
			SeleniumTest.driver.findElement(By.cssSelector(elementIdentifier)).sendKeys(textToEnter);
			break;
		case "tagname":
			SeleniumTest.driver.findElement(By.tagName(elementIdentifier)).sendKeys(textToEnter);
			break;
		case "xpath":
			SeleniumTest.driver.findElement(By.xpath(elementIdentifier)).sendKeys(textToEnter);
			break;
		default:
			System.err.println("No such element to type or send keys.");
		}
	}

	public List<WebElement> getListOfWebElements(String elementType, String elementIdentifierValue) {
		switch (elementType) {
		case "id":
			return SeleniumTest.driver.findElements(By.id(elementIdentifierValue));
		case "css":
			return SeleniumTest.driver.findElements(By.cssSelector(elementIdentifierValue));
		case "tagname":
			return SeleniumTest.driver.findElements(By.tagName(elementIdentifierValue));
		case "xpath":
			return SeleniumTest.driver.findElements(By.xpath(elementIdentifierValue));
		default:
			return null;

		}
	}

	public String getTextByWebElement(String elementType, String elementIdentifierValue) {

		String text = getWebElement(elementType, elementIdentifierValue).getText();
		return text;
	}

	public void mouseHoverAction(String elementType, String elementIdentifierValue) {
		Actions actions = new Actions(SeleniumTest.driver);
		actions.moveToElement(getWebElement(elementType, elementIdentifierValue)).build().perform();
	}

	public void moveToElementAndClickAction(String elementType, String elementIdentifierValue) {
		Actions actions = new Actions(SeleniumTest.driver);
		actions.moveToElement(getWebElement(elementType, elementIdentifierValue)).click().build().perform();
	}

	public <T> void verify(T actualResult, T expectedResult, String message) {

		Assert.assertEquals(actualResult, expectedResult, message);
	}

	public boolean doesElementExists(String elementType, String elementIdentifierValue) {
		boolean exists = getWebElement(elementType, elementIdentifierValue) != null;
		return exists;
	}

	public WebElement waitForElementToBeClickableyXpath(String elementIdentifierValue) {
		WebElement element = SeleniumTest.waitUntilElementIsVisible(By.xpath(elementIdentifierValue));
		return element;
	}

	public void clickElementAfterWaiting(String elementIdentifierValue) {
		SeleniumTest.waitUntilElementIsVisible(By.xpath(elementIdentifierValue)).click();
		;
		// SeleniumTest.driver.findElement(By.xpath(elementIdentifierValue)).click();
	}

	public void waitForElementToBeClickable(String xpath) {

		WebDriverWait wait = new WebDriverWait(SeleniumTest.driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(getWebElement("xpath", xpath)));

	}

	public void scrollDownByJavaScript(String elementType, String elementIdentifierValue) {

		String msg = "Scrolling to element by JavaScript";
		System.out.println(msg);
		WebElement element = getWebElement(elementType, elementIdentifierValue);

		((JavascriptExecutor) SeleniumTest.driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void selectByVisibleText(String textToBeSelected, String id) {
		WebElement dropDown = getWebElement("id", id);
		Select select = new Select(dropDown);
		select.selectByVisibleText(textToBeSelected);

	}

	public void selectByValue(String valueToBeSelected, String id) {
		WebElement dropDown = getWebElement("id", id);

		Select select = new Select(dropDown);
		select.selectByValue(valueToBeSelected);

	}

	public void switchWindowHandles() {
		String mainWindowHandle = SeleniumTest.driver.getWindowHandle();

		// Get all window handles
		Set<String> allWindowHandles = SeleniumTest.driver.getWindowHandles();

		// Switch to the new window handle
		for (String handle : allWindowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				SeleniumTest.driver.switchTo().window(handle);
				break;
			}
		}

	}

	public boolean loadingDotsdisapear() {

		boolean elementsPresent = true;

		while (elementsPresent) {
			try {
				List<WebElement> elements = getListOfWebElements("xpath",
						"//div[@aria-label='three-dots-loading' and @aria-busy='true']");
				elementsPresent = elements.stream().anyMatch(WebElement::isDisplayed);

			} catch (Exception e) {
				// Handle any exceptions that may occur
				elementsPresent = true; // Continue checking if there's an exception
			}
		}

		return elementsPresent;

	}
	
    public void selectOptionRandomly(String[] options, String idOrXpath) {
        RandomlySelectOption randomOptions = new RandomlySelectOption(options, idOrXpath);
        randomOptions.selectRandomInputOption();
    }
	
    private class RandomlySelectOption {

        private String[] options;
        private String id;

        public RandomlySelectOption(String[] options, String id) {
            this.options = options;
            this.id = id;
        }

        public void selectRandomInputOption() {
            Random random = new Random();
            String selectRandomOption = options[random.nextInt(options.length)];
          
            selectByVisibleText(id, selectRandomOption);
            
            
        }
    }
}
