package ZAP_Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class ZAP_SecurityTest_CSUTransferPlannerResearchCampusesPage {
    
    static final String ZAP_PROXY_ADDRESS ="localhost";
    static final int ZAP_PROXY_PORT =8080;
    static final String ZAP_API_KEY ="v0ufhi2n5penu9dkbsi4qbh66k";
    
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
        
       // co.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        
        co.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

     //   WebDriverManager.chromedriver().setup();

     //   driver = new ChromeDriver(co);

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
        
        driver.findElement(By.xpath("//button[normalize-space()='take questionnaire']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='Yes-graduate']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='Yes-applied']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='Financial reasons-notApplyReason']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='tspQuestionnaire.planToTransfer']")).click();
        
        
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
        
        WebElement testtwo = driver.findElement(By.xpath("//h2[contains(text(),'Based on your high school graduation date')]"));

        testtwo.isDisplayed();

        WebElement testthree = driver.findElement(By.xpath("//button[normalize-space()='go to dashboard']"));
        
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(testthree));
            System.out.println("Element is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
        testthree.isDisplayed();
        
        Thread.sleep(3000);
        
        WebElement testfour = driver.findElement(By.xpath("//button[normalize-space()='Explore']"));
        
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(testfour));
            System.out.println("Element is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }

        testfour.click();

        Thread.sleep(3000);
        
        WebElement testfive = driver.findElement(By.xpath("//div[contains(text(),'Explore Cal State Universities & Programs')]"));

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(testfive));
            System.out.println("Element is displayed");
        } catch (TimeoutException e) {
            System.out.println("Element isn't displayed");
        }

        testfive.isDisplayed();

        Thread.sleep(3000);

        WebElement testsix = driver.findElement(By.xpath("//button[normalize-space()='PROGRAMS']"));

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(testsix));
            System.out.println("Element is displayed");
        } catch (TimeoutException e) {
            System.out.println("Element isn't displayed");
        }

        testsix.click();

        Thread.sleep(3000);

        WebElement testseven = driver.findElement(By.xpath("//button[normalize-space()='see more']"));

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(testseven));
            System.out.println("Element is Clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't Clickable");
        }

        testseven.click();
        
        Thread.sleep(3000);

        WebElement testeight = driver.findElement(By.xpath("//div[contains(text(),'B')]"));

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(testeight));
            System.out.println("Element is displayed");
        } catch (TimeoutException e) {
            System.out.println("Element isn't displayed");
        }

        Thread.sleep(3000);

        WebElement testnine = driver.findElement(By.xpath("//div[contains(text(),'D')]"));

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(testeight));
            System.out.println("Element is displayed");
        } catch (TimeoutException e) {
            System.out.println("Element isn't displayed");
        }

        testnine.click();

        Thread.sleep(3000);

        WebElement testten = driver.findElement(By.xpath("//input[@name='eligible-checkbox']"));

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(testten));
            System.out.println("Element is displayed");
        } catch (TimeoutException e) {
            System.out.println("Element isn't displayed");
        }

        testten.click();

        Thread.sleep(3000);

        WebElement testeleven = driver.findElement(By.xpath("//button[normalize-space()='reset']"));

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(testeleven));
            System.out.println("Element is displayed");
        } catch (TimeoutException e) {
            System.out.println("Element isn't displayed");
        }

        testten.click();
        
    }
    @AfterMethod
    public void tearDown(){
        if (api!= null){

            String title = "CSU Transfer Planner Research Campuses Page Security Test Report";

            String template = "traditional-html";

            String description = "CSU Transfer Planner Research Campuses Page Security Test Report";

            String reportfilename = "CSU_TransferPlannerResearchCampusesPage.html";

            String targetFolder = System.getProperty("user.dir");

            try {
                ApiResponse response = api.reports.generate(title,template,null,description,null,null,null,null,null,reportfilename,null,targetFolder,null);

            System.out.println("CSU Transfer Planner Research Campuses Page Security Test Report"+ response.toString());

            } catch (ClientApiException e) {
                e.printStackTrace();
            }

        }
        driver.quit();
    }
}
