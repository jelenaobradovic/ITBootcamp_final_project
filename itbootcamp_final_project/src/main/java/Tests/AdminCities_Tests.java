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

        String city = "Jelena Obradovic's city";

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

    @Test(priority = 40)

    public void editCity() throws InterruptedException {
        String oldCityName = "Jelena Obradovic's city";
        String newCityName = "Jelena Obradovic's city Edited";

        navPage.getAdminButtonFromNav().click();
        navPage.getCitiesLinkFromAdminMenu().click();
        citiesPage.getSearchInputField().sendKeys(oldCityName);
        citiesPage.waitForCertainNumberOfRows(1);
        citiesPage.getEditButton(1).click();
        citiesPage.getEditCityNameInputField().click();

        citiesPage.selectTextAndReplace(newCityName);

        citiesPage.getEditedCitySaveButton().click();
        citiesPage.waitForPresenceOFSuccessSaveCityPopup();

        Assert.assertTrue(citiesPage.
                        getSuccessSaveCityPopUp().
                        getText().
                        contains("Saved successfully"),
                "[ERROR]PopUp Message doesn't contain text 'Saved successfully'");
    }

    @Test(priority = 50)

    public void searchCity() {

        String newCityName = "Jelena Obradovic's city Edited";
        navPage.getAdminButtonFromNav().click();
        navPage.getCitiesLinkFromAdminMenu().click();
        citiesPage.getSearchInputField().sendKeys(newCityName);
        citiesPage.waitForCertainNumberOfRows(1);
        Assert.assertEquals(
                citiesPage.
                        getCertainCell(1, 2).
                        getText(), newCityName,
                "[ERROR] Invalid search, city's names doesn't match");


    }

    @Test(priority = 60)
    public void deleteCity() {
        String cityNameForDelete = "Jelena Obradovic's city Edited";

        int rowNumber = 1;

        int columnNumber = 2;

        navPage.getAdminButtonFromNav().click();

        navPage.getCitiesLinkFromAdminMenu().click();

        citiesPage.getSearchInputField().sendKeys(cityNameForDelete);

        citiesPage.waitForCertainNumberOfRows(1);

        Assert.assertEquals(citiesPage.getCertainCell(1, 2).getText(),
                cityNameForDelete,
                "[ERROR]" +
                        " In the " + rowNumber + "  of " + columnNumber +
                        " column is not text " + cityNameForDelete + ".");

        citiesPage.getDeleteButton(1).click();

        citiesPage.waitForDeletePopUpDialogue();

        citiesPage.getDeleteButtonFromPopUpDialogue().click();

        citiesPage.waitForPopUpMessageForSuccededDeletion();
        Assert.assertTrue(citiesPage.getDeletePopUpMessageOfSuccess().getText().contains("Deleted successfu"),
               "[ERROR] Not valid test");


    }

    }

