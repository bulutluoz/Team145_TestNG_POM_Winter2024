package tests.day17_TestNGFramework_Assertions;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SingletonPattern {

    @Test
    public void test01(){

        /*
         POM WebDriver objesi icin Driver.getDriver() kullanmamizi ister
         POM bu yontem disinda farkli yontem kullanilmasini engellemek icin
         Singleton Pattern Kullanmayi tercih etmistir.

         Singleton pattern bir class'dan obje olusturulmasini engellemek icin
         kullanilan yontemlerden biridir
         ve obje olusturmayi engellemek icin
         class'daki constructor'i private yapma fikrine dayanir

         */
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Driver driver = new Driver();
        // driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // static yontemle degil obje uzerinden kullanabildik


        // driver.driver.get(ConfigReader.getProperty("toUrl"));
        // NullPointerException
        // driver'a new ChromeDriver degeri method'da atandigi icin
        // direk driver objesini kullaninca NullPointerException olusur

    }
}
