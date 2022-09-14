package Nauka.Sekcja9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class LokalizacjaZaPomocaXpath {

    public static void main(String[] args) {

        // Okreslenie naszego wyrazu
        String test = "userNameInInternet";

        //Okreslamy ile liter od lewej strony ma zniknac

//        String substring = test.substring(4);
//        System.out.println(substring);

        //Określamy ile liter od prawej strony ma zostac pokazane

        String substring = test.substring(test.length()-8);
        System.out.println(substring);
    }

    @Test
    public void zwyczajnyTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement selectCarType = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCarType);
        cars.selectByIndex(0);

// Tworzymy liste WebElementow dla cars z Selecta, ktora nazywa sie options.
        List<WebElement> options = cars.getOptions();

// A teraz robimy petle, ktora przedstawi te elementy w konsoli tj. dla
// WebElementow, ktore nazwiemy option bedzie wyswietlala elementy
// dopoki nie skoncza sie opcje (options) z powyzszej listy
        for (WebElement option : options)
        {
            System.out.println(option.getText());
        }

        Zadanie_190 zadanie = new Zadanie_190();
        System.out.println(zadanie.checkSelectOptions("Kaudi",selectCarType));
        System.out.println(zadanie.checkSelectOptions("Audi",selectCarType));

        driver.close();

        }
    }

