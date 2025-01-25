package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class TestSeleniumBasics {
    static WebDriver driver;
    static Logger log;
    @BeforeSuite
    public void setup(){
        ChromeOptions options=new ChromeOptions();
        options.setAcceptInsecureCerts(true);
//        options.addExtensions(new File("C:\\Users\\ADMIN\\IdeaProjects\\HackerProblems\\Basics\\Extensions\\StandsAdblocker.crx"));
        options.addArguments("--incognito");
        driver=new ChromeDriver(options);
        log=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public static void sampleTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        var title= driver.getTitle();
        Assert.assertEquals(title,"Swag Labs");
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement passWord = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        userName.sendKeys("standard_user");
        Thread.sleep(5);
        log.info("Entered the username: "+ userName.getText());
        passWord.sendKeys("secret_sauce");
        Thread.sleep(5);
        log.info("Entered the Password: "+ passWord.getText());
        loginButton.click();
        Thread.sleep(10);
        log.info("Clicked the Login button");
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText(),"Products");
    }

    @Test(enabled = false)
    public static void xPathAxes(){
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Following sibling
        WebElement emailFollowingSib = driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[1]"));
        emailFollowingSib.sendKeys("Tester");
        //Preceding sibling
        WebElement checkboxPrecedingSibling = driver.findElement(By.xpath("//td[text()='Maria Anders']/preceding-sibling::td/child::input"));
        checkboxPrecedingSibling.click();
        //Descendant
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='container']/descendant::div[@class='buttons']/button"));
        for(WebElement button: buttons){
            System.out.println(button.getText());
        }
        //Ancestor
        WebElement firstNameAncestor = driver.findElement(By.xpath("//div[@class='buttons']/ancestor::div[@class='container']/label[1]/following-sibling::input[1]"));
        firstNameAncestor.sendKeys("Tester");
    }

    @AfterSuite
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
