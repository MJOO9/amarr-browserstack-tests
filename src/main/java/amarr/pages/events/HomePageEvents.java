package amarr.pages.events;

import amarr.core.ElementFetcher;
import amarr.pages.elements.HomePageElements;

public class HomePageEvents implements HomePageElements{
	
	ElementFetcher fetcher= new ElementFetcher();
	
	public LoginPageEvents signIn() {
		
    
		fetcher.clickElementAfterWaiting( signInOrCreateAccountButtonXpath);
		fetcher.clickElementAfterWaiting( loginButtonXpath);
	
		return new  LoginPageEvents();
	}

	
	
	
}
