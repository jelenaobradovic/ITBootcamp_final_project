package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nav_Page {
    private WebDriver driver;

    public Nav_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLanguageButton() {
        return driver.findElement(
                By.xpath("//button[contains(@class,'btnLocaleActivation')]"));
    }


    public WebElement getEnglishLanguageButton() {
        return driver.findElement(
                By.id("list-item-73"));

    }

    public WebElement getLogOutButtonFromNav() {
        return driver.findElement(
                By.xpath("//button[contains(@class,'btnLogout')]"));
    }

    public WebElement getLoginButtonFromNav() {
        return driver.findElement(
                By.xpath("//a[contains(@class,'btnLogin')]"));
    }

}
