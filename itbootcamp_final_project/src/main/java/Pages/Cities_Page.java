package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cities_Page {

    private WebDriver driver;
    WebDriverWait wait;

    public Cities_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return driver.findElement(
                By.className("btnNewItem"));
    }

    public WebElement getNewItemNameInputField() {
        return driver.findElement(
                By.id("name"));
    }

    public WebElement getSearchInputField() {
        return driver.findElement(
                By.id("search"));
    }

    public WebElement getSaveCitiesButton() {
        return driver.findElement(By.className("btnSave"));

    }

    public WebElement getSuccessSaveCityPopUp() {
        return driver.findElement(
                By.xpath("//div[contains(text(), ' Saved successfully ')]"));

    }


    public void waitForPresenceOFSuccessSaveCityPopup() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.
                visibilityOf
                        (getSuccessSaveCityPopUp()));
    }

    public void waitForPresenceOfNewItemDialogue() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.
                presenceOfElementLocated(
                        By.className("v-card__title")));
    }


}
