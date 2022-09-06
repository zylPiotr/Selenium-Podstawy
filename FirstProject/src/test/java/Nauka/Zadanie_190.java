package Nauka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Zadanie_190 {

    //Napisz metodę, która przyjmuje String jako parametr i zwraca boolean
    //Metoda ma sprawdzac czy parametr String jest jedną z opcji Select'a

        public boolean checkSelectOptions(String optionText, WebElement element){
            Select select = new Select(element);
            List<WebElement> options = select.getOptions();
            for (WebElement option : options){
                if (option.getText().contains(optionText))
                    return true;
            }
        return false;
        }



}
