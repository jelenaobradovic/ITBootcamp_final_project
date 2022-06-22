package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class Basic_Test {


    protected WebDriver driver;
    protected Nav_Page navPage;
    protected MessagePopUp_Page messagePopUpPage;
    protected Cities_Page citiesPage;
    protected LogIn_Page loginPage;
    protected SignUp_Page signupPage;
    protected String baseURL = "https://vue-demo.daniel-avellaneda.com";


    @BeforeClass

    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        navPage = new Nav_Page(driver);
        loginPage = new LogIn_Page(driver);
        signupPage = new SignUp_Page(driver);
        citiesPage = new Cities_Page(driver);
        messagePopUpPage = new MessagePopUp_Page(driver);


    }

    @BeforeMethod

    public void beforeMethod() {
        driver.get(baseURL);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
