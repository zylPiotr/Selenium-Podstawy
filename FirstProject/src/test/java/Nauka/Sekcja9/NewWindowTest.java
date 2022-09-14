package Nauka.Sekcja9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {

    @Test
    public void testNewWindow(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

//Tworzenie odnośnika do obecnego okna
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();

//Tworzenie odnośnika do otwartego linku
        Set<String> windowNames = driver.getWindowHandles();
        for (String window:windowNames){
            if (!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }

        driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']")).click();
        driver.findElement(By.name("q")).sendKeys("losowanazwa",Keys.ENTER);

//Powrót do startowego okna
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Piotrek");

        driver.quit();
    }
}
