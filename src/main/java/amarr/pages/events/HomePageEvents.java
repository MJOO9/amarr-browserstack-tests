package amarr.pages.events;

import amarr.core.ElementFetcher;

import amarr.pages.elements.HomePageElements;

public class HomePageEvents implements HomePageElements{
	
	ElementFetcher fetcher = new ElementFetcher();

	public void clickRejectCookies() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fetcher.getWebElement("id", rejectCookiesID).click();
	}

	public void clickAcceptCookies() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fetcher.getWebElement("id", acceptCookiesID).click();
	}

	public void clickOnSingInCreateAccount()
	{
		fetcher.getWebElement("xpath",signInCreateAccountXpath).click();
	}
	public LoginPageEvents clickOnLogin() {
		fetcher.getWebElement("xpath",loginButtonXpath).click();
		return new LoginPageEvents();
	}

	public boolean garageDoorsLinkVerify() {
		return fetcher.doesElementExists("xpath", amarrLogoXpath);
	}

	public boolean amarrLogoVerification() {
		return fetcher.doesElementExists("xpath", garageDoorXpath);
	}

	public boolean commercialDoorsLinkVerify() {
		return fetcher.doesElementExists("xpath", commercialDoorXpath);
	}

	public boolean designGarageDoorLinkVerify() {
		return fetcher.doesElementExists("xpath", designYourGarageDoorXpath);
	}

	public boolean whereToBuyLinkVerify() {
		return fetcher.doesElementExists("xpath", whereToBuyXpath);
	}

	public boolean supportLinkVerify() {
		return fetcher.doesElementExists("xpath", supportXpath);
	}
	
	
	
}
