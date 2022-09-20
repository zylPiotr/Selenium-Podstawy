package Nauka.Sekcja14.Tests;

import Nauka.Sekcja14.HotelPages.BaseTests;
import Nauka.Sekcja14.RegistrationPages.SignUpTestPage;
import Nauka.Sekcja14.RegistrationPages.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class NewSignUp extends BaseTests{

    @Test
    public void newSignUpTest() throws IOException {
        SignUpTestPage signUpTestPage = new SignUpTestPage(BaseTests.getDriver())
                .pageSetup()
                .getToRegistrationPage();
        int number = (int) (Math.random()*100000);

        User user = new User()
                .setName("Czarek")
                .setLastname("Pieczarek")
                .setPhone("012345678")
                .setEmail("tikotiko@" + number + "tokitoki.xy")
                .setPassword("Pieczarkowehaslo")
                .setConfirmPassword("Pieczarkowerhaslo");
        signUpTestPage.registration(user)
                .submitClick();
    }
    @Test
    public void signUpEmptyFormTest() throws IOException {
        SignUpTestPage signUpTestPage = new SignUpTestPage(BaseTests.getDriver())
                .pageSetup()
                .getToRegistrationPage()
                .submitClick();
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
