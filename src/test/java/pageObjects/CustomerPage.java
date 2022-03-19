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

    @FindBy (xpath = "//input[@id='companyName']") public WebElement txt_CustomerName;
    @FindBy (xpath = "//input[@id='companyName']/following-sibling::span") public WebElement lbl_CustomerName_ErrorMessage;
    @FindBy (xpath = "//input[@id='gst']") public WebElement txt_GSTNumber;
    @FindBy (xpath = "//input[@id='gst']/following-sibling::span") public WebElement lbl_GSTNumber_ErrorMessage;

}