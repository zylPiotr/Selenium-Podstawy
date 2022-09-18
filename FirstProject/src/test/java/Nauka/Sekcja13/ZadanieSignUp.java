package Nauka.Sekcja13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ZadanieSignUp extends ClassWithAllMethods {
    @Test
    public void signUpTest(){
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo");

        driver.findElements(By.cssSelector("[id='li_myaccount']"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElements(By.cssSelector("[href='http://www.kurs-selenium.pl/demo/register']"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElement(By.cssSelector("[class*='signupbtn']")).click();

        ClassWithAllMethods.waitTillExist(By.xpath("//div[@class='alert alert-danger']//p"));
        List<String> errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p"))
                .stream()
                .map(WebElement::getText)
                .toList();

        System.out.println(errors.size());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The First name field is required."));
        softAssert.assertTrue(errors.contains("The Last Name field is required."));
        softAssert.assertAll();
    }
}
