package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static Properties testData;
    public static FileInputStream fis;
    public static WebDriver driver;
    public TestBase(){
        loadPropFile();
    }
    public void loadPropFile(){
        testData = new Properties();
        try {
            fis = new FileInputStream("src/test/java/Utils/testData.properties");
            testData.load(fis);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void setup(){
        String browser = "chrome";
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
        } else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
            WebDriverManager.firefoxdriver().setup();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void getUrl(String url){
        driver.get(url);
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Inside before method annotation");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Inside after method annotation");
    }
    @AfterClass
    public void tearDown(){
        System.out.println("Inside after class annotation");
        if(driver != null){
            driver.quit();
        }
    }
}
