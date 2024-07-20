package amarr.pages.events;

import amarr.core.ElementFetcher;
import amarr.pages.elements.ProfilePageElements;


public class ProfilePageEvents implements ProfilePageElements {
	
	ElementFetcher fetcher=new ElementFetcher();
	public OrderNowEvents clickOrderNow() {
		fetcher.getWebElement("xpath", orderNowXpath).click();
		return new OrderNowEvents();
	}

}