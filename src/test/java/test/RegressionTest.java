package test;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AccountOverview;
import Pages.ChangePlan;
import Pages.PageBase;
import Pages.SignInPage;
import utilities.Wrappers.JsonDataReader;

import java.util.concurrent.TimeUnit;

public class RegressionTest extends BaseTest {


    SignInPage signinPage;
    AccountOverview accountOverview;
    ChangePlan changePlan;
    PageBase pageBase;

    @Test(priority = 1 , dataProvider = "JsonReader",
            dataProviderClass= JsonDataReader.class)
    public void userSignIn(String testData) {

        String[] users = testData.split(",");
        signinPage = new SignInPage(BrowserObject);
        accountOverview = new AccountOverview(BrowserObject);
        changePlan = new ChangePlan(BrowserObject);
        pageBase = new PageBase(BrowserObject);
      //  BrowserObject.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        Assert.assertEquals(true, signinPage.serviceNumberField.isDisplayed());
        signinPage.enterServiceNumber(users[1]);
        signinPage.enterPassword(users[2]);
        signinPage.clickLoginButton();
        BrowserObject.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        accountOverview.serviceNumberDropDown();
        Assert.assertEquals(accountOverview.serviceNumberDropDown(),users[1]);
        accountOverview.clickChangePlanButton();
        Assert.assertEquals(changePlan.cpPageSnValidator(),users[1]);
        changePlan.clickRenewButton();
        BrowserObject.switchTo().activeElement();
        changePlan.ClickOnPopUpConfirmRenewButton();
        pageBase.logout();



    }

    @Test(dependsOnMethods = "userSignIn")
    public void userChangeMainPlan() {

        accountOverview.clickChangePlanButton();
        Assert.assertEquals(BrowserObject.getTitle(), "Change Plan");
        changePlan.clickRenewButton();
        changePlan.clickOnConfirmButton();

    }

    }


