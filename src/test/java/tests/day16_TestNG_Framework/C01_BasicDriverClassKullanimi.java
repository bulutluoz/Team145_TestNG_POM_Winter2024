package tests.day16_TestNG_Framework;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_BasicDriverClassKullanimi {

    @Test
    public void test01(){

        /*
            POM temel olarak test class'larinda update edilecek hicbir bilgi bulundurmamayi hedefler
            Bir test class'inda sonradan degisebilir diyecegimiz herseyi
            test class'larinin disinda belirlenen class'larda olusturacagiz

            OOP concept cercevesinde
            farkli class'lardaki variable/method'lara ulasmak icin
            farkli yontemler mevcuttur

            Bu yontemlerden hangisini hengi islev icin kullanacagimizi
            Page Object Model (POM) belirlemistir.

            Bir test yapmak icin ihtiyac duyacagimiz ilk sey
            WebDriver objesidir

            ikinci olarak ihtiyacimiz olan sey
            WebElement'lerin locate'leridir

            Ucuncu olarak update etmemiz gereken test datalari var.
            - gidilecek url
            - kullanici adi
            - kullanici sifresi
            - kullanilacak browser
            - aranacak kelimeler.....
         */

        // POM WebDriver icin Driver class'inda olusturacagimiz
        // getDriver() kullanilmasini tercih etmistir.

        Driver.getDriver().get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(2);

        // title'i yazdirin
        System.out.println(     Driver.getDriver().getTitle()     );

        // url'i yazdirin
        System.out.println(      Driver.getDriver().getCurrentUrl()  );


        ReusableMethods.bekle(3);
        Driver.quitDriver();

    }
}
