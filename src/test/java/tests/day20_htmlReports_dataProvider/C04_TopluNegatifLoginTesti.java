package tests.day20_htmlReports_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C04_TopluNegatifLoginTesti extends TestBaseRapor {


    /*
        verilen kullanici adi ve sifreler ile giris yapilamadigini test edin

        cem@gmail.com       12345
        murat@hotmail.com   67565
        mustafa@yahoo.com   87654
        serkan@bizmail.com  56789
        nesibe@sizmail.com  23456
     */

    @DataProvider
    public static Object[][] kullaniciBilgileriProvider() { // ikikatli Object Array dondurmesi ZORUNLU

        String[][] kullaniciBilgileriArr = {
                {"suleyman@gmail.com", "12345"},
                {"murat@hotmail.com", "67565"},
                {"mustafa@yahoo.com", "87654"},
                {"serkan@bizmail.com", "56789"},
                {"nesibe@sizmail.com", "23456"}

        };

        return kullaniciBilgileriArr;
    }



    @Test(dataProvider = "kullaniciBilgileriProvider")
    public void negatifLoginTesti(String username , String password){
        extentTest = extentReports.createTest("Gecersiz datalarla negatif login testi",
                "Gecersiz password ve gecerli username ile giris yapilamaz");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");
        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();
        testotomasyonPage = new TestotomasyonPage();
        //2- account linkine basin
        testotomasyonPage.accountLinki.click();
        extentTest.info("account linkine basar");
        //3- parametre olarak gelen  email ve password girer
        testotomasyonPage.emailKutusu.sendKeys(username);
        extentTest.info("username olarak "+username+" girer");
        testotomasyonPage.passwordKutusu.sendKeys(password);
        extentTest.info("password olarak "+password+" girer");
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
