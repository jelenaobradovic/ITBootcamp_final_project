package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    public void waitForCertainNumberOfRows(int numberOfRows) {
        wait.until(ExpectedConditions.
                numberOfElementsToBe(
                        By.xpath("//tbody/tr"), numberOfRows));
    }


    public WebElement getEditButton(int rowNumber) {
        return driver.findElement(
                By.xpath("//tbody/tr[" + rowNumber + "]//button[@id='edit']"));
    }


    public WebElement getCertainCell(int rowNumber, int cellNumber) {
        return driver.findElement(
                By.xpath("//tbody/tr[" + rowNumber + "]/td[" + cellNumber + "]"));
    }


    public WebElement getDeleteButton(int rowNumber) {
        return driver.findElement(
                By.xpath("//tbody/tr[" + rowNumber + "]/td//button[@id = 'delete']"));
    }

    public void selectTextAndReplace(String text) {
        new Actions(driver).
                keyDown(Keys.CONTROL).
                sendKeys("a").
                keyUp(Keys.CONTROL).
                sendKeys(text).
                perform();
    }

    public WebElement getEditCityNameInputField() {
        return driver.findElement(By.name("name"));
    }

    public WebElement getEditedCitySaveButton() {
        return driver.findElement(By.className("btnSave"));
    }

    public WebElement getDeleteButtonFromPopUpDialogue() {
        return driver.findElement(
                By.xpath("//div[contains(@class, 'v-card__actions')]/button[2]"));
    }

    public void waitForDeletePopUpDialogue() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.
                elementToBeClickable(getDeleteButtonFromPopUpDialogue()));

    }

    public WebElement getDeletePopUpMessageOfSuccess() {
        return this.driver.findElement(By.className("success"));}

    public void waitForPopUpMessageForSuccededDeletion() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.className("success"))));
    }



}
