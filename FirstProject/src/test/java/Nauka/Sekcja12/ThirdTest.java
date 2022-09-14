package Nauka.Sekcja12;

import org.testng.annotations.Test;

public class ThirdTest {


    //Ustawienie priorytetu testu polega na ustaleniu jego kolejnosci wykonywania tj.
    //To jak ważny jest test określane jest od 0 w dół  = najpierw wykona się test 0, pozniej 1 itd.
    @Test(priority = 1)
    public void firstTest(){System.out.println("I am the 1st test.");}

    @Test(priority = 2)
    public void secondTest(){System.out.println("I am the 2nd test.");}

    @Test(priority = 0)
    public void thirdTest(){System.out.println("I am the 3rd test.");}
}
