package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePlan extends PageBase {
    public ChangePlan (WebDriver browserObject) {
        super(browserObject);

    }

    public @FindBy(xpath = "//*[@class='w-auto secondary-btn p-button p-component ng-star-inserted']")
    WebElement renewButton;
    public @FindBy(xpath = "//span[@class='font-22px ml-2 font-weight-semibold']")
    WebElement snTextField;
    public @FindBy(xpath = "//*[@type ='button' and @class='p-button p-component' ]")
    WebElement confirmRenewButton;
    private final By popUpConfirmRenewButton =By.xpath("//*[@class='p-button p-component']");

    public void clickRenewButton(){
        clickButton(renewButton);
    }
    public void clickOnConfirmButton(){
        clickButton(confirmRenewButton);
    }
    public String cpPageSnValidator(){
        String sn = (String) snTextField.getText();
        return sn;
    }
    public  void ClickOnPopUpConfirmRenewButton(){
    BrowserObject.findElement(popUpConfirmRenewButton);
    }
}

//Login successful  class="p-toast-detail ng-tns-c42-31"<!----> class="p-toast-summary ng-tns-c42-10"