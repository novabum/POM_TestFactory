package test.e2e;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;


public class ReportTest {

    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeAll
    static void beforeAll() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/test-report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Test
    void myTest() {
        test = extent.createTest("myTest", "A simple passing test");
        test.info("Starting test");
        test.fail("failure message");
        test.pass("Test passed");
        Assertions.assertTrue(true);
    }

    @AfterAll
    static void afterAll() {
        extent.flush();
    }
}

