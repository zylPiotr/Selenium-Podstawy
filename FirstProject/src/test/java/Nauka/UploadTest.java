package Nauka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadTest {

    @Test
    public void uploadTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\Piotr\\Desktop\\Git commands.docx");

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        int number = (int) (Math.random()*100);
        String fileName = "Screen" + number +".png";
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src/test/resources/" + fileName));

        //Klasa action i ppm

        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();

        driver.quit();
    }
}
