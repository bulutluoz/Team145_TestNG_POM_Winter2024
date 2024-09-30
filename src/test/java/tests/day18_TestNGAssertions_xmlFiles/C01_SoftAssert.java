package tests.day18_TestNGAssertions_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SoftAssert {

    @Test
    public void test01(){


        // testotomasyonu sayfasina gidin

        Driver.getDriver().get(  ConfigReader.getProperty("toUrl")   );

        // url'in verilen url ile ayni oldugunu dogrulayin (verify)

        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualUrl, expectedUrl,"Url beklenenden farkli");
        // softassert'un en buyuk dezavantaji
        // hatanin oldugu satir olarak assertAll()'un bulundugu satiri vermesidir
        // hatanin asil yerini bulabilmemiz icin
        // softassert kullandigimiz tum assertion'larda bir hata mesaji eklemeliyiz


        // arama kutusuna belirlenen aranacakKelime'yi yazip aratin
        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();

        testotomasyonPage.aramaKutusu
                .sendKeys(  ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER   ); // C P' den alinacak

        // arama sonucunda urun bulunabildigini test edin

        softAssert.assertTrue(testotomasyonPage.bulunanUrunElementleriList.size()>0
                                        ,"aranan urun bulunamadi");


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


        softAssert.assertTrue(actualUrunIsmi.contains(aranacakKelime),
                                    "urun ismi aranacak kelimeyi icermiyor");

        softAssert.assertAll();

        Driver.quitDriver();
    }
}
