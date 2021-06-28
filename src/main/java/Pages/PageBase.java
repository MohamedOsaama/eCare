package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    public WebDriver BrowserObject ;
    public static @FindBy(xpath = "//span[@class='p-submenu-icon pi pi-angle-down ng-star-inserted']")
    WebElement headerButton;
    public static  @FindBy(xpath = "//span[@class= 'p-menuitem-text ng-star-inserted' and contains(text(),'Logout')]")
    WebElement logOutButton;

    public PageBase(WebDriver BrowserObject) {


        PageFactory.initElements(BrowserObject, this);
        this.BrowserObject= BrowserObject;


    }
    public static void logout() {

        PageBase.clickButton(headerButton);
        PageBase.clickButton(logOutButton);
    }

    public static void setValue (WebElement element , String value) {

        element.sendKeys(value);
    }
    public static void clickButton(WebElement button) {

        button.click();
    }

    }
