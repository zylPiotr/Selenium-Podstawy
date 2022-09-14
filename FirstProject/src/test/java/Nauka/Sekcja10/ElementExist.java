package Nauka.Sekcja10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExist {

    WebDriver driver;

    @Test
    public void checkIfElementExist(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //Sprawdzenie czy istnieje
        System.out.println(checkIfExist(By.tagName("p")));
        System.out.println(checkIfExist(By.className("topSecret")));

        //Sprawdzenie czy jest wyswietlony
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());

        //Sprawdzenie czy mozna go uzyc
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());

        //Sprawdzenie czy jest zaznaczony
        System.out.println(driver.findElement(By.cssSelector("[type='checkbox']")).isSelected());

        //Sprawdzenie czy obrazek zostal zaladowany
        WebElement image = driver.findElement(By.tagName("img"));
        System.out.println(image.getAttribute("naturalHeight"));

        Assert.assertEquals(223,223);
    }

    public boolean checkIfExist(By locator){
        try{
            driver.findElement(locator);
            return true;
        }catch(NoSuchElementException exception) {
            return false;
        }
    }
}
