package tests.day20_htmlReports_dataProvider;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluNegatifLoginTestleri extends TestBaseRapor {


    TestotomasyonPage testotomasyonPage = new TestotomasyonPage();
    @Test
    public void gecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz Password Testi",
                "Gecersiz password ve gecerli username ile giris yapilamaz");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");
        testotomasyonPage = new TestotomasyonPage();
        //2- account linkine basin
        testotomasyonPage.accountLinki.click();
        extentTest.info("account linkine basar");
        //3- gecerli email, gecersiz password girin
        testotomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("username olarak gecerli email girer");
        testotomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("password olarak gecersiz password girer");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonPage.signInButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonPage.emailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");
        //6- sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }

    @Test
    public void gecersizemailTesti(){
        extentTest = extentReports.createTest("Gecersiz Email Testi",
                "Gecerli password ve gecersiz username ile giris yapilamaz");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");
        testotomasyonPage = new TestotomasyonPage();
        //2- account linkine basin
        testotomasyonPage.accountLinki.click();
        extentTest.info("account linkine basar");
        //3- gecerli email, gecersiz password girin
        testotomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("username olarak gecersiz email girer");
        testotomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("password olarak gecerli password girer");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonPage.signInButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonPage.emailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");
        //6- sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz Email ve Gecersiz Password Testi",
                "Gecersiz password ve gecersiz username ile giris yapilamaz");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");
        testotomasyonPage = new TestotomasyonPage();
        //2- account linkine basin
        testotomasyonPage.accountLinki.click();
        extentTest.info("account linkine basar");
        //3- gecerli email, gecersiz password girin
        testotomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("username olarak gecersiz email girer");
        testotomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("password olarak gecersiz password girer");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonPage.signInButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonPage.emailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");
        //6- sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }

}
