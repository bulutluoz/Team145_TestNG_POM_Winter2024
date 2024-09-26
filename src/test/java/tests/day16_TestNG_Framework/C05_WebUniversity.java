package tests.day16_TestNG_Framework;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_WebUniversity {

    @Test
    public void webdriverUniversityTesti(){

        //1."https://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");
        //2."Login Portal" a  kadar asagi inin
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebUniversityPage webUniversityPage = new WebUniversityPage();

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ",
                                webUniversityPage.loginPortalElementi);

        //3."Login Portal" a tiklayin
        webUniversityPage.loginPortalElementi.click();

        //4.Diger window'a gecin
        ReusableMethods.switchToWindowByTitle(Driver.getDriver(),"WebDriver | Login Portal");
        //5."username" ve  "password" kutularina deger yazdirin

        Faker faker = new Faker();

        webUniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webUniversityPage.passwordKutusu.sendKeys(faker.internet().password());


        //6."login" butonuna basin
        webUniversityPage.loginButonu.click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String expectedAlertYazisi = "validation failed";
        String actualAlertYazisi = Driver.getDriver()
                                        .switchTo().alert()
                                        .getText();

        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);

        //8.Ok diyerek Popup'i kapatin

        Driver.getDriver()
                .switchTo().alert()
                .accept();


        //9.Ilk sayfaya geri donun
        ReusableMethods.switchToWindowByTitle(Driver.getDriver(),"WebDriverUniversity.com");

        //10.Ilk sayfaya donuldugunu test edin

        String expectedUrl = "https://webdriveruniversity.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);


        ReusableMethods.bekle(3);
        Driver.quitDriver();

    }
}
