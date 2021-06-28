package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase {

    public SignInPage(WebDriver browserObject) { super(browserObject);}


    @FindBy (xpath = "//input[@type='text' and @placeholder='Service number']")
        public static   WebElement serviceNumberField;

    @FindBy (xpath = "//input[@type='password']")
         public WebElement passwordField;

    @FindBy(xpath = "//*[@type ='submit']")
            WebElement loginButton;

        public void enterServiceNumber (String serviceNumberString) {
            setValue(serviceNumberField, serviceNumberString);
        }

        public void enterPassword (String password ) {
            setValue(passwordField,password);

        }
        public void clickLoginButton(){
            clickButton(loginButton);
        }


    }
