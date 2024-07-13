package amarr.pages.elements;


public interface HomePageElements {

	/*Below are XPATHs for HomePage*/
	
	String signInOrCreateAccountButtonXpath="//a[@aria-label='User Account Button']";
	String loginButtonXpath="(//a/button)[1]";
	String signUpButtonXpath="(//a/button/span[text()='SIGN UP'])[1]";
	String logoXpath="//img[@alt='Logo']";
	String homeXpath="(//a[@aria-label='Home'])[1]";
	String garageDoorXpath="(//a[@aria-label='Garage Doors'])[1]";
	String designDoorXpath="(//a[@aria-label='Design Your Door'])[1]";
	String photoGalleryXpath="(//a[@aria-label='Photo Gallery'])[1]";
	String otherProductsXpath="(//a[@aria-label='Photo Gallery'])[1]";
	String videoXpath="(//a[@aria-label='Videos'])[1]";
	String aboutUsXpath="(//a[@aria-label='About Us'])[1]";
	String contactUsXpath="(//a[@aria-label='Contact Us'])[1]";
	String orderNowXpath="(//a[@aria-label='ORDER NOW'])[1]";
	
	
	/**
	 * Below list of all HomePage element XPATH listed, please list more if required
	 */
	String amarrLogoXpath = "//img[@loading='lazy' and @alt='Amarr Garage Doors']";
	String signInCreateAccountXpath = "//a[text()='Sign In/ Create Account']";
	String commercialDoorXpath = "//a[contains(text(),'Commercial Doors')]";
	String whereToBuyXpath = "//a[contains(text(),'Where to Buy')]";
	String designYourGarageDoorXpath = "//a[contains(text(),'Design Your Garage Door')]";
	String supportXpath = "//li/a[text()='Support' and @class='nav-link amarr-h6']";


	/**
	 * Below list of all id element for home page please list more if required
	 */
	String manageCookiesID = "onetrust-pc-btn-handler";
	String acceptCookiesID = "onetrust-accept-btn-handler";

	String rejectCookiesID = "onetrust-reject-all-handler";
	
	
	/*List ID below
	*/
}
