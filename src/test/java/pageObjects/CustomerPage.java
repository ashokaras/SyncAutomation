package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {

    WebDriver driver;
    public CustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "") public static WebElement txt_CustomerName;
    @FindBy (xpath = "") public static WebElement lbl_CustomerName_ErrorMessage;
    @FindBy (xpath = "") public static WebElement txt_GSTNumber;
    @FindBy (xpath = "") public static WebElement lbl_GSTNumber_ErrorMessage;

}