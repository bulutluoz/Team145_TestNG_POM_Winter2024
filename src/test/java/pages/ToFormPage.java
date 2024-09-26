package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ToFormPage {

    public ToFormPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//*[@class='form-control'])[3]")
    public WebElement dtGunDropdownMenu;

    @FindBy(xpath = "(//*[@class='form-control'])[4]")
    public WebElement dtAyDropdownMenu;

    @FindBy(xpath = "(//*[@class='form-control'])[5]")
    public WebElement dtYilDropdownMenu;
}
