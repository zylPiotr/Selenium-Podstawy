package Nauka.Sekcja14.HotelPages;

import Nauka.Sekcja14.Utilis.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BaseTests {

    protected static WebDriver driver;
    @BeforeMethod
    public static WebDriver getDriver() throws IOException {
        if (driver == null){
            driver = DriverFactory.getDriver();
        }
        return driver;
    }
    @AfterMethod
    public void tearDown(){driver.quit();}


    //Metody
    public static void waitTillExist(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(300));

        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0){
                System.out.println("Element sie pojawil");
            return true;
        }
            else {
                System.out.println("Brak elementu");
                return false;
            }
        });
    }
}
