package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCities_Tests extends Basic_Test {


    @Test(priority = 10)
    public void visitTheAdminCitiesPageAndListCities() {

        navPage.getLoginButtonFromNav().click();

        loginPage.getEmailInput().sendKeys("admin@admin.com");

        loginPage.getPasswordInput().sendKeys("12345");

        loginPage.getLoginButton().click();

        navPage.getAdminButtonFromNav().click();

        navPage.getCitiesLinkFromAdminMenu().click();

        Assert.assertTrue(driver.
                        getCurrentUrl().
                        contains("/admin/cities"),
                "[ERROR] URL does not contain /admin/cities");

    }

    @Test(priority = 20)
    public void checkInputTypesForCreateOREditNewCity() {
        navPage.getAdminButtonFromNav().click();
        navPage.getCitiesLinkFromAdminMenu().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForPresenceOfNewItemDialogue();

        Assert.assertEquals(
                citiesPage.
                        getNewItemNameInputField().
                        getAttribute("type"), "text",
                "[ERROR] Attribute Type for Input field is not-text");

    }

    @Test(priority = 30)
    public void createNewCity() {

        String city = "JelenaObradovic's city";

        navPage.getAdminButtonFromNav().click();
        navPage.getCitiesLinkFromAdminMenu().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForPresenceOfNewItemDialogue();
        citiesPage.
                getNewItemNameInputField().
                sendKeys(city);

        citiesPage.getSaveCitiesButton().click();
        citiesPage.waitForPresenceOFSuccessSaveCityPopup();

        Assert.assertTrue(citiesPage.
                        getSuccessSaveCityPopUp().
                        getText().
                        contains("Saved successfully"),
                "[ERROR] Popup SaveCity window does't contains 'Saved successfully'");
    }




}
