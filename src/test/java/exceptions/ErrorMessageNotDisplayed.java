package exceptions;

import org.openqa.selenium.WebElement;

public class ErrorMessageNotDisplayed extends Throwable {

    public ErrorMessageNotDisplayed(WebElement lbl_CustomerName_ErrorMessage){
        System.out.println("Element not displayed.");
    }

}
