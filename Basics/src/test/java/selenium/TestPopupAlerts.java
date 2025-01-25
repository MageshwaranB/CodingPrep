package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static selenium.TestSeleniumBasics.*;

public class TestPopupAlerts {


    @Test
    public void handlePopups(){
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("123556");
        driver.findElement(By.name("submit")).click();
        Alert alert = driver.switchTo().alert();
        log.info("Alert text "+alert.getText());
        alert.accept();
        log.info("Alert text "+alert.getText());
        alert.accept();

        driver.get("https://demo.guru99.com/popup.php");
        String parent = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterate=windowHandles.iterator();
        String child_window=iterate.next();
        while (iterate.hasNext()){
            int windowCount = driver.getWindowHandles().size();
//            String child_window=iterate.next();
            log.info("Total window "+ windowCount);
            if (!parent.equalsIgnoreCase(child_window)){
                driver.switchTo().window(child_window);
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                driver.findElement(By.name("btnLogin")).click();
                driver.close();
            }
            driver.switchTo().defaultContent();
        }
    }

}
