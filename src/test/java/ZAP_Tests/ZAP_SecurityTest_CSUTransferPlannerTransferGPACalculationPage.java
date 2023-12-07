package ZAP_Tests;

import org.openqa.selenium.*;
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

public class ZAP_SecurityTest_CSUTransferPlannerTransferGPACalculationPage {

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

        driver.findElement(By.xpath("//button[contains(text(),'ADD COLLEGE OR UNIVERSITY')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='collegeSearch']")).sendKeys("California coast university");


        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#collegeSearch-option-0")));
            System.out.println("Element is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }

        driver.findElement(By.cssSelector("#collegeSearch-option-0")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[value='Yes'][name*='colleges.0.graduated']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='month_startDate']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//li[contains(text(),'January')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='year_startDate']")).sendKeys("2013");

        driver.findElement(By.xpath("//input[@id='month_endDate']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//li[contains(text(),'January')]")).click();

        driver.findElement(By.xpath("//input[@id='year_endDate']")).sendKeys("2014");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='termType']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//li[contains(text(),'Semester')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

    }

    @AfterMethod
    public void tearDown() {
        if (api != null) {

            String title = "CSU Transfer Planner Transfer GPA Calculation Page Security Test Report";

            String template = "traditional-html";

            String description = "CSU Transfer Planner Transfer GPA Calculation Page Security Test Report";

            String reportfilename = "CSU_TransferPlannerTransferGPACalculationPage.html";

            String targetFolder = System.getProperty("user.dir");

            try {
                ApiResponse response = api.reports.generate(title, template, null, description, null, null, null, null, null, reportfilename, null, targetFolder, null);

                System.out.println("CSU Transfer Planner Transfer GPA Calculation Page Security Test Report" + response.toString());

            } catch (ClientApiException e) {
                e.printStackTrace();
            }

        }
        driver.quit();
    }
}
