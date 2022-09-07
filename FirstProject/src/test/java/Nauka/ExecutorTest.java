package Nauka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExecutorTest {

    @Test
    public void executorJavaScript(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",basicPageLink);
        WebElement userName = driver.findElement(By.name("username"));
        executor.executeScript("arguments[0].setAttribute('value','Piotr')",userName);
    }
}
