package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountOverview extends PageBase{

    public AccountOverview(WebDriver browserObject) { super(browserObject);}


    public @FindBy(xpath = "//*[@type ='button' and @class='secondary-btn mr-4 my-2 p-button p-component' ]")
    WebElement changePlanButton;

    public String serviceNumberDropDown() {
    Select dropdown = new Select(BrowserObject.findElement(By.xpath("//*[@name='managedNumbers']")));
    String currentServiceNumber = dropdown.getFirstSelectedOption().getText();
    return currentServiceNumber;

        }

    public void clickChangePlanButton()
    {
        clickButton(changePlanButton);
    }

}
