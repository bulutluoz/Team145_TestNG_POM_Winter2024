package tests.day17_TestNGFramework_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_QuitDriver {

    // 3 farkli test methodu olusturarak asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidin Title'in "Test Otomasyonu" icerdigini test edin
    // 2- wisequarter anasayfaya gidin Url'in "wisequarter" icerdigini test edin
    // 3- youtube anasayfaya gidin Title'in "vimeo" icermedigini test edin

    @Test(groups = "smoke")
    public void testotomasyonuTesti(){
        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }

    @Test(groups = {"smoke","e2e"})
    public void wisequarterTesti(){
        Driver.getDriver().get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }

    @Test(groups = {"smoke","sistem"})
    public void youtubeTesti(){

        Driver.getDriver().get("https://www.youtube.com");

        String unExpectedTitleIcerik = "vimeo";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertFalse(actualTitle.contains(unExpectedTitleIcerik));
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
