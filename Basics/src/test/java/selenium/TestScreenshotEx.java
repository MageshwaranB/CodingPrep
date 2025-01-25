package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


import static selenium.TestSeleniumBasics.driver;
import static selenium.TestSeleniumBasics.log;

public class TestScreenshotEx {
    @Test
    public void takeScreenshot() {
        driver.get("https://www.browserstack.com/");
        TakesScreenshot ss=(TakesScreenshot) driver;
        File src = ss.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"/Screenshot/"+ Thread.currentThread().getStackTrace()[1].getMethodName()+"_test.png";
        File dest=new File(path);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testFullPageScreenshot() throws IOException {
        driver.get("https://www.lambdatest.com/blog/taking-screenshots-in-selenium-webdriver-using-javascript/");
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        String path=System.getProperty("user.dir")+"/Screenshot/"+ Thread.currentThread().getStackTrace()[1].getMethodName()+"_test.png";
        ImageIO.write(screenshot.getImage(),"PNG", new File(path));
    }

    @Test
    public void testWebElementScreenshot(){
        driver.get("https://www.lambdatest.com/blog/taking-screenshots-in-selenium-webdriver-using-javascript/");
        WebElement signUp = driver.findElement(By.cssSelector(".login.signup__cta"));
        File src = signUp.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"/Screenshot/"+ Thread.currentThread().getStackTrace()[1].getMethodName()+"_test.png";
        File dest=new File(path);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
