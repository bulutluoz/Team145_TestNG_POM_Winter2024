package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebUniversityPage {

    public WebUniversityPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }




}
