package tests.day17_TestNGFramework_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_Assertions {

    @Test
    public void aramaTesti(){

        // testotomasyonu sayfasina dinamik url kullanarak gidin

        Driver.getDriver().get(  ConfigReader.getProperty("toUrl")   );

        // url'in verilen url ile ayni oldugunu test edin

        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);


        // arama kutusuna belirlenen aranacakKelime'yi yazip aratin
        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();

        testotomasyonPage.aramaKutusu
                .sendKeys(  ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER   ); // C P' den alinacak

        // arama sonucunda urun bulunabildigini test edin

        Assert.assertTrue( testotomasyonPage.bulunanUrunElementleriList.size() > 0   );


        // ilk urunu tiklayin

        testotomasyonPage.bulunanUrunElementleriList
                .get(0)
                .click();

        // acilan sayfadaki urun isminde
        // case sensitive olmadan belirlenmis aranacakKelime gectigini test edin

        String aranacakKelime = ConfigReader.getProperty("toAranacakKelime");

        String actualUrunIsmi = testotomasyonPage.ilkUrunIsimElementi
                .getText()
                .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(aranacakKelime));


        Driver.quitDriver();

    }
}
