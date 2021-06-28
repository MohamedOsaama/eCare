package test;

import Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utilities.ScreenShotTaker;
import static utilities.CommonPaths.chromeDriver;

import java.util.concurrent.TimeUnit;


@Listeners(utilities.Listener.class)
public class BaseTest {

    public static WebDriver BrowserObject;
    ScreenShotTaker takeScreenShot = new ScreenShotTaker();
    String segmaTestUrl = "https://dc.segmatek.com/we/new/test/user/login";
    String _uatUrl = "https://test-my.te.eg/#/home/signin";


    @BeforeSuite
    public void startBrowserObject() {

         System.setProperty("webdriver.chrome.driver",chromeDriver + "chromedriver.exe");
       // System.setProperty("webdriver.edge.driver", CommonPaths.edgeDriver + "msedgedriver.exe");
      //  BrowserObject = new EdgeDriver();
        BrowserObject = new ChromeDriver();
        /*
        WebDriverWait wait = new WebDriverWait(BrowserObject, 15);
        BrowserObject.manage().window().setSize(new Dimension(1024, 800));*/
        BrowserObject.manage().window().maximize();
        BrowserObject.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BrowserObject.navigate().to(segmaTestUrl);
    }
    @BeforeMethod
    public void beforeMethod(){BrowserObject.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

    @BeforeTest
    public void beforeTest() {
        BrowserObject.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void takeScreenShot(ITestResult testResult) {

        takeScreenShot.recordFailure(testResult);
    }

    @AfterTest
    public void tearDown() {
        BrowserObject.manage().logs();
        //   BrowserObject.close();
    }
}

