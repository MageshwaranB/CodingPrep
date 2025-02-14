package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static selenium.TestSeleniumBasics.driver;
import static selenium.TestSeleniumBasics.log;

public class TestHandleIFrame {

    @Test
    public static void testIFrame(){
        driver.get("https://demoqa.com/frames");
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        for (WebElement iframe:frames){
            int count=1;
            if (frames.size() <=count){
                driver.switchTo().frame(iframe);
                WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
                System.out.println(sampleHeading.getText());
                log.info("Frame "+count +"Text: "+sampleHeading.getText());
                count++;
            }
            else {
                break;
            }
        }
    }

    @Test
    public static void testAnotherIFrameExercise(){
        driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> frames=driver.findElements(By.tagName("iframe"));

        for (int i=0;i<frames.size();i++){
            WebDriver currentFrame = driver.switchTo().frame(i);
            if (currentFrame==driver.switchTo().frame("frm1")){
                WebElement dropdown=driver.findElement(By.id("selectnav1"));
                Select select=new Select(dropdown);
                select.selectByValue("Selenium Practice");
                System.out.println("This is the correct iframe");
                break;
            }
            else {
                driver.switchTo().defaultContent();
                System.out.println("This is not the correct iframe");
            }

        }
        driver.quit();
    }


}
