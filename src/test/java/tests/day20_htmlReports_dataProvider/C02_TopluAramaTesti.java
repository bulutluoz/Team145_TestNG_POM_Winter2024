package tests.day20_htmlReports_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_TopluAramaTesti {

    @Test
    public void aramaTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();
        testotomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edelim

        String actualAramaSonucu = testotomasyonPage.aramaSonucuElementi.getText();

        Assert.assertNotEquals(ConfigReader.getProperty("toUnexpectedAramaSonucu"),actualAramaSonucu);

        Driver.quitDriver();
    }

    @Test
    public void topluAramaTesti(){

        // yukardaki arama testindeki adimlari verilen liste icin gerceklestirin
        // phone, java, samsung, apple, Nutella, dress, sahin, baby

        List<String> aranacakUrunlerList =
                new ArrayList<>(Arrays.asList("phone", "java", "samsung", "apple", "Nutella", "dress", "sahin", "baby"));

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();

        List<String> bulunanUrunlerListesi = new ArrayList<>();
        List<String> bulunamayanUrunlerListesi = new ArrayList<>();

        for (String eachUrun : aranacakUrunlerList){

            testotomasyonPage.aramaKutusu.sendKeys(eachUrun + Keys.ENTER);
            // arama sonucunda urun bulunabildigini test edelim
            String actualAramaSonucu = testotomasyonPage.aramaSonucuElementi.getText();

            if (actualAramaSonucu.equals(ConfigReader.getProperty("toUnexpectedAramaSonucu"))){
                bulunamayanUrunlerListesi.add(eachUrun);
            }else bulunanUrunlerListesi.add(eachUrun);

        }

        System.out.println("Bulunamayan urunler : "+ bulunamayanUrunlerListesi);

        Assert.assertEquals(bulunamayanUrunlerListesi.size(),0);

        Driver.quitDriver();

    }

    @Test
    public void topluAramaTestiSoftAssert(){

        // yukardaki arama testindeki adimlari verilen liste icin gerceklestirin
        // phone, java, samsung, apple, Nutella, dress, sahin, baby

        List<String> aranacakUrunlerList =
                new ArrayList<>(Arrays.asList("phone", "java", "samsung", "apple", "Nutella", "dress", "sahin", "baby"));

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();

        SoftAssert softAssert = new SoftAssert();

        for (String eachUrun : aranacakUrunlerList){

            testotomasyonPage.aramaKutusu.sendKeys(eachUrun + Keys.ENTER);

            softAssert.assertNotEquals(
                    testotomasyonPage.aramaSonucuElementi.getText() ,
                    ConfigReader.getProperty("toUnexpectedAramaSonucu"),
                    eachUrun+" bulunamadi");

        }

        softAssert.assertAll();
        Driver.quitDriver();
    }
}
