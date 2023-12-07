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

public class ZAP_SecurityTest_Achievements_ExperiencesPage {
    
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
        
     //   co.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(co);
        
        api = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);
        
    }
    
    @Test
    public void LivingProfileSecurityTest() throws InterruptedException {
        
        driver.get("https://keycloak.dev-living-profile.com/realms/lp-student/protocol/openid-connect/auth?client_id=lp-student&redirect_uri=http%3A%2F%2Fui.dev-living-profile.com%2Fpersonal-information&state=92a38f2e-014f-46bb-887b-954cd8f38008&response_mode=fragment&response_type=code&scope=openid&nonce=92c4956b-d07f-4bda-8039-59347e09aa73&code_challenge=x9muLttnGmykjdwJIsoGVCyxEAdXG0X1xYbY4vpOf8s&code_challenge_method=S256");

        Thread.sleep(3000);
        
        System.out.println("The title of the page is "+ driver.getTitle());
        
        Assert.assertEquals(driver.getTitle(),"Sign in to lp-student");

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
        
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("varunh8892@gmail.com");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Welcome1!");
        
        driver.findElement(By.xpath("//button[@id='kc-login']")).click();
        
        try {
            new WebDriverWait(driver,  Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[contains(text(),'Personal Information')]")));
            System.out.println("Element is clickable");
        }
        catch(TimeoutException e) {
            System.out.println("Element isn't clickable");
        }

        try {
            new WebDriverWait(driver,  Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[contains(text(),'Achievements & Experiences')]")));
            System.out.println("Element is clickable");
        }
        catch(TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
        
        driver.findElement(By.xpath("//h6[contains(text(),'Achievements & Experiences')]")).click();

        driver.findElement(By.xpath("//h1[contains(text(),'Achievements & Experiences')]")).isDisplayed();

        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("div#root div.MuiGrid-root.MuiGrid-container.css-1d3bbye > div > div:nth-child(1) > div > div")).click();

        Thread.sleep(2000);
       
        driver.findElement(By.xpath("//h6[contains(text(),'Languages Proficiency')]")).isDisplayed();

        driver.findElement(By.xpath("//input[@id='language-0']")).click();

        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//li[contains(text(),'English')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='proficiencyLevel-0']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//li[contains(text(),'Beginner')]")).click();

        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[@aria-label=\"Add New Honor or Award\"]")).click();

        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@name=\"honorsOrAwards.0.name\"]")).sendKeys("Welcome1!");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name=\"honorsOrAwards.0.source\"]")).sendKeys("Welcome1!");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='month_receivedDate']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//li[contains(text(),'March')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='date_receivedDate']")).sendKeys("20");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='year_receivedDate']")).sendKeys("2010");

        Thread.sleep(3000);
        
    //    driver.findElement(By.xpath("(//button[contains(text(),'Save')])[1]")).click();

        WebElement ele = driver.findElement(By.xpath("(//button[contains(text(),'Save')])[1]"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();",ele);

        Thread.sleep(3000);
        
        
//        
//        Thread.sleep(1000);
//        
//        driver.findElement(By.xpath("//label[@for=\"modalityOfEducation\"]//ancestor::div[1]//descendant::span[contains(text(),'Select one or more')]")).click();
//
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath("//span[contains(text(),'Full-time')]")).click();
//
//        Thread.sleep(2000);
//        
//        driver.findElement(By.xpath("(//h1[contains(text(),'Academic Goals')])[2]")).click();
//        
//        driver.findElement(By.xpath("(//label[contains(text(),'Degrees Seeking')]//ancestor::div[1]//descendant::span)[1]")).click();
//
//        Thread.sleep(2000);
//        
//        driver.findElement(By.xpath("//span[contains(text(),'Associates')]")).click();
//
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath("//label[contains(text(),'Fields of Study')]")).click();
//
//        Thread.sleep(2000);
//  
//        driver.findElement(By.xpath("(//label[contains(text(),'Fields of Study')]//ancestor::div[1]//descendant::span)[1]")).click();
//
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath("//span[contains(text(),'Accounting')]")).click();
//
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath("(//h1[contains(text(),'Academic Goals')])[2]")).click();
//
//        Thread.sleep(1000);
//        
//        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
//
//        driver.findElement(By.xpath("//span[contains(text(),'Modality of education')]")).isDisplayed();
//
//        driver.findElement(By.xpath("//span[contains(text(),'Degrees Seeking')]")).isDisplayed();
//
//        driver.findElement(By.xpath("//span[contains(text(),'Fields of Study')]")).isDisplayed();
//
//        Thread.sleep(3000);
//
//        driver.findElement(By.xpath("//span[contains(text(),'Modality of education')]")).isDisplayed();
//
//        driver.findElement(By.xpath("//span[contains(text(),'Degrees Seeking')]")).isDisplayed();
//
//        driver.findElement(By.xpath("//span[contains(text(),'Fields of Study')]")).isDisplayed();
//
//        Thread.sleep(2000);
        
    }
    
    @AfterMethod
    public void tearDown(){
        if (api!= null){
            
            String title = "Living Profile Achievements & Experiences page Security Test Report";

            String template = "traditional-html";
            
            String description = "Living Profile Achievements & Experiences Security Test Report";
            
            String reportfilename = "LivinfProfile.html";
            
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
