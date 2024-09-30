package tests.day18_TestNGAssertions_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

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
        zeroPage.loginKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliUsername"));

        // 5. Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));

        // 6. Sign in tusuna basin
        zeroPage.signinSayfasiSignInButonu.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroPage.settingsTusu.isDisplayed());

        // 9. Online banking menusunu tiklayin
        zeroPage.onlineBankingLinki.click();

        //10. Pay Bills sayfasina gidin
        zeroPage.payBillsLinki.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseCurrencyMenu.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroPage.currencyDropdownMenu.isEnabled());

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(zeroPage.currencyDropdownMenu);

        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin

        String expectedOption = "Eurozone (euro)";
        String actualSecilenOption = select.getFirstSelectedOption()
                                            .getText();

        softAssert.assertEquals(actualSecilenOption,expectedOption);

        //15. Dropdown menude 16 option bulundugunu dogrulayin.

        int expectedOptionSayisi = 16;
        int actualOptionSayisi = select.getOptions().size();

        softAssert.assertEquals(actualOptionSayisi,expectedOptionSayisi);


        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin

        expectedOption = "Canada (dollar)";

        List<WebElement> optionElementleriList = select.getOptions();

        List<String> optionYazilariList = ReusableMethods.stringListeyeCevir(optionElementleriList);

        softAssert.assertTrue(optionYazilariList.contains(expectedOption));


        softAssert.assertAll();
        //17. Sayfayi kapatin
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
