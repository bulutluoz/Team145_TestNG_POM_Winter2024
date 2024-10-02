package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestotomasyonPage {
    // WebElement'i gidip bulacak WebDriver objesidir
    // ama bu class'da henuz WebDriver objemizi tanitmadik
    public TestotomasyonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    // Testotomasyonu sayfasindaki locate'leri burada yapacagiz
    // ve bir WebElement'e veya WebElement'lerden olusan bir List'e atayacagiz

    // page class'inda locate icin driver.findElement() kullanilmaz
    // POM locate icin @FindBy notasyonu kullanir

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    // page class'inda birden fazla elementi locate icin driver.findElements() kullanilmaz
    // POM'da birden fazla elementi locate edip, bir listeye kaydetmek icin de @FindBy notasyonu kullanir

    @FindBy(className = "prod-img")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//*[@class=' heading-sm mb-4']")
    public WebElement ilkUrunIsimElementi;

    @FindBy(xpath = "(//*[text()='Account'])[1]")
    public WebElement accountLinki;

    @FindBy(id = "email")
    public WebElement emailKutusu;


    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id="submitlogin")
    public WebElement signInButonu;

    @FindBy(xpath = "(//*[text()='Logout'])[2]")
    public WebElement signoutButonu;

    @FindBy(className = "product-count-text")
    public WebElement aramaSonucuElementi;


}
