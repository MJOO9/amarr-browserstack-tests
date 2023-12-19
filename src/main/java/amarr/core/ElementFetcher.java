package amarr.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	public void click(String elementType,String elementIdentifier) {
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
	 boolean exists=	getWebElement(elementType, elementIdentifierValue)!=null;
	 return exists;
	}
	

	public void scrollDownByJavaScript(String elementType, String elementIdentifierValue) {

		String msg = "Scrolling to element by JavaScript";
		System.out.println(msg);
		WebElement element = getWebElement(elementType, elementIdentifierValue);

		((JavascriptExecutor) SeleniumTest.driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}
	
	public WebElement waitForElementToBeClickableyXpath( String elementIdentifierValue){
		WebElement element= SeleniumTest.waitUntilElementIsVisible(By.xpath(elementIdentifierValue));
		return element;
	}
    public void clickElementAfterWaiting( String elementIdentifierValue) {
    	SeleniumTest.waitUntilElementIsVisible(By.xpath(elementIdentifierValue)).click();;
       // SeleniumTest.driver.findElement(By.xpath(elementIdentifierValue)).click();
    }
}
