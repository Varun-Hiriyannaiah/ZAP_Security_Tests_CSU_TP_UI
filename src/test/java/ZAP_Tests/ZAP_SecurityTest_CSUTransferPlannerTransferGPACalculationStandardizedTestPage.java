package ZAP_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import java.time.Duration;

public class ZAP_SecurityTest_CSUTransferPlannerTransferGPACalculationStandardizedTestPage {

    static final String ZAP_PROXY_ADDRESS = "localhost";
    static final int ZAP_PROXY_PORT = 8080;
    static final String ZAP_API_KEY = "v0ufhi2n5penu9dkbsi4qbh66k";

    private WebDriver driver;
    private ClientApi api;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C://Users//vhiriyannaiah//Desktop//chromedriver-win64/chromedriver.exe");

        String proxyServerURL = ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT;

        Proxy proxy = new Proxy();

        proxy.setHttpProxy(proxyServerURL);

        proxy.setSslProxy(proxyServerURL);

        ChromeOptions co = new ChromeOptions();

        co.setProxy(proxy);

        co.addArguments("--remote-allow-origins=*");

        co.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        driver = new ChromeDriver(co);

        api = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);

    }

    @Test
    public void LivingProfileSecurityTest() throws InterruptedException {

        driver.get("https://csutransfer.qa.myliaison.com");

        Thread.sleep(3000);

        System.out.println("The title of the page is " + driver.getTitle());

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("bb@mailinator.com");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Commercial1!");

        driver.findElement(By.xpath("//button[@id='kc-login']")).click();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='take questionnaire']")));
            System.out.println("Element is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }

        Thread.sleep(3000);

        driver.findElement(By.xpath("(//button[normalize-space()='Go To Academic History'])[1]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'ADD TEST')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='testCategory']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//li[contains(text(),'Credit by exam (AP/IB/CLEP)')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='tests']")).click();

        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//li[contains(text(),'CLEP (College Level Examination Program)')]")).click();

        Thread.sleep(2000);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='clepExam']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//li[contains(text(),'American Government')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[value='PLANNED'][name*='status.code']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='month_testDate']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//li[contains(text(),'January')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='year_testDate']")).sendKeys("2026");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//h1[contains(text(),'Add Test')]//ancestor::div[2]//following-sibling::div//button[@aria-label='Save']")).click();
        
    }

    @AfterMethod
    public void tearDown() {
        if (api != null) {

            String title = "CSU Transfer Planner Transfer GPA Calculation StandardizedTest Page Security Test Report";

            String template = "traditional-html";

            String description = "CSU Transfer Planner Transfer GPA Calculation StandardizedTest Page Security Test Report";

            String reportfilename = "CSU_TransferPlannerTransferGPACalculationStandardizedTestPage.html";

            String targetFolder = System.getProperty("user.dir");

            try {
                ApiResponse response = api.reports.generate(title, template, null, description, null, null, null, null, null, reportfilename, null, targetFolder, null);

                System.out.println("CSU Transfer Planner Transfer GPA Calculation Page StandardizedTest Security Test Report" + response.toString());

            } catch (ClientApiException e) {
                e.printStackTrace();
            }

        }
        driver.quit();
    }
}
