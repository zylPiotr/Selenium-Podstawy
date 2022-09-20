package Nauka.Sekcja14.HotelPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    /*Tworzenie metody do lokalizowania elementów na stronie (ile ich jest)
    @FindBys({
        @FindBy(nazwaSelektora = "nazwaElementu")
        @FindBy(nazwaSelektora = "nazwaElementu")
        @FindBy(nazwaSelektora = "nazwaElementu")
    })
    List<WebElement> nazwaListy;
    Następnie odwołać się do listy elementów w sout'cie i pokaze sie numer elementow kazdego typu.
     **/
    private static final Logger logger = LogManager.getLogger();
    public HotelSearchPage(){
        PageFactory.initElements(BaseTests.driver,this);
    }

    public HotelSearchPage pageSetup(){
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        return this;
    }
    public HotelSearchPage setCity(String cityName){
        logger.info("Setting city: " + cityName);
        searchCityWindow.click();
        searchInput.sendKeys(cityName);
        waitTillExist(By.xpath("//span[text()='Dubai']"));
        searchResult.click();
        logger.info("Setting city done.");
        return this;
    }

    public HotelSearchPage setDates(String checkin, String checkout){
        logger.info("Setting dates check-in: " + checkin + "Setting dates check-out: " + checkout);
        inputData1.sendKeys(checkin);
        inputData2.sendKeys(checkout);
        logger.info("Setting dates done.");
        return this;
    }

    public HotelSearchPage setNumberOfTravellers(String adultsAmount,String childAmount){
        logger.info("Setting amount of adults: " +adultsAmount + "Setting amount of childs: " + childAmount);
        travellersInput.click();
        adultInput.clear();
        adultInput.sendKeys(adultsAmount);
        childInput.clear();
        childInput.sendKeys(childAmount);
        logger.info("Setting number of travelers done.");
        return this;
    }
    public HotelSearchPage setSearchButton(){
        searchButton.click();
        return this;
    }

    }

