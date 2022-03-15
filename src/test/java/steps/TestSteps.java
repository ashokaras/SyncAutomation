package steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestSteps {

    private WebDriver driver;

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
        try{
            waitForElement(LoginPage.txt_Username);
            LoginPage.txt_Username.sendKeys(properties.getProperty("username"));
            LoginPage.txt_Password.sendKeys(properties.getProperty("password"));
            LoginPage.btn_Login.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("i navigate to customer page")
    public void i_navigate_to_customer_page() {
        HomePage.lnk_CustomerPage.click();
    }

    @Then("i validate customer name with {string}")
    public void i_validate_customer_name_with(String string) {
        System.out.println(string);
    }

    @Then("i quit browser")
    public void i_quit_browser() {
        driver.quit();
    }

    @Then("i validate gst number with {string}")
    public void i_validate_gst_number_with(String string) {
        System.out.println(string);
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

}