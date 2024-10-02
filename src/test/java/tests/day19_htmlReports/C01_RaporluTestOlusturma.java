package tests.day19_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluTestOlusturma extends TestBaseRapor {

    /*
        Herhangi bir test method'unu raporlu hale getirebilmek icin

        1- class'i TestBaserapor'a extends edelim
           boylece oradaki @BeforeTest, @AfterTest, @AfterMethod method'larini
           ve extentReports ve extentHtmlreporter objelerini kullanabilelim

        2- ihtiyacimiz olan 3 objeden
           extentReports ve extentHtmlreporter objelerine TestBaseRapor'da deger atandi
           biz de kalan 3.obje olan extentTest objesine deger atamasi yapip
           rapor ismi ve rapor aciklamasini parametre olarak girelim

        3- raporda gorunmesini istediginiz adimlari
           info veya pass olarak rapora isleyin
     */


    @Test
    public void raporluPozitifLoginTesti(){
        extentTest = extentReports.createTest("PozitifLoginTesti",
                                        "Kullanici gecerli bilgilerle giris yapabilmeli");


        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get( ConfigReader.getProperty("toUrl") );
        extentTest.info("kullanici testotomasyonu anasayfasina gider");

        //2- account linkine basin
        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();

        testotomasyonPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonPage.emailKutusu.sendKeys( ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");

        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli password girer");

        //5- Login butonuna basarak login olun
        testotomasyonPage.signInButonu.click();
        extentTest.info("Login butonuna basarak login olur");

        //6- Basarili olarak giris yapilabildigini test edin
        ReusableMethods.bekle(1);
        Assert.assertTrue( testotomasyonPage.signoutButonu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");

        testotomasyonPage.signoutButonu.click();
        extentTest.info("Logout butonuna basarak logout olur");

        extentTest.info("sayfayi kapatir");

    }
}
