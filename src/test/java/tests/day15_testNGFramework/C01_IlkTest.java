package tests.day15_testNGFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_IlkTest {

    /*
        JUnit'de yaptigimiz islemleri
        TestNG ile de yapabiliriz

        Ama TestNG daha fazla kontrol ve daha fazla promosyona sahiptir
        Ayrica Java OOP consept tabanli Page Object Model kullanarak

        Test method'larini dinamik hale getirir.

        amac testlerde kullanilan
        url, aranacak kelime, bulunmasi gereken sonuc sayisi ... gibi test datalarini
        hangi browser'in kullanilacagi
        ve webelementler icin locate'leri tek bir yerde tutup
        degisiklik yapmak gerektiginde

        yuzlerce testi gozden gecirmek yerine
        tek bir yerden degisiklik yapip
        tum testlerin yeni datalarla guncellenebilmesidir

     */


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

    @Test
    public void aramaTesti(){
        // Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);
        // phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(1);
        // urun bulunabildigini test edin

        String unExpectedAramaSonucu = "0 Products Found";

        String actualAramaSonucu = driver.findElement(By.className("product-count-text"))
                                            .getText();

        Assert.assertNotEquals(actualAramaSonucu,unExpectedAramaSonucu);
    }


}
