package selenium;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class TestGetAllLinks {
    public static void main(String[] args) throws IOException {
        String url="https://www.ebay.com/";
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        List<WebElement> completeLinks = driver.findElements(By.tagName("a"));
        completeLinks.addAll(driver.findElements(By.tagName("img")));
        List<WebElement> activeLinks=new ArrayList<>();
        System.out.println("Total links:"+completeLinks.size());
        for (int i = 0; i < completeLinks.size(); i++) {
            System.out.println("Current link: "+completeLinks.get(i).getDomAttribute("href"));
            if ((completeLinks.get(i).getDomAttribute("href")!=null) && ((completeLinks.get(i).getDomAttribute("href")).contains("https"))){
                activeLinks.add(completeLinks.get(i));
                System.out.println("Valid link: "+completeLinks.get(i).getDomAttribute("href"));
            }
        }
        System.out.println("Active links:"+activeLinks.size());

        ArrayList<WebElement> workingLinks=new ArrayList<>();
        for(int i =0; i<activeLinks.size();i++){
            String urls = activeLinks.get(i).getDomAttribute("href");
            assert urls != null;
                HttpURLConnection connection = (HttpURLConnection) new URL(urls).openConnection();
                connection.connect();
                String responseCode=connection.getResponseMessage();
                System.out.println("Response code for link "+ activeLinks.get(i).getDomAttribute("href") +"is "+ responseCode);
                connection.disconnect();
                if (responseCode.equalsIgnoreCase("OK")){
                workingLinks.add(activeLinks.get(i));
            }
        }
        System.out.println(workingLinks.size());
        driver.quit();
    }
}
