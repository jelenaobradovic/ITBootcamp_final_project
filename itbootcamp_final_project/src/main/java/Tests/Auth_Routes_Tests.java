package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Auth_Routes_Tests extends Basic_Test {


    @Test(priority = 100)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.navigate().to(baseURL + "/home");
        Assert.assertTrue(driver.
                        getCurrentUrl().
                        contains("/login"),
                "[Error] URL does not contain -login");
    }

    @Test(priority = 200)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.navigate().to(baseURL + "/profile");
        Assert.assertTrue(driver.
                        getCurrentUrl().
                        contains("/login"),
                "[Error] URL does not contain -login");
    }

    @Test(priority = 300)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.navigate().to(baseURL + "/admin/cities");
        Assert.assertTrue(driver.
                        getCurrentUrl().
                        contains("/login"),
                "[Error] URL does not contain -login");
    }

    @Test(priority = 400)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.navigate().to(baseURL + "/admin/users");
        Assert.assertTrue(driver.
                        getCurrentUrl().
                        contains("/login"),
                "[Error] URL does not contain -login");
    }

}
