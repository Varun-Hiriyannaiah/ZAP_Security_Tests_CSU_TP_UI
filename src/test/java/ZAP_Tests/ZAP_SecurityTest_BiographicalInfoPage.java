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

public class ZAP_SecurityTest_BiographicalInfoPage {
    
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
        
    //    co.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        
     //   co.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(co);
        
        api = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);
        
    }
    
    @Test
    public void LivingProfileSecurityTest() throws InterruptedException {
        
        driver.get("https://csutransfer.qa.livingprofile.com");

        Thread.sleep(3000);
        
        System.out.println("The title of the page is "+ driver.getTitle());
        
   //     Assert.assertEquals(driver.getTitle(),"Sign in to lp-student");

        try {
            new WebDriverWait(driver,  Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='kc-login']")));
            System.out.println("Element is clickable");
        }
        catch(TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
        
        driver.findElement(By.xpath("//h1[contains(text(),'Sign In')]")).isDisplayed();

        driver.findElement(By.xpath("//label[contains(text(),'Email')]")).isDisplayed();

        driver.findElement(By.xpath("//label[contains(text(),'Password')]")).isDisplayed();

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("lpKeycloaktest@mailinator.com");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test#123");

        driver.findElement(By.xpath("//button[@id='kc-login']")).click();
        
        try {
            new WebDriverWait(driver,  Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[contains(text(),'Personal Information')]")));
            System.out.println("Element is clickable");
        }
        catch(TimeoutException e) {
            System.out.println("Element isn't clickable");
        }

        try {
            new WebDriverWait(driver,  Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[contains(text(),'Biographical Information')]")));
            System.out.println("Element is clickable");
        }
        catch(TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
        
        driver.findElement(By.xpath("//h6[contains(text(),'Biographical Information')]")).click();

        driver.findElement(By.xpath("//h1[contains(text(),'Biographical Information')]")).isDisplayed();
        
        driver.findElement(By.cssSelector("div#root div.MuiGrid-root.MuiGrid-container.css-1d3bbye > div > div:nth-child(1) > div > div")).click();
        
        driver.findElement(By.xpath("//h2[normalize-space()='Gender']")).isDisplayed();

        driver.findElement(By.xpath("//input[@id='legalSex']")).click();

        driver.findElement(By.xpath("//li[contains(text(),'Male')]")).click();
        
        driver.findElement(By.xpath("//input[contains(@name,'genderIdentity')]")).sendKeys("Test#123");

        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//input[@id='usCitizenshipStatus']")).click();

        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//li[contains(text(),'U.S. citizen or US national')]")).click();

        Thread.sleep(1000);
        
        WebElement legalCountryOfResidence = driver.findElement(By.xpath("//input[@id='legalCountryOfResidence']"));
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", legalCountryOfResidence);

        legalCountryOfResidence.click();
        
        Thread.sleep(1000);
        
        WebElement Yemen = driver.findElement(By.xpath("//li[contains(text(),'Yemen')]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Yemen);

        Yemen.click();
        
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//input[contains(@name,'visa.issuer')]")).sendKeys("Test#123");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='month_validFrom']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//li[contains(text(),'March')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='date_validFrom']")).sendKeys("20");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='year_validFrom']")).sendKeys("2010");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='month_validTo']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//li[contains(text(),'April')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='date_validTo']")).sendKeys("13");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='year_validTo']")).sendKeys("2013");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='usMilitaryStatus']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//li[contains(text(),'Not a Member of the Military')]")).click();


        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='usMilitaryStatus']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//li[contains(text(),'Not a Member of the Military')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='usMilitaryBranch']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//li[contains(text(),'N/A')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='month_serviceFrom']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//li[contains(text(),'November')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='date_serviceFrom']")).sendKeys("13");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='year_serviceFrom']")).sendKeys("2003");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='month_serviceTo']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//li[contains(text(),'April')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='date_serviceTo']")).sendKeys("13");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='year_serviceTo']")).sendKeys("2013");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//span[contains(text(),'Legal Sex')]")).isDisplayed();

        driver.findElement(By.xpath("//span[contains(text(),'Gender Identity')]")).isDisplayed();

        driver.findElement(By.xpath("//span[contains(text(),'US Citizenship Status')]")).isDisplayed();

        driver.findElement(By.xpath("//span[contains(text(),'Country of Citizenship')]")).isDisplayed();

        driver.findElement(By.xpath("//span[contains(text(),'Visa Issuer')]")).isDisplayed();

        driver.findElement(By.xpath("//span[contains(text(),'Valid From')]")).isDisplayed();
        
    }
    
    @AfterMethod
    public void tearDown(){
        if (api!= null){
            
            String title = "Living Profile Biographical Information page Security Test Report";

          String template = "traditional-html";

//            String template = "Modern HTML Report with themes and options";
//
//            String theme = "Marketing[Light/Purple]";
            
            String description = "Living Profile Biographical Information Security Test Report";
            
            String reportfilename = "LivinfProfile_BIInfo.html";
            
            String targetFolder = System.getProperty("user.dir");
            
            try {
                ApiResponse response = api.reports.generate(title,template,null,description,null,null,null,null,null,reportfilename,null,targetFolder,null);
            
            System.out.println("ZAP Security test report generated at this location "+ response.toString());
            
            } catch (ClientApiException e) {
                e.printStackTrace();
            }

        }
        driver.quit();
    }
}
