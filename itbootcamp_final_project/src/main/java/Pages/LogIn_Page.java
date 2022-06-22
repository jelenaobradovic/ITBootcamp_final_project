package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page {
    private WebDriver driver;

    public LogIn_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginButton() {
        return driver.findElement(
                By.xpath("//button[@type='submit']"));
    }

    public WebElement getEmailInput() {
        return driver.findElement(
                By.name("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(
                By.id("password"));
    }
}
