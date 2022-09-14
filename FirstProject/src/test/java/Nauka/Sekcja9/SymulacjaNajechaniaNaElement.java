package Nauka.Sekcja9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SymulacjaNajechaniaNaElement {

    @Test
    public void najechanieNaElement(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        Actions actions = new Actions(driver);

        WebElement heading = driver.findElement(By.tagName("h1"));

        actions.moveToElement(heading).perform();

        //Pobieranie tytułu strony i adresu URL

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.close();
    }
}
