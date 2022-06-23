package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUp_Tests extends Basic_Test {

    @Test(priority = 10)

    public void visitTheSignUpPage() {

        navPage.getSignUpButtonFromNav().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR], page URL does not contains /signup");

    }


    @Test(priority = 20)
    public void checkInputTypes ()
    {
        navPage.getSignUpButtonFromNav().click();
        signupPage.getNameInputFieldAtSignUp().getAttribute("type");

        Assert.assertEquals(signupPage.
                getEmailInputFieldAtSignUp().
                getAttribute("type"), "email",
                "[ERROR] At sign up, attribute type for Email field is not-email ");



        Assert.assertEquals(signupPage.
                        getPasswordInputFieldAtSignUp().
                        getAttribute("type"), "password",
                "[ERROR] At sign up, attribute type for Password field is not-password");

        Assert.assertEquals(signupPage.
                        getConfirmPasswordInputFieldAtSignUp().
                        getAttribute("type"), "password",
                "[ERROR] At sign up, attribute type for ConfirmPassword" +
                        " field is not-password ");


    }

    @Test(priority = 30)

    public void displaysErrorsWhenUserAlreadyExists()
    {
        navPage.getSignUpButtonFromNav().click();

        Assert.assertTrue(driver.
                        getCurrentUrl().
                        contains("/signup"),
                "[ERROR], page URL does not contains /signup");

        signupPage.
                getNameInputFieldAtSignUp().
                sendKeys("Another User");

        signupPage.
                getEmailInputFieldAtSignUp().
                sendKeys("admin@admin.com");

        signupPage.
                getPasswordInputFieldAtSignUp().
                sendKeys("12345");

        signupPage.
                getConfirmPasswordInputFieldAtSignUp().
                sendKeys("12345");

        signupPage.getSignMeUpButton().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(
                messagePopUpPage.getElementWithPopUpMsgText().getText(),
                "E-mail already exists",
                "[ERROR] PopUpMessage for sign up, when user already exists," +
                        "does not contains valid text");

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page URL does not contains /signup");


    }



}
