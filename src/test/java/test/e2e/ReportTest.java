package test.e2e;

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

