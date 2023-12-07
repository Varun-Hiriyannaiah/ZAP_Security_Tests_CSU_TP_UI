package ZAP_Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import java.time.Duration;

public class ZAP_SecurityTest_CSUTransferPlannerTSPEligibilityQuestionnairePage {
    
    static final String ZAP_PROXY_ADDRESS ="localhost";
    static final int ZAP_PROXY_PORT =8080;
    static final String ZAP_API_KEY ="v0ufhi2n5penu9dkbsi4qbh66k";
    
    private WebDriver driver;
    private ClientApi api;
    
    @BeforeMethod
    public void setup() {

        String proxyServerURL = ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT;

        Proxy proxy = new Proxy();

        proxy.setHttpProxy(proxyServerURL);

        proxy.setSslProxy(proxyServerURL);

        ChromeOptions co = new ChromeOptions();

        co.setProxy(proxy);
        
     //   co.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        
    //    co.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(co);
        
        api = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);
        
    }
    
    @Test
    public void LivingProfileSecurityTest() throws InterruptedException {

        driver.get("https://auth-dev.liaisoncas.com/realms/lp-student/protocol/openid-connect/auth?client_id=tp-csu-student&redirect_uri=http%3A%2F%2Fapp.dev.transfer-planner.com%2Fterms&state=0cebf16c-e21c-4e1a-b80b-5c29b092ae89&response_mode=fragment&response_type=code&scope=openid&nonce=2315d0e4-2186-43c8-9752-b0c5d4507f38&code_challenge=yQjnjs-_IuDnCLk8PuPwNPZCUWvGUTdCCt3pmiIXhS0&code_challenge_method=S256");

        Thread.sleep(3000);

        System.out.println("The title of the page is " + driver.getTitle());

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("varunh8892@gmail.com");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Commercial1!");

        driver.findElement(By.xpath("//button[@id='kc-login']")).click();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='begin questionnaire']")));
            System.out.println("Element is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }

        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//button[normalize-space()='begin questionnaire']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='Yes-graduate']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='Yes-applied']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='Financial reasons-notApplyReason']")).click();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Fall 2024')]")));
            System.out.println("Element is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }

        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();

        Thread.sleep(3000);

        WebElement testone = driver.findElement(By.xpath("//h1[@id='questionnaire-information-1']"));

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(testone));
            System.out.println("Element is displayed");
        } catch (TimeoutException e) {
            System.out.println("Element isn't displayed");
        }

        Thread.sleep(3000);
        
        WebElement testtwo = driver.findElement(By.xpath("//h2[contains(text(),'Based on your answers, you are eligible for the Tr')]"));

        testtwo.isDisplayed();

        WebElement testthree = driver.findElement(By.xpath("//button[normalize-space()='go to dashboard']"));
        
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(testthree));
            System.out.println("Element is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
        testthree.isDisplayed();
        
    }
    @AfterMethod
    public void tearDown(){
        if (api!= null){

            String title = "CSU Transfer Planner TSP Eligibility Questionnaire page Security Test Report";

            String template = "traditional-html";

            String description = "CSU Transfer Planner TSP Eligibility Questionnaire page Security Test Report";

            String reportfilename = "CSU_TransferPlannerTSP_Eligibility_Questionnaire.html";

            String targetFolder = System.getProperty("user.dir");

            try {
                ApiResponse response = api.reports.generate(title,template,null,description,null,null,null,null,null,reportfilename,null,targetFolder,null);

            System.out.println("CSU Transfer Planner TSP Eligibility Questionnaire page Security Test Report"+ response.toString());

            } catch (ClientApiException e) {
                e.printStackTrace();
            }

        }
        driver.quit();
    }
}
