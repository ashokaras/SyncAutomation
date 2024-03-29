package steps;

import exceptions.ErrorMessageNotDisplayed;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CustomerPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestSteps {

    WebDriver driver;

    @Given("i login application")
    public void i_login_application() throws IOException {
        FileReader configFile = new FileReader("properties/config.property");
        Properties properties = new Properties();
        properties.load(configFile);
        System.out.println(properties.getProperty("url"));

        if(properties.getProperty("browser").equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (properties.getProperty("browserName").equalsIgnoreCase("IE")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }else if (properties.getProperty("browserName").equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        type(loginPage.txt_Username,properties.getProperty("username"));
        type(loginPage.txt_Password,properties.getProperty("password"));
        click(loginPage.btn_Login);
    }

    @When("i navigate to customer page")
    public void i_navigate_to_customer_page() {
        HomePage homePage = new HomePage(driver);
        click(homePage.lnk_CustomerPage);
    }

    @Then("i validate customer name with {string} as {string} data")
    public void i_validate_customer_name_with_as_data(String string, @NotNull String string2) throws ErrorMessageNotDisplayed {
        CustomerPage customerPage = new CustomerPage(driver);
        type(customerPage.txt_CustomerName,string);
        if (string2.equalsIgnoreCase("positive")){
            if(elementExists(customerPage.lbl_CustomerName_ErrorMessage)){
                throw new ErrorMessageNotDisplayed(customerPage.lbl_CustomerName_ErrorMessage);
            }
        } else if (string2.equalsIgnoreCase("negative")){
            if(!elementExists(customerPage.lbl_CustomerName_ErrorMessage)){
                throw new ErrorMessageNotDisplayed(customerPage.lbl_CustomerName_ErrorMessage);
            }
        }
    }

    @Then("i quit browser")
    public void i_quit_browser() {
        driver.quit();
    }

    @Then("i validate customer name with multiple data")
    public void i_validate_customer_name_with_multiple_data() {

    }

    @Then("i validate gst number with {string}")
    public void i_validate_gst_number_with(String string) {
        CustomerPage customerPage = new CustomerPage(driver);
        type(customerPage.txt_GSTNumber,string);
    }

    @SuppressWarnings("deprecation")
    private void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void click(WebElement element){
        try{
            waitForElement(element);
            element.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void type(WebElement element, String data){
        try{
            waitForElement(element);
            element.sendKeys(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean elementExists(WebElement element) {
        try{
            return element.isDisplayed();
        }catch(NoSuchElementException e){
            return false;
        }
    }

    private String getData(){

        return null;
    }
}