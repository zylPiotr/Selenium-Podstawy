package Nauka.Sekcja9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
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

        //Pobieramy wartość pola userName
        WebElement userName = driver.findElement(By.cssSelector("[name='username']"));
        userName.clear();
        userName.sendKeys("Piotr studying very hard atm.");
        System.out.println(userName.getAttribute("value"));

//Pobieramy wartość - hidden class
        WebElement hiddenClass = driver.findElement(By.className("topSecret"));
//Próba poprzez text()
        System.out.println("Text: " + hiddenClass.getText());
//Proóba poprzez attribute(value)
        System.out.println("Attribute: " + hiddenClass.getAttribute("value"));
//Próba poprzez attribute(text content)
        System.out.println("Attribute textContent:" + hiddenClass.getAttribute("textContent"));
//Aby pobrać text należy odszukać odpowiednią zmienną

        //Zamknięcie alertu
        WebElement kliknijMnie = driver.findElement(By.cssSelector("[id*='click']"));
        kliknijMnie.click();
        Alert first = driver.switchTo().alert();
        first.accept();

        WebElement submit = driver.findElement(By.cssSelector("[value*='Su']"));
        submit.click();
        Alert second = driver.switchTo().alert();
        second.accept();
        driver.quit();
    }
}
