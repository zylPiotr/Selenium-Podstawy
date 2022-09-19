package Nauka.Sekcja14.Tests;

import Nauka.Sekcja14.HotelPages.BaseTests;
import Nauka.Sekcja14.HotelPages.HotelSearchPage;
import Nauka.Sekcja14.HotelPages.ResultsPage;
import org.testng.annotations.Test;

import java.util.List;

public class NewHotelSearch extends BaseTests{

    @Test
    public void newSearchOfHotel(){
        HotelSearchPage hotelSearchPage = new HotelSearchPage()
                .pageSetup()
                .setCity("Dubai")
                .setDates("01/01/2024","01/01/2025")
                .setNumberOfTravellers("4","2")
                .setSearchButton();
        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();
        System.out.println();
        hotelNames.forEach(System.out::println);
    }
}
