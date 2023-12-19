package amarr.pages.elements;

public interface LoginPageElements {
 /*Below are list of ID for login page*/
	String emailInputFieldID="email-address-id";
	String passwordInputFieldID="password-id";
	

	/*Below are list of XPATHS for */
	
	String loginButtonXpath="(//button/span[text()='LOGIN'])[3]";
	String emailInputFieldXpath="//input[@aria-label='Email Address']";
	String passwordInputFieldXpath="//input[@aria-label='Password']";
}
