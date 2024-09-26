package tests.day16_TestNG_Framework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_FacebookTesti {

    @Test
    public void facebookTesti(){

        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        ReusableMethods.bekle(1);

        //2- Cookies cikiyorsa kabul edin
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookiesKabulButonu.click();
        ReusableMethods.bekle(1);

        //3- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        //   page class'inda yaptik

        //4- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin

        Faker faker = new Faker();

        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());

        facebookPage.loginButonu.click();

        //5- Basarili giris yapilamadigini test edin
        ReusableMethods.bekle(5);

        Assert.assertTrue( facebookPage.emailKutusu.isEnabled() );

        Driver.quitDriver();
    }
}
