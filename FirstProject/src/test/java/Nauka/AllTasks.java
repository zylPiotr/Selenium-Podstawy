package Nauka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AllTasks {

    @Test
    public void feelFreeToTestThisWebsite(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement userName = driver.findElement(By.cssSelector("[name='username']"));
        userName.clear();
        userName.sendKeys("Piotr studying very hard atm.");
        System.out.println(userName.getAttribute("value"));

        driver.quit();
    }
}
