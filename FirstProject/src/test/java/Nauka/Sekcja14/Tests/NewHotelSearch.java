package Nauka.Sekcja14.Tests;

import Nauka.Sekcja14.Pages.BaseTests;
import Nauka.Sekcja14.Pages.HotelSearchPage;
import Nauka.Sekcja14.Pages.ResultsPage;
import org.testng.annotations.Test;

import java.util.List;

public class NewHotelSearch extends BaseTests{

    @Test
    public void newSearchOfHotel(){
        HotelSearchPage hotelSearch = new HotelSearchPage();
        hotelSearch.pageSetup();
        hotelSearch.setCity("Dubai");
        hotelSearch.setDates("01/01/2024","01/01/2025");
        hotelSearch.setNumberOfTravellers("4","2");
        hotelSearch.setSearchButton();

        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();
        System.out.println();
        hotelNames.forEach(System.out::println);
    }
}
