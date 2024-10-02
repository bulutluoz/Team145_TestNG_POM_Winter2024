package tests.day20_crossBrowserTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;
import utilities.TestBaseRapor;

public class C01_CrossBrowserAramaTesti extends TestBaseCross {

    /*
        Cross Browser test
        secili test class'inin farkli browserlar ile arka arkaya calistirilabilmesidir
        ornegin,day20 crossBrowserTestler package'indaki tum class'lari
        hergun chrome, firefox, safari ve edge ile calistirmak istiyoruz

        bu package'daki class'lari toplu ccalistirmak icin .xml lazim


     */

    @Test
    public void aramaTesti(){

        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

        // arama kutusuna belirlenen arama kelimesini yazip aratin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        ReusableMethods.bekle(1);

        // arama sonucunda urun bulunabildigini test edin

        String actualSonucYazisi = driver.findElement(By.className("product-count-text"))
                                            .getText();

        String unExpectedSonucYazisi = ConfigReader.getProperty("toUnexpectedSonucYazisi");

        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);

        ReusableMethods.bekle(1);

    }


}



















