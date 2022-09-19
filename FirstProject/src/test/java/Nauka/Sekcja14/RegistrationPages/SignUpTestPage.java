package Nauka.Sekcja14.RegistrationPages;

import Nauka.Sekcja13.BaseTest;
import Nauka.Sekcja14.HotelPages.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class SignUpTestPage extends BaseTests {

    @FindBy(xpath = "//li[@id='li_myaccount']")
    private List<WebElement> clickOnMyAccount;
    @FindBy(xpath = "//a[text()='  Sign Up']")
    private List<WebElement> clickOnSignUp;
    @FindBy(css = "[name='firstname']")
    private WebElement Name;
    @FindBy(css = "[name='lastname']")
    private WebElement Lastname;
    @FindBy(css = "[name='phone']")
    private WebElement Phone;
    @FindBy(css = "[name='email']")
    private WebElement Email;
    @FindBy(css = "[name='password']")
    private WebElement Password;
    @FindBy(css = "[name='confirmpassword']")
    private WebElement ConfirmPassword;
    @FindBy(css = "[type='submit']")
    private List<WebElement> submit;
    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private List<WebElement> errorsList;

    public SignUpTestPage(WebDriver driver){PageFactory.initElements(driver,this);}

    public SignUpTestPage pageSetup(){
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().window().maximize();
        return this;
    }

    public SignUpTestPage getToRegistrationPage(){
        clickOnMyAccount.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        clickOnSignUp.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        return this;
    }

    public SignUpTestPage registration(User user){
        Name.sendKeys(user.getName());
        Lastname.sendKeys(user.getLastname());
        Phone.sendKeys(user.getPhone());
        Email.sendKeys(user.getEmail());
        Password.sendKeys(user.getPassword());
        ConfirmPassword.sendKeys(user.getConfirmPassword());
        return this;
    }

    public SignUpTestPage submitClick(){
        submit.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        return this;
    }

    public List<String> checkErrors(){
        return errorsList.stream().map(WebElement::getText).toList();
    }

    }

