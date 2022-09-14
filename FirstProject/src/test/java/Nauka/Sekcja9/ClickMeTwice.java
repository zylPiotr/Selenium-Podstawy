package Nauka.Sekcja9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClickMeTwice {

    @Test
    public void clickOnMe(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
        driver.findElement(By.cssSelector("[href='doubleclick.html']")).click();

        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.id("bottom"))).perform();

        driver.quit();

    }
}
