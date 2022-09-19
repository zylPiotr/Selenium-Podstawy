package Nauka.Sekcja14.Tests;

import Nauka.Sekcja13.BaseTest;
import Nauka.Sekcja14.HotelPages.BaseTests;
import Nauka.Sekcja14.RegistrationPages.SignUpTestPage;
import Nauka.Sekcja14.RegistrationPages.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class NewSignUp extends BaseTests{

    @Test
    public void newSignUpTest(){
        SignUpTestPage signUpTestPage = new SignUpTestPage(BaseTests.getDriver());
        signUpTestPage.pageSetup();
        signUpTestPage.getToRegistrationPage();
        int number = (int) (Math.random()*100000);

        User user = new User();
        user.setName("Czarek");
        user.setLastname("Pieczarek");
        user.setPhone("012345678");
        user.setEmail("tikotiko@" + number + "tokitoki.xy");
        user.setPassword("Pieczarkowehaslo");
        user.setConfirmPassword("Pieczarkowerhaslo");
        signUpTestPage.registration(user);
        signUpTestPage.submitClick();
    }
    @Test
    public void signUpEmptyFormTest(){
        SignUpTestPage signUpTestPage = new SignUpTestPage(BaseTests.getDriver());
        signUpTestPage.pageSetup();
        signUpTestPage.getToRegistrationPage();
        signUpTestPage.submitClick();
        BaseTests.waitTillExist(By.xpath("//div[@class='alert alert-danger']//p"));

        List<String> errors = signUpTestPage.checkErrors();
        System.out.println(errors.size());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The First name field is required."));
        softAssert.assertTrue(errors.contains("The Last Name field is required."));
        softAssert.assertAll();
    }
}
