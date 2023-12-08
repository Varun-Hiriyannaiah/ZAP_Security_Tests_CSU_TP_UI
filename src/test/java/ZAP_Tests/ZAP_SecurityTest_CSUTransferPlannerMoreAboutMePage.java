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

public class ZAP_SecurityTest_CSUTransferPlannerMoreAboutMePage {

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

        driver.findElement(By.xpath("//button//div[contains(text(),'Research Universities & Programs')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'PROGRAMS')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Accounting Option, B.S.B.A.')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Add program')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[contains(text(),'Follow Program')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();

        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[@aria-label='back to dashboard']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("(//button[contains(text(),'view')])[1]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'About Gen ed')]")).click();
        
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'My Programs (0)')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(text(),'Transfer Progress')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Go To Academic History')]")).click();

        Thread.sleep(2000);
        
    }

    @AfterMethod
    public void tearDown() {
        if (api != null) {

            String title = "CSU Transfer Planner General Education Progess Security Test Report";

            String template = "traditional-html";

            String description = "CSU Transfer Planner General Education Progess Page Security Test Report";

            String reportfilename = "CSU_TransferPlannerGeneralEducationProgess.html";

            String targetFolder = System.getProperty("user.dir");

            try {
                ApiResponse response = api.reports.generate(title, template, null, description, null, null, null, null, null, reportfilename, null, targetFolder, null);

                System.out.println("CSU Transfer Planner General Education Progess Security Test Report" + response.toString());

            } catch (ClientApiException e) {
                e.printStackTrace();
            }

        }
        driver.quit();
    }
}
