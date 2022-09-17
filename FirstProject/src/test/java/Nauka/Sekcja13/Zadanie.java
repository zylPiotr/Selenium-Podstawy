package Nauka.Sekcja13;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Zadanie {

    WebDriver driver;

    @Test
    public void searchAndAssert(){
        driver = ClassWithAllMethods.getDriver();
        driver.get("http://www.kurs-selenium.pl/demo/");

        driver.findElement(By.cssSelector("[class='form input-lg dpd1']")).sendKeys("20/10/2023");
        driver.findElement(By.cssSelector("[class='form input-lg dpd2']")).sendKeys("20/12/2023");
        driver.findElement(By.cssSelector("[id='travellersInput']")).click();
        driver.findElement(By.cssSelector("[id='adultInput']")).clear();
        driver.findElement(By.cssSelector("[id='adultInput']")).sendKeys("3");
        driver.findElement(By.cssSelector("[id='childInput']")).sendKeys("1");
        driver.findElement(By.cssSelector("[class^='btn btn-lg']")).click();

        WebElement element = driver.findElement(By.xpath("//h2[@class='text-center']"));
        Assert.assertTrue(element.isDisplayed());
        System.out.println(element.getText());
    }
}
