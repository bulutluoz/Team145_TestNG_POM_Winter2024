package tests.day15_testNGFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {

    /*
        TestNG test method'larini alfabetik siraya gore calistirir

        Eger biz istenen bir sira ile calismalarini istiyorsak
        hepsine bir priority degeri atayabiliriz
        priority degeri kucuk olan daha once calisir

        eger bir test method'una priority atanmazsa
        default olarak priority degeri 0 kabul edilir
        ve 0'a gore siralamaya dahil olur

        eger priority degeri ayni olan method'lar varsa
        kendi iclerinde alfabetik siraya uygun olarak calisirlar

     */


    // 3 farkli test methodu olusturarak asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidin Title'in "Test Otomasyonu" icerdigini test edin
    // 2- wisequarter anasayfaya gidin Url'in "wisequarter" icerdigini test edin
    // 3- youtube anasayfaya gidin Title'in "vimeo" icermedigini test edin


    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.firefoxdriver().setup(); // eger sirketin verdigi ozel bir WebDriver varsa
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(priority = 3)
    public void testotomasyonuTesti(){
        driver.get("https://www.testotomasyonu.com");

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
    }

    @Test // priority atanmamis default olarak 0 kabul edilir
    public void wisequarterTesti(){
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test // priority atanmamis default olarak 0 kabul edilir
    public void youtubeTesti(){
        driver.get("https://www.youtube.com");

        String unExpectedTitleIcerik = "vimeo";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unExpectedTitleIcerik));
    }



}
