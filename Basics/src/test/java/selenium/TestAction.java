package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static selenium.TestSeleniumBasics.driver;

public class TestAction {
    @Test
    public static void testActionsExample(){
        driver.get("https://www.browserstack.com/");
        Actions actions = new Actions(driver);
        WebElement freeTrialElement = driver.findElement(By.xpath("//a[@title='Free Trial']"));
        actions.doubleClick(freeTrialElement).build().perform();
        driver.navigate().back();
        WebElement signup = driver.findElement(By.id("signupModalProductButton"));
        actions.moveToElement(signup).click().build().perform();

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = driver.findElement(By.id("column-a"));
        String beforeSwapSourceText = source.findElement(By.tagName("header")).getText();
        WebElement target = driver.findElement(By.id("column-b"));
        String beforeSwapTargetText = target.findElement(By.tagName("header")).getText();
        actions.dragAndDrop(source,target).build().perform();    
        String afterSwapSourceText = source.findElement(By.tagName("header")).getText();
        String afterSwapTargetText=target.findElement(By.tagName("header")).getText();
        Assert.assertEquals(beforeSwapSourceText,afterSwapTargetText);
        Assert.assertEquals(beforeSwapTargetText,afterSwapSourceText);
    }

}
