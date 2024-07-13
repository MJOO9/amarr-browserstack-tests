package amarr.pages.events;

import amarr.core.ElementFetcher;
import amarr.pages.elements.OrderNowElements;


public class OrderNowEvents implements OrderNowElements{
	
	ElementFetcher fetcher=new ElementFetcher();
	
	public void selectWidthByText(String text) {
		
		//select id=widthFeet-0-id
		fetcher.selectByVisibleText(text, "widthFeet-0-id");
		
	}

	//heightFeet-0-id
	public void selectHeightByText(String text) {
		fetcher.selectByVisibleText(text, "heightFeet-0-id");
	}
	
	//headroom-0-id
	
	public void selectHeadRoomByValue(String text) {
		fetcher.selectByValue(text,"headroom-0-id");
	}
	
	public void selectSideRoomByValue(String text) {
		fetcher.selectByValue(text,"sideroom-0-id");
	}
	public void selectBackRoomByValue(String text) {
		fetcher.selectByValue(text, "backroomfeet-0-id");
	}
	
	public void selectClassicaSelection() {
		fetcher.getWebElement("xpath", classsicaSelectionXpath).click();
	}
	
	public void selectNextOnCustomize() {

		fetcher.loadingDotsdisapear();
		System.out.println(fetcher.loadingDotsdisapear());
		fetcher.waitForElementToBeClickable(nextButtonOnClassicaSelectionXpath);
		fetcher.getWebElement("xpath", nextButtonOnClassicaSelectionXpath).click();
	}
	
	public void clickNext() {
		fetcher.getWebElement("xpath", "(//button/span[text()='NEXT'])[1]").click();
	}
	
	public void clickNextONCustomize() {

		fetcher.loadingDotsdisapear();
		fetcher.getWebElement("xpath", customizePageNextButton).click();
	}
	
	public void clickNoThanks() {
		
		fetcher.loadingDotsdisapear();	

		
    	fetcher.getWebElement("xpath", noThanksButoonXpath).click();;
	}
	
	public void clickSkip() {
		fetcher.getWebElement("xpath", skipButton ).click();
		
		
	}
	
	public void clickAddToCart() {
		fetcher.loadingDotsdisapear();
		fetcher.getWebElement("xpath", addToCartXpath ).click();
		}

	
	public void clickCkeckOut() {
		fetcher.loadingDotsdisapear();
		fetcher.getWebElement("xpath", checkOutXpath).click();
	}
	
	public void selectconfirmationCheckBoxAndClcikNext() {
		fetcher.loadingDotsdisapear();
		fetcher.getWebElement("id", confirmationCheckBoxID).click();
		fetcher.getWebElement("xpath", "(//span[text()='NEXT'])[1]").click();
	}
	
	
	//testing for card number is 4242 4242 4242 4242 EXP:12/25 CVC 222 ZIP: 95687
	public void inputForPaymentDetailsAndPay(String cardNumber, String expiryDate,String cvc ,String zip) {
		fetcher.loadingDotsdisapear();
		fetcher.getWebElement("xpath", cardNumberInputForPaymentXpath).sendKeys(cardNumber);
		fetcher.getWebElement("xpath", expiryDateInputForPaymentXpath).sendKeys(expiryDate);
		fetcher.getWebElement("xpath",cvcInputForPaymentXpath).sendKeys(cvc);
		fetcher.getWebElement("xpath", zipInputForPaymentXpath).sendKeys(zip);
		fetcher.getWebElement("xpath", payNowButtonXpath).click();
	}
	
	public void inputForPaymentDetailsAndPay() {
		fetcher.loadingDotsdisapear();
		fetcher.getWebElement("xpath", cardNumberInputForPaymentXpath).sendKeys("4242 4242 4242 4242");
		fetcher.getWebElement("xpath", expiryDateInputForPaymentXpath).sendKeys("1225");
		fetcher.getWebElement("xpath",cvcInputForPaymentXpath).sendKeys("222");
		fetcher.getWebElement("xpath", zipInputForPaymentXpath).sendKeys("95687");
		fetcher.getWebElement("xpath", payNowButtonXpath).click();
	}
	
	public void verifyOrderPlaced(String textToVerify) {
		fetcher.loadingDotsdisapear();
	String orderPlacedTxt=	fetcher.getTextByWebElement("xpath", orderPlacedTextXpath);
       
	 fetcher.verify(orderPlacedTxt, "Order Placed!", "the text after placing the order:"+orderPlacedTxt);
	}
}
