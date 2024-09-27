package tests.day17_TestNGFramework_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin

    TestotomasyonPage testotomasyonPage = new TestotomasyonPage();
    @Test
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        testotomasyonPage = new TestotomasyonPage();
        //2- account linkine basin
        testotomasyonPage.accountLinki.click();
        //3- gecerli email, gecersiz password girin
        testotomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonPage.signInButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonPage.emailKutusu.isDisplayed());
        //6- sayfayi kapatin
        Driver.quitDriver();
    }

    @Test
    public void gecersizemailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        testotomasyonPage = new TestotomasyonPage();
        //2- account linkine basin
        testotomasyonPage.accountLinki.click();
        //3- gecersiz email, gecerli password girin
        testotomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonPage.signInButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonPage.emailKutusu.isDisplayed());
        //6- sayfayi kapatin
        Driver.quitDriver();
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        testotomasyonPage = new TestotomasyonPage();
        //2- account linkine basin
        testotomasyonPage.accountLinki.click();
        //3- gecersiz email, gecersiz password girin
        testotomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonPage.signInButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonPage.emailKutusu.isDisplayed());
        //6- sayfayi kapatin
        Driver.quitDriver();
    }
}
