package tests.day16_TestNG_Framework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PageClassKullanimi {

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        // phone icin arama yapin
        // arama yapabilmek icin once arama kutusunu locate etmeliyiz
        // Locate edip atama islemleri artik Page Class'larinda olacak
        // ve page class'indaki WebElement'lere obje olusturarak ulasacagiz

        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();

        testotomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        Assert.assertTrue( testotomasyonPage.bulunanUrunElementleriList.size() > 0   );

        ReusableMethods.bekle(2);
        // sayfayi kapatin
        Driver.quitDriver();

    }
}
