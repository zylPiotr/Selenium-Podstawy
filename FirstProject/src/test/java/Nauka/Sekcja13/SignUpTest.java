package Nauka.Sekcja13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    @Test
    public void zadanieTestowe(){
    driver.get("http://www.kurs-selenium.pl/demo/");
    driver.manage().window().maximize();

    int number = (int) (Math.random()*1000000);

    driver.findElements(By.xpath("//li[@id='li_myaccount']"))
            .stream()
            .filter(WebElement::isDisplayed)
            .findFirst()
            .ifPresent(WebElement::click);

    driver.findElements(By.xpath("//a[text()='  Sign Up']"))
            .stream()
            .filter(WebElement::isDisplayed)
            .findFirst()
            .ifPresent(WebElement::click);

    driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Czarek");
    driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Pieczarek");
    driver.findElement(By.cssSelector("[name='phone']")).sendKeys("999777555");
    driver.findElement(By.cssSelector("[name='email']")).sendKeys("tikotiko" + number + "@kotikoti.com");
    driver.findElement(By.cssSelector("[name='password']")).sendKeys("kotitiko123");
    driver.findElement(By.cssSelector("[name='confirmpassword']")).sendKeys("kotitiko123");

    driver.findElements(By.cssSelector("[type='submit']"))
            .stream()
            .filter(WebElement::isDisplayed)
            .findFirst()
            .ifPresent(WebElement::click);
        }
    }

