package utilities;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import static test.BaseTest.BrowserObject;
import static utilities.CommonPaths.SCREENSHOTS;

public class ScreenShotTaker {

    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) BrowserObject;;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("System is taking a screenshot..");

            try {
                Files.move(screenshot, new File(SCREENSHOTS+result.getName()+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
