package tests.day20_crossBrowserTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_CrossBrowserPozitifLoginTesti extends TestBaseCross {


    @Test
    public void positiveLoginTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get( ConfigReader.getProperty("toUrl") );
        ReusableMethods.bekle(1);

        //2- account linkine basin
        WebElement accountLinki = driver.findElement(By.xpath("(//*[text()='Account'])[1]"));

        accountLinki.click();
        ReusableMethods.bekle(1);

        //3- Kullanici email'i olarak gecerli email girin

        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys( ConfigReader.getProperty("toGecerliEmail"));

        //4- Kullanici sifresi olarak gecerli password girin

        WebElement passwordKutusu = driver.findElement(By.id("password"));

        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));


        //5- Login butonuna basarak login olun

        WebElement signInButonu = driver.findElement(By.id("submitlogin"));
        signInButonu.click();
        ReusableMethods.bekle(1);
        //6- Basarili olarak giris yapilabildigini test edin

        WebElement signoutButonu = driver.findElement(By.xpath("(//*[text()='Logout'])[2]"));

        Assert.assertTrue( signoutButonu.isDisplayed());

        ReusableMethods.bekle(1);
        signoutButonu.click();



    }
}
