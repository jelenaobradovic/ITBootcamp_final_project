package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Locale_Tests extends Basic_Test {

    @Test(priority = 10)
    public void setLanguageToES(){

        navPage.getHomeButtonFromNav().click();
        navPage.getLanguageButton().click();
        navPage.getESLanguageButton().click();
        Assert.assertTrue(navPage.geth1HeaderOfPage().getText().contains("Página de aterrizaje"),
                "[ERROR]Page header h1 doesn't contain text 'Página de aterrizaje'");

    }

    @Test(priority = 20)
    public void setLanguageToFR(){

        navPage.getHomeButtonFromNav().click();
        navPage.getLanguageButton().click();
        navPage.getFRLanguageButton().click();
        Assert.assertTrue(navPage.geth1HeaderOfPage().getText().contains("Page d'atterrissage"),
                "[ERROR]Page header h1 doesn't contain text 'Page d'atterrissage'" );

    }

    @Test(priority = 30)
    public void setLanguageToCN(){

        navPage.getHomeButtonFromNav().click();
        navPage.getLanguageButton().click();
        navPage.getCNLanguageButton().click();
        Assert.assertTrue(navPage.geth1HeaderOfPage().getText().contains("首页"),
                "[ERROR]Page header h1 doesn't contain text '首页'" );
    }

    @Test(priority = 40)
    public void setLanguageToEN(){

        navPage.getHomeButtonFromNav().click();
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        Assert.assertTrue(navPage.geth1HeaderOfPage().getText().contains("Landing"),
                "[ERROR]Page header h1 doesn't contain text 'Landing'" );
    }
}
