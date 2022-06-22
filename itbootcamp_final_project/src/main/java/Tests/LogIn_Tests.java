package Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogIn_Tests extends Basic_Test {

    @Test(priority = 10)
    public void visitTheLoginPage() throws InterruptedException {

        navPage.getLanguageButton().click();

        navPage.getEnglishLanguageButton().click();

        navPage.getLoginButtonFromNav().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR], page URL does not contains /login");

    }

    @Test(priority = 20)
    public void checkInputTypes() {

        navPage.getLoginButtonFromNav().click();

        Assert.assertEquals(loginPage.
                        getEmailInput().
                        getAttribute("type"), "email",
                "[ERROR] Attribute Type for Email input is not 'email'");

        Assert.assertEquals(loginPage.
                        getPasswordInput().
                        getAttribute("type"), "password",
                "[ERROR] Attribute Type for Password input is not 'password'");

    }

    @Test(priority = 30)
    public void displaysErrorsWhenUserDoesNotExists() {

        navPage.getLoginButtonFromNav().click();

        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");

        loginPage.getPasswordInput().sendKeys("password123");

        loginPage.getLoginButton().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(
                messagePopUpPage.getElementWithPopUpMsgText().getText(),
                "User does not exists",
                "[ERROR] PopUpMessage does not contains text-User does not exists");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Page URL does not contains /login");

    }

    @Test(priority = 40)

    public void displaysErrorsWhenPasswordIsWrong() {

        navPage.getLoginButtonFromNav().click();

        loginPage.getEmailInput().sendKeys("admin@admin.com");

        loginPage.getPasswordInput().sendKeys("password123");

        loginPage.getLoginButton().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(
                messagePopUpPage.getElementWithPopUpMsgText().getText(),
                "Wrong password",
                "[ERROR] PopUpMessage does not contains text-Wrong password");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Page URL does not contains /login");


    }

    @Test(priority = 50)

    public void login() throws InterruptedException {

        navPage.getLoginButtonFromNav().click();

        loginPage.getEmailInput().sendKeys("admin@admin.com");

        loginPage.getPasswordInput().sendKeys("12345");

        loginPage.getLoginButton().click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //  wait.until(ExpectedConditions.urlContains("/home"));

        // Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
        //"[ERROR] Page URL does not contains /home");

        Assert.assertTrue(
                wait.until(ExpectedConditions.urlContains("/home")),
                "[ERROR] Page URL does not contains /home");

    }

    @Test(priority = 60)
    public void logout() {

        Assert.assertTrue(navPage.
                        getLogOutButtonFromNav().isDisplayed(),
                "[ERROR] There is no Logout button in nav menu");

        navPage.getLogOutButtonFromNav().click();
    }
}