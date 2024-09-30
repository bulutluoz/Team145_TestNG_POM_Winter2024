package tests.day18_TestNGAssertions_xmlFiles;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_ZeroSoftAssert {

    @Test
    public void test01(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        //    logo'nun gorunmesini dogrulayalim

        ZeroPage zeroPage = new ZeroPage();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(zeroPage.zeroLogo.isDisplayed());

        // 3. Sign in butonuna basin
        zeroPage.signInButonu.click();

        // 4. Login kutusuna “username” yazin

        // 5. Password kutusuna “password” yazin

        // 6. Sign in tusuna basin

        // 7. Back tusuna basin

        // 8. Giris yapilabildigini dogrulayin


        // 9. Online banking menusunu tiklayin
        //10. Pay Bills sayfasina gidin
        //11. “Purchase Foreign Currency” tusuna basin
        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        //13. “Currency” dropdown menusunden Eurozone’u secin
        //14. "Eurozone (euro)" secildigini dogrulayin
        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin

        softAssert.assertAll();
        //17. Sayfayi kapatin
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
