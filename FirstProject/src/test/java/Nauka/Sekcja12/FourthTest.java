package Nauka.Sekcja12;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FourthTest {

    //Zależności pomiędzy testami.
    //To zagadanienie mówi o tym, że aby coś się wykonało to musi zostać spełniony pewien warunek.
    //W tym wypadku aby wykonać test nr1 najpierw musi wykonać się test nr3.
    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest(){System.out.println("I am the 1st test.");}

    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest(){System.out.println("I am the 2nd test.");}

    @Test
    public void thirdTest(){System.out.println("I am the 3rd test.");}

    @Test(dataProvider = "data")
    public void dpTest(String val1, String val2) {
        System.out.println(val1);
        System.out.println(val2);
    }


    @DataProvider (name = "data")
    public Object[][] dataProvider(){
        return new Object[][] {{"First test."," fTest"},{"Second Test."," sTest"},{"Third Test."," tTest"}};
    }
}
