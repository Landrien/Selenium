package Try;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class essai {
    public static void main(String[] args) {
        // Définir manuellement le chemin des drivers
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\IB\\Desktop\\DEV  PROJECTs/chromedriver-win64/chromedriver.exe");
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\IB\\Desktop\\DEV  PROJECTs/msedgedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\IB\\Desktop\\DEV  PROJECTs/geckodriver.exe");

        WebDriverManager.chromedriver().setup();

        // Lancer les navigateur
        //WebDriver driver = new EdgeDriver();
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        WebElement button = driver.findElement(By.xpath("//div[(@class = \"QS5gu sy4vM\")]"));
        button.click();

        WebElement searchbox = driver.findElement(By.xpath("//textarea[@name = 'q']"));
        searchbox.sendKeys("Selenium");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement button2 = driver.findElement(By.xpath("//input[@name = 'btnK']"));
        button2.click();

        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@title, 'reCAPTCHA')]")));
        WebElement recaptcha = driver.findElement(By.cssSelector(".recaptcha-checkbox-border"));
        recaptcha.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        boolean isPresent = !driver.findElements(By.xpath("/html/body/div[3]/div/div[12]/div[3]/div/div[5]/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div/div/text()")).isEmpty();
        if (!isPresent) {
            System.out.println("L'élément est présent sur la page.");
        } else {
            System.out.println("L'élément n'est PAS présent sur la page.");
        }







        // Naviguer vers une autre page
        //driver.get("https://www.saucedemo.com");
        //System.out.println("Titre navigation : " + driver.getTitle());

        // Fermer le navigateur
        //driver.quit();
    }
}
