package selenium;

import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static selenium.TestSeleniumBasics.driver;
import static selenium.TestSeleniumBasics.log;

public class TestWait {
    @Test
    public void testFluentWait(){
        driver.get("https://saucelabs.com/");
         JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement caseStudy = driver.findElement(By.xpath("//h3[text()='Case Studies']"));
        js.executeScript("arguments[0].scrollIntoView(true);",caseStudy);
        log.info("Text: "+caseStudy.getText());
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        String value = fluentWait.pollingEvery(Duration.ofMillis(250))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .withTimeout(Duration.ofMillis(500))
//                .until(webDriver -> {
//                    return driver.findElement(By.xpath("//p[contains(text(),'Walmart')]"));
//                });
                .until(webDriver -> {
                    WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Walmart')]"));
                    return element.getText();
                });
        log.info("Text: "+value);
        Assert.assertNotNull(value);
        System.out.println(value);
    }
}
