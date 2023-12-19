package amarr.pages.events;

import amarr.core.ElementFetcher;
import amarr.pages.elements.LoginPageElements;

public class LoginPageEvents implements LoginPageElements{
	
	ElementFetcher fetcher=new ElementFetcher();
    
    
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
