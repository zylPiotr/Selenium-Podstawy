package Nauka.Sekcja14.Tests;

import Nauka.Sekcja14.HotelPages.BaseTests;
import Nauka.Sekcja14.HotelPages.HotelSearchPage;
import Nauka.Sekcja14.HotelPages.ResultsPage;
import Nauka.Sekcja14.Utilis.ExcelReader;
import Nauka.Sekcja14.Utilis.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class NewHotelSearch extends BaseTests{

    protected static HotelSearchPage hotelSearchPage;
    @Test(dataProvider = "data")
    public void newSearchOfHotel(String city, String hotel) throws InterruptedException, IOException {
        ExtentTest test = extentReports.createTest("New Hotel Search");
        hotelSearchPage = new HotelSearchPage().pageSetup();
                test.log(Status.PASS,"Page setup done.", SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.setCity(city);
                test.log(Status.PASS,"Setting city done.", SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.setDates("01/01/2024","01/01/2025");
                test.log(Status.PASS,"Setting dates check-in/out done.", SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.setNumberOfTravellers("4 ","2 ");
                test.log(Status.PASS,"Setting number of travellers done.", SeleniumHelper.getScreenshot(driver));
        hotelSearchPage.setSearchButton();
                test.log(Status.PASS,"Search button used.", SeleniumHelper.getScreenshot(driver));
        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();
        System.out.println();
        hotelNames.forEach(System.out::println);
        Assert.assertEquals(hotel, hotelNames.get(0));
                test.log(Status.PASS, "Asserts complete", SeleniumHelper.getScreenshot(driver));
    }
    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("testData.xlsx");
    }
}
