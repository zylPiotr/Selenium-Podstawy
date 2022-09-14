package Nauka.Sekcja12;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite(){System.out.println("Before suite - Pojawiam się przed testem!");}

    @BeforeTest
    public void beforeTest(){
        System.out.println("Powinienem się pojawić przed testem!");
    }

    @BeforeClass
    public void beforeClass(){System.out.println("Pojawiam się przed klasa!");}

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Powinienem się pojawić przed metodą!");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Powinienem sie pojawic po metodzie");
    }

    @AfterClass
    public void afterClass(){System.out.println("Pojawiam się po wykonaniu się zawartosci klasy!");}

    @AfterTest
    public void afterTest(){
        System.out.println("Powinienem się pojawic po tescie");
    }

    @AfterSuite
    public void afterSuite() {System.out.println("After suite - pojawiam się po tescie!");
    }
}
