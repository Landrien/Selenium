package Try;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Exercice3 {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        // Lancer le navigateur Chrome
        //WebDriver driver = new EdgeDriver();
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Localiser la liste déroulante
        WebElement dropdownElement = driver.findElement(By.xpath("//select"));

        // Créer un objet Select
        Select list = new Select(dropdownElement);


        // Sélectionner "Option 1"
        list.selectByValue("1");
        String selectedText = list.getFirstSelectedOption().getText();
        System.out.println(selectedText);
        System.out.println(selectedText.equals("Option 1") ? "Apparait" : "N'Apparait pas");

        // Sélectionner "Option 2"
        list.selectByVisibleText("2");

        // Vérifier si "Option 2" est sélectionnée
        String selectedText2 = list.getFirstSelectedOption().getText();
        System.out.println(selectedText2);
        System.out.println(selectedText2.equals("Option 2") ? "Apparait" : "N'Apparait pas");

        driver.quit();

        /*
        // Trouver toutes les cases à cocher dans la liste
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        // Parcourir la liste et cocher chaque case
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        checkboxes.get(2).click();
    */}
}
