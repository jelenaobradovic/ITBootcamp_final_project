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
    public void checkInputTypes() {
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

    public void displaysErrorsWhenUserAlreadyExists() {
        String name = "Another User";
        String mail = "admin@admin.com";

        String password = "12345";

        String confirmPassword = "12345";
        navPage.getSignUpButtonFromNav().click();

        Assert.assertTrue(driver.
                        getCurrentUrl().
                        contains("/signup"),
                "[ERROR], page URL does not contains /signup");

        signupPage.
                getNameInputFieldAtSignUp().
                sendKeys(name);

        signupPage.
                getEmailInputFieldAtSignUp().
                sendKeys(mail);

        signupPage.
                getPasswordInputFieldAtSignUp().
                sendKeys(password);

        signupPage.
                getConfirmPasswordInputFieldAtSignUp().
                sendKeys(confirmPassword);

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

    @Test(priority = 40)


    public void signUp() throws InterruptedException {

        String name = "Jelena Obradovic";
        String mail = "vuckovic.jelena4@gmail.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignUpButtonFromNav().click();

        signupPage.
                getNameInputFieldAtSignUp().
                sendKeys(name);

        signupPage.
                getEmailInputFieldAtSignUp().
                sendKeys(mail);

        signupPage.
                getPasswordInputFieldAtSignUp().
                sendKeys(password);

        signupPage.
                getConfirmPasswordInputFieldAtSignUp().
                sendKeys(confirmPassword);

        signupPage.getSignMeUpButton().click();


        messagePopUpPage.waitForPopUpMessageCloseToBeClickable();


        messagePopUpPage.getCloseButtonFromVerifyPopUpMessage().click();

        navPage.getLogOutButtonFromNav().click();

    }

}
