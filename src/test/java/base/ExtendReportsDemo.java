package base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.*;
public class ExtendReportsDemo implements ITestListener {
	private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
 
    static {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\sivap\\eclipse-workspace\\Selenium-S2-demo\\ExtendReports\\Extend.html");
        htmlReporter.config().setDocumentTitle("Selenium TestNG Extent Report");
        htmlReporter.config().setReportName("Test Automation Report");
 
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
 
    @Override
    public void onStart(ITestContext context) {
    }
 
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }
 
    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
    }
 
    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
        test.get().fail(result.getThrowable());
    }
 
    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.YELLOW));
    }
 
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
 
}

