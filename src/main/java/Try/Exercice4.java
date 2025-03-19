package Try;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Exercice4 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();


        //WebDriver driver = new EdgeDriver();
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement Link1 = driver.findElement(By.cssSelector("a[href='/windows/new']"));
        Link1.click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String result = driver.findElement(By.xpath("//h3")).getText();
        System.out.println(result);
        System.out.println(result.equals("New Window") ? "Apparait" : "N'Apparait pas");
        driver.close();
        driver.switchTo().window(tabs.get(0));

    }




}
