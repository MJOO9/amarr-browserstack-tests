package amarr.pages.events;

import amarr.core.Constants;
import amarr.core.ElementFetcher;

import amarr.pages.elements.LoginPageElements;

public class LoginPageEvents implements LoginPageElements{
	
	ElementFetcher fetcher=new ElementFetcher();
    
	

	public ProfilePageEvents loginAsAdmin() {
		enterEmailId(Constants.emailID);
		enterPassword(Constants.passWord);
		clickLogin();
		return new ProfilePageEvents();
	}
	
	public void enterEmailId(String email) {
		fetcher.getWebElement("id", emailUserID).sendKeys(email);
	}
	public void enterPassword(String password) {
		fetcher.getWebElement("id", passwordID).sendKeys(password);
	}

	public void clickLogin() {
		fetcher.getWebElement("xpath", loginButtonXpath).click();;
	}
	public void clickOnContinue() {
		fetcher.getWebElement("xpath", continueXpath).click();
		
	}
    
	public void typeEmail(String emailAddress) {
		fetcher.clickElementAfterWaiting( emailInputFieldXpath);
    	fetcher.sendKeys("id", emailInputFieldID, emailAddress);
    }
	
	public void typePassword( String password) {
		fetcher.clickElementAfterWaiting( emailInputFieldXpath);
    	fetcher.sendKeys("id", passwordInputFieldID, password);
    }
	
	public void clickLoginButton() {
		fetcher.click("xpath", loginButtonXpath);
	}
}
