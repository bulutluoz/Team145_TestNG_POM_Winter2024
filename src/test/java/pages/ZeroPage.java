package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {

    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "Zero Bank")
    public WebElement zeroLogo;

    @FindBy(id = "signin_button")
    public WebElement signInButonu;

    @FindBy(id ="user_login")
    public WebElement loginKutusu;

    @FindBy(id ="user_password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@value='Sign in']")
    public WebElement signinSayfasiSignInButonu;

    @FindBy (xpath = "(//*[@class='dropdown-toggle'])[1]")
    public WebElement settingsTusu;

    @FindBy(xpath = "(//*[text()='Online Banking'])[1]")
    public WebElement onlineBankingLinki;

    @FindBy(id="pay_bills_link")
    public WebElement payBillsLinki;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseCurrencyMenu;

    @FindBy(id="pc_currency")
    public WebElement currencyDropdownMenu;

}
