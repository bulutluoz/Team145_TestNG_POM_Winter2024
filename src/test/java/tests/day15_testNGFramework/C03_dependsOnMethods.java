package tests.day15_testNGFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_dependsOnMethods {

    /*
        B test method'u icin dependsOnMethods = "A" yazarsak

        B'nin calismasi A method'un calisip PASSED olmasina bagli olur
        A calismazsa veya calistigi halde bir assertion FAILED olursa
        TestNG B method'unu IGNORE eder ve hic calistirmaz

        sadece B'yi calistirmak istedigimizde
        TestNG B'nin calismasinin A'ya bagli oldugunu gorur
        ve biz demesek de once A'yi calistirir
        A calisip PASSED olunca B'yi calistirir

        ama bu bagli calistirma sadece 2 method icin gecerlidir.
        3 method olsa birbirini calistirmaz
        hata olusur

        DependsOnMethods priority gibi ONCELIK belirlemez
        sadece sira kendisine geldiginde
        once bagli oldugu method varsa onun calismasini saglar


     */

    // 3 test method'u olusturup asagidaki gorevleri tamamlayin
    // 1- testotomasyonu anasayfaya gidip title'in "Test otomasyonu" icerdigini test edin
    // 2- phone icin arama yapin ve urun bulunbildigini test edin
    // 3- ilk urunu tiklayin ve acilan sayfadaki urun isminde
    //    case sensitive olmadan "phone" gectigini test edin

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.firefoxdriver().setup(); // eger sirketin verdigi ozel bir WebDriver varsa
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void anasayfaTesti(){
        // 1- testotomasyonu anasayfaya gidip title'in "Test otomasyonu" icerdigini test edin

        driver.get("https://www.testotomasyonu.com");

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
    }

    @Test(dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){
        // 2- phone icin arama yapin ve urun bulunbildigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(1);

        String unExpectedAramaSonucu = "0 Products Found";

        String actualAramaSonucu = driver.findElement(By.className("product-count-text"))
                                    .getText();

        Assert.assertNotEquals(actualAramaSonucu,unExpectedAramaSonucu);


    }

    @Test(dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunIsimTesti(){
        // 3- ilk urunu tiklayin ve acilan sayfadaki urun isminde
        //    case sensitive olmadan "phone" gectigini test edin

        driver.findElement(By.xpath(" (//*[@class='prod-img'])[1]"))
                .click();

        String expectedIsimIcerigi = "phone";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"))
                                        .getText()
                                            .toLowerCase();


        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));



    }

}
