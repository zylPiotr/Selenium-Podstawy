package Nauka.Sekcja11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitMetod {

    @Test
    public void waitMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        driver.findElement(By.linkText("Oczekiwanie na element I")).click();
        driver.findElement(By.id("clickOnMe")).click();

        //FluentWait domyślnie nie ignoruje, żadnych wyjątków
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));

        //Możemy ustawić co jaki czas nasz Timeout będzie sprawdzał czy zmienna się pojawiłą
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
    }
}