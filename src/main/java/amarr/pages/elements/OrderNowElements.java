package amarr.pages.elements;

public interface OrderNowElements {

	//ids
	
	String moderDoorStyleID="Modern__door_style_link";
    
	String carriageHouseDoorStyleID="Carriage House__door_style_link";

    String traditionalDoorStyleID="Traditional__door_style_link";
    String confirmationCheckBoxID="site-checked";
    
    
    /*XPATHS */

    String nextButtonOnClassicaSelectionXpath="(//span[text()='NEXT']/parent::button/parent::div)[2]";
    String classsicaSelectionXpath="//div[@class='door-collection-item br_4 p-4 d-flex class0 ']/descendant::button[@type='button']";
    String svgLoadingXpath="//svg[@width='100' and @height='100' and @viewBox='0 0 120 30' and @xmlns='http://www.w3.org/2000/svg' and @fill='#006166' and @aria-label='audio-loading']";
    String customizePageNextButton="(//span[text()='NEXT'])[2]";
    String loadingDots="(//div[@aria-busy='true'])[2]";
    String noThanksButoonXpath="//button/span[text()='NO THANKS']";
    String skipButton="//button[text()='Skip']";
    String addToCartXpath="//button/span[text()='ADD TO CART']";
    //String checkOutXpath="CHECKOUT";
    String checkBoxXpath="//label[contains(text(),'Please')]/preceding-sibling::input[@type='checkbox']";
    String nextButtonOnCkeckoutXpath="(//button/span[text()='NEXT'])[1]";
    String checkOutXpath="//span[text()='CHECKOUT']/parent::button";
    
    
    
    
    String cardNumberInputForPaymentXpath="//input[@placeholder='Card number']";
    String expiryDateInputForPaymentXpath="//input[@placeholder='MM / YY']";
    String cvcInputForPaymentXpath="//input[@placeholder='CVC']";
    String zipInputForPaymentXpath="//input[@placeholder='ZIP']";
    
    String payNowButtonXpath="//span[text()='PAY NOW']";

    
    String orderPlacedTextXpath="(//h4[text()='Order Placed!'])[1]";
	
}
