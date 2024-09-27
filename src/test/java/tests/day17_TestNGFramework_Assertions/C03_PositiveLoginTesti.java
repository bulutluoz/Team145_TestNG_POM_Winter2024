package tests.day17_TestNGFramework_Assertions;

import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveLoginTesti {

    @Test
    public void positiveLoginTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get( ConfigReader.getProperty("toUrl") );

        //2- account linkine basin
        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();

        testotomasyonPage.accountLinki.click();

        //3- Kullanici email'i olarak gecerli email girin



        //4- Kullanici sifresi olarak gecerli password girin
        //5- Login butonuna basarak login olun
        //6- Basarili olarak giris yapilabildigini test edin



    }
}
