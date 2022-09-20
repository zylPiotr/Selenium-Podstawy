package Nauka.Sekcja14.Tests;

import Nauka.Sekcja14.HotelPages.BaseTests;
import Nauka.Sekcja14.HotelPages.HotelSearchPage;
import Nauka.Sekcja14.HotelPages.ResultsPage;
import Nauka.Sekcja14.Utilis.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class NewHotelSearch extends BaseTests{

    @Test(dataProvider = "data")
    public void newSearchOfHotel(String city, String hotel) throws InterruptedException {
        HotelSearchPage hotelSearchPage = new HotelSearchPage()
                .pageSetup()
                .setCity(city)
                .setDates("01/01/2024","01/01/2025")
                .setNumberOfTravellers("4","2")
                .setSearchButton();
        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();
        System.out.println();
        hotelNames.forEach(System.out::println);
        Assert.assertEquals(hotel, hotelNames.get(0));
    }
    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("testData.xlsx");
    }
}
