package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class TestSeleniumGrid {
     public WebDriver driver;
     Properties properties;
     FileInputStream fis;
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser){
        try {
            fis = new FileInputStream("Basics/src/test/java/selenium/config.properties");
            properties=new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!(properties.getProperty("execution_env").equals("remote"))){
            switch (browser.toLowerCase()){
                case "chrome":
                    driver =new ChromeDriver();
                    break;
                case "firefox":
                    driver =new FirefoxDriver();
                    break;
                default:
                    driver =new EdgeDriver();
            }
        }
        else {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.WIN11);
            switch (browser.toLowerCase()){
                case "chrome":
                    desiredCapabilities.setBrowserName("chrome");
                    break;
                case "firefox":
                    desiredCapabilities.setBrowserName("firefox");
                    break;
                default:
                    desiredCapabilities.setBrowserName("MicrosoftEdge");
            }
//            desiredCapabilities.setCapability("headless",true);
            URL url;
            try {
                String REMOTE_URL = "http://192.168.1.5:4444/wd/hub";
                url = new URL(REMOTE_URL);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver = new RemoteWebDriver(url,desiredCapabilities);

        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testLogin(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
