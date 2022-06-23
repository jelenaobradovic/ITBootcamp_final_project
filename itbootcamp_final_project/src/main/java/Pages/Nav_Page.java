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
                By.className("btnEN"));

    }
    public WebElement getFRLanguageButton() {
        return driver.findElement(
                By.className("btnFR"));

    }public WebElement getESLanguageButton() {
        return driver.findElement(
                By.className("btnES"));

    }public WebElement getCNLanguageButton() {
        return driver.findElement(
                By.className("btnCN"));

    }

    public WebElement getHomeButtonFromNav()
    {return driver.findElement(
            By.xpath("//div[contains(@class,'v-toolbar__items')]/a"));}


    public WebElement getLogOutButtonFromNav() {
        return driver.findElement(
                By.xpath("//button[contains(@class,'btnLogout')]"));
    }

    public WebElement getLoginButtonFromNav() {
        return driver.findElement(
                By.xpath("//a[contains(@class,'btnLogin')]"));
    }

    public WebElement getCitiesLinkFromAdminMenu()
    {return driver.findElement(By.className("btnAdminCities"));}

    public WebElement getAdminButtonFromNav()
    {return driver.findElement(
            By.xpath("//button[contains(@class,'btnAdmin')]"));}

    public WebElement getSignUpButtonFromNav()
    {
        return driver.findElement(
                By.xpath("//div[contains(@class,'v-toolbar__items')]/a[4]"));
    }


}
