package Try;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class exercice5 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);


            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            // Gérer la première alerte (Simple Alert)
            WebElement alertButton1 = driver.findElement(By.xpath("//*[@onclick='jsAlert()']"));
            alertButton1.click();
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            String result1 = driver.findElement(By.id("result")).getText();
            System.out.println(result1);
            System.out.println(result1.equals("You successfully clicked an alert") ? "Apparait" : "N'Apparait pas");

            // Gérer la deuxième alerte (Confirm Alert)
            WebElement alertButton2 = driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"));
            alertButton2.click();
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
            String result2 = driver.findElement(By.id("result")).getText();
            System.out.println(result2);
            System.out.println(result2.equals("You clicked: Cancel") ? "Apparait" : "N'Apparait pas");

            // Gérer la troisième alerte (Prompt Alert)
            WebElement alertButton3 = driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"));
            alertButton3.click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String mess = "coco";
            alert.sendKeys(mess);
            alert.accept();
            String result3 = driver.findElement(By.id("result")).getText();
            System.out.println(result3);
            System.out.println(result3.equals("You entered: " + mess) ? "Apparait" : "N'Apparait pas");

    }

}
