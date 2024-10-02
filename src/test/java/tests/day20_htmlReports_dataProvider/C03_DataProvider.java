package tests.day20_htmlReports_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_DataProvider extends TestBaseRapor {



    /*
        Data provider,
        toplu testlerde, her bir eleman icin tum testin calismasini
        ve her bir element icin method sonucunun raporlanmasini saglar

        "phone", "java", "samsung", "apple", "Nutella", "dress", "sahin", "baby"
        bu 8 kelime icin arama yaptigimizda
        herbiri icin arama testini calistirir ve
        biri failed olsa da digerleri ile yoluna devam eder

        DataProvider iki katli MultiDimensional Object Array'i donduren
        ozel bir method'dur.
     */

    @DataProvider
    public static Object[][] aranacakUrunlerProvideri() {

        String[][] aranacakUrunlerArr = {{"phone"}, {"java"}, {"samsung"},
                {"Nutella"}, {"dress"}, {"sahin"}, {"baby"}};

        return aranacakUrunlerArr;
    }



    @Test(dataProvider = "aranacakUrunlerProvideri")
    public void aramaTesti(String aranacakUrun){
        extentTest = extentReports.createTest(aranacakUrun+" arama testi" ,
                "arama sonucunda urun bulunabilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici test otomasyonu anasayfaya gider");

        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();
        testotomasyonPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);
        extentTest.info(aranacakUrun+" icin arama yapar");

        // arama sonucunda urun bulunabildigini test edelim

        String actualAramaSonucu = testotomasyonPage.aramaSonucuElementi.getText();

        Assert.assertNotEquals(ConfigReader.getProperty("toUnexpectedAramaSonucu"),actualAramaSonucu);
        extentTest.pass("arama sonucunda urun bulunabildigini test eder");

        extentTest.info("sayfayi kapatir");
    }

}
