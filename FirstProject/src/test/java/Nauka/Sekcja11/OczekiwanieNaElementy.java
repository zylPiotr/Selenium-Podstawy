package Nauka.Sekcja11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class OczekiwanieNaElementy {

    @Test
    public void waitMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testeroprogramowania.github.io/selenium/");

        driver.findElement(By.linkText("Oczekiwanie na element I")).click();
        driver.findElement(By.id("clickOnMe")).click();

//Metoda, która czeka 5s
       // Thread.sleep(5000);

        //WebDriverWait domyślnie ignoruje wyjątki
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        WebElement text = driver.findElement(By.cssSelector("p"));
        System.out.println(text.isDisplayed());

    }

}
