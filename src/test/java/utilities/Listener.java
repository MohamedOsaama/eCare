package utilities;

import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseTest;

public class Listener extends BaseTest implements ITestListener, IReporter {
    /*
        public void onFinish(ITestContext Result) {

    }


        public void onStart(ITestContext Result) {

    }*/


    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

    }

    @Override
    public void onTestFailure(ITestResult Result) {
        // TODO Auto-generated method stub
        System.out.println("Testcase: " + Result.getName() + " -> Failed");
    }

    @Override
    public void onTestSkipped(ITestResult Result) {
        // TODO Auto-generated method stub
        System.out.println("Testcase: " + Result.getName() + "  -> skipped");

    }

    @Override
    public void onTestStart(ITestResult Result) {
        // TODO Auto-generated method stub
        Result.getFactoryParameters();
        Result.getStatus();
        System.out.println("Testcase: " + Result.getName() + " -> has Started");


    }

    @Override
    public void onTestSuccess(ITestResult Result) {
        // TODO Auto-generated method stub
        System.out.println("Testcase: " + Result.getName() + "  -> Passed Successfully");

    }
}