package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']") public WebElement txt_Username;
    @FindBy (xpath = "//input[@type='password']") public WebElement txt_Password;
    @FindBy (xpath = "//button[@name='Login']") public WebElement btn_Login;

}