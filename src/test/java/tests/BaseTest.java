package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.LoginSteps;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    LoginSteps loginSteps;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://my.monkkee.com/#/entries";
        Configuration.timeout = 10000;
        Configuration.browserSize = "maximize";
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        initPages();
    }

    public void initPages() {
        loginSteps = new LoginSteps();
    }


    @AfterMethod
    public void tearDown() {
        getWebDriver().quit();
    }
}
