package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {


    // Webelement'lerden olusan listeyi,
    // String'lerden olusan listeye ceviren bir method olusturalim

    public static List<String> stringListeyeCevir(List<WebElement> elementListesi){

        List<String> stringListesi = new ArrayList<>();

        for (WebElement eachElement : elementListesi) {

            stringListesi.add(eachElement.getText());
        }

        return stringListesi;
    }

    public static void bekle(int saniye){

        try {
            Thread.sleep( saniye*1000);
        } catch (InterruptedException e) {

        }

    }

    public static void switchToWindowByTitle(WebDriver driver , String istenenSayfaTitle){
        Set<String> acikOlanWindowlarinWHDSeti = driver.getWindowHandles();
        for (String eachWhd : acikOlanWindowlarinWHDSeti){

            driver.switchTo().window(eachWhd);
            ReusableMethods.bekle(1);

            if (driver.getTitle().equals(istenenSayfaTitle)){
                break;
            }

        }
    }

    public static void switchToWindowByUrl(WebDriver driver , String istenenSayfaUrl){
        Set<String> acikOlanWindowlarinWHDSeti = driver.getWindowHandles();
        for (String eachWhd : acikOlanWindowlarinWHDSeti){

            driver.switchTo().window(eachWhd);
            ReusableMethods.bekle(1);

            if (driver.getCurrentUrl().equals(istenenSayfaUrl)){
                break;
            }

        }
    }

    public static void getScreenshotTumSayfa(WebDriver driver,String ssIsmi){
        // 1.adim olusturacagimiz dosyayolunu hazirlayalim
        String dosyaYolu = "target/screenshots/"+ssIsmi+".png";

        // 2. TakesScreenshot objesi olusturalim

        // TakesScreenshot tss = new TakesScreenshot();
        // 'TakesScreenshot' is abstract; cannot be instantiated

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 3.adim screenshot'i kaydedecegimiz File'i olusturalim

        File tumsayfaSS = new File(dosyaYolu);

        // 4.adim screenshot'i alip gecici dosua olarak kaydedin

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 5.adim gecici resmi asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciResim,tumsayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getScreenshotTumSayfa(WebDriver driver){

        // 240924202034
        LocalDateTime ldt = LocalDateTime.now(); // 2024-09-24T20-23-24-123432

        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(istenenFormat);

        // 1.adim olusturacagimiz dosyayolunu hazirlayalim
        String dosyaYolu = "target/screenshots/TumSayfaSS"+tarihEtiketi+".png";

        // 2. TakesScreenshot objesi olusturalim

        // TakesScreenshot tss = new TakesScreenshot();
        // 'TakesScreenshot' is abstract; cannot be instantiated

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 3.adim screenshot'i kaydedecegimiz File'i olusturalim

        File tumsayfaSS = new File(dosyaYolu);

        // 4.adim screenshot'i alip gecici dosua olarak kaydedin

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 5.adim gecici resmi asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciResim,tumsayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getScreenshotWebElement(WebDriver driver, WebElement webElement){

        LocalDateTime ldt = LocalDateTime.now(); // 2024-09-24T20-23-24-123432

        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(istenenFormat);

        // 1.adim olusturacagimiz dosyayolunu hazirlayalim
        String dosyaYolu = "target/screenshots/WebElementSS"+tarihEtiketi+".png";

        // 2- kullanacagimiz WebElementi locate edip, WebElement olarak kaydedin
        //    parametre olarak gonderilen webElement'in ss alinacak

        // 3- kaydedecegimiz file'i olusturun

        File webElementSS = new File(dosyaYolu);

        // 4- webElement uzerinden screenshot'i alip, gecici dosya olarak kaydedin

        File geciciDosya = webElement.getScreenshotAs(OutputType.FILE);

        // 5- gecici dosyayi asil dosyaya kopyala

        try {
            FileUtils.copyFile(geciciDosya,webElementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}
