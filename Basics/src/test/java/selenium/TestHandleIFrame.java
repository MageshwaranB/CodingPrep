package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

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


}
