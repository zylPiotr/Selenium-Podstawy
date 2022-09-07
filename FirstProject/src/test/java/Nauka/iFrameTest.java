package Nauka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iFrameTest {

    @Test
    public void iFrameTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");

//Przełączenie do iframe'a
        WebElement iFrame =driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iFrame);    //Przelaczenie sie do iframe 1 przez WebElement
//        driver.switchTo().frame(0);       //Przelaczenie sie do iframe przez index
        driver.findElement(By.id("clickOnMe")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

//Przełączenie na stronę główną
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.quit();
    }
}
