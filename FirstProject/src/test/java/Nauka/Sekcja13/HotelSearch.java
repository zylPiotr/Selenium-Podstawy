package Nauka.Sekcja13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HotelSearch {

    WebDriver driver;

    @Test
    public void zadanieTestowe(){
    driver = ClassWithAllMethods.getDriver();
    driver.get("http://www.kurs-selenium.pl/demo/");
    driver.manage().window().maximize();

    driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
    driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");
    ClassWithAllMethods.waitTillExist(By.xpath("//span[text()='Dubai']"));
    driver.findElement(By.xpath("//span[text()='Dubai']")).click();
    driver.findElement(By.cssSelector("[class='form input-lg dpd1']")).sendKeys("19/10/2022");
    driver.findElement(By.cssSelector("[class='form input-lg dpd2']")).sendKeys("23/10/2023");
    driver.findElement(By.cssSelector("[id='travellersInput']")).click();
    ClassWithAllMethods.waitTillExist(By.cssSelector("[id='adultInput']"));
    driver.findElement(By.cssSelector("[id='adultInput']")).clear();
    driver.findElement(By.cssSelector("[id='adultInput']")).sendKeys("4");
    driver.findElement(By.cssSelector("[id='childInput']")).sendKeys("2");
    driver.findElement(By.cssSelector("[class^='btn btn-lg']")).click();
    List<String> hotelNames = driver.findElements(By.cssSelector("[class*='list_title']"))
            .stream()
            .map(el -> el.getAttribute("textContent"))
            .toList();

        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));


//    driver.quit();

        }
    }

