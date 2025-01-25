package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleDropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
        Thread.sleep(5000);
        List<WebElement> results = driver.findElements(By.xpath("//ul[@class='G43f7e' and @role='listbox']/li"));
        for (WebElement current:results){
            if (current.getText().equalsIgnoreCase("selenium webdriver")){
                current.click();
                break;
            }
        }
        Thread.sleep(8000);
        driver.quit();
    }
}
