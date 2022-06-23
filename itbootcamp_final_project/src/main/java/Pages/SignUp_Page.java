package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUp_Page {
    private WebDriver driver;

    public SignUp_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameInputFieldAtSignUp() {
        return driver.findElement(
                By.name("name"));
    }

    public WebElement getEmailInputFieldAtSignUp() {
        return driver.findElement(
                By.name("email"));
    }

    public WebElement getPasswordInputFieldAtSignUp() {
        return driver.findElement(
                By.name("password"));
    }

    public WebElement getConfirmPasswordInputFieldAtSignUp() {
        return driver.findElement(
                By.name("confirmPassword"));
    }
    public WebElement getSignMeUpButton ()
    {return driver.findElement(
            By.className("v-btn--contained"));}


}
