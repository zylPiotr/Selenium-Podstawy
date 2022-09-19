package Nauka.Sekcja14.HotelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelSearchPage extends BaseTests{

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchCityWindow;
    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchInput;
    @FindBy(xpath = "//span[text()='Dubai']")
    private WebElement searchResult;
    @FindBy(css = "[class='form input-lg dpd1']")
    private WebElement inputData1;
    @FindBy(css = "[class='form input-lg dpd2']")
    private WebElement inputData2;
    @FindBy(css = "[id='travellersInput']")
    private WebElement travellersInput;
    @FindBy(css = "[id='adultInput']")
    private WebElement adultInput;
    @FindBy(css = "[id='childInput']")
    private WebElement childInput;
    @FindBy(css = "[class^='btn btn-lg']")
    private WebElement searchButton;

    public HotelSearchPage(){
        PageFactory.initElements(driver,this);
    }

    public void pageSetup(){
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
    }
    public void setCity(String cityName){
        searchCityWindow.click();
        searchInput.sendKeys(cityName);
        waitTillExist(By.xpath("//span[text()='Dubai']"));
        searchResult.click();
    }

    public void setDates(String checkin, String checkout){
        inputData1.sendKeys(checkin);
        inputData2.sendKeys(checkout);
    }

    public void setNumberOfTravellers(String adultsAmount,String childAmount){
        travellersInput.click();
        adultInput.clear();
        adultInput.sendKeys(adultsAmount);
        childInput.clear();
        childInput.sendKeys(childAmount);
    }
    public void setSearchButton(){searchButton.click();}

    }

