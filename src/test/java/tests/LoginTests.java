package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners(TestListener.class)
public class LoginTests extends BaseTest {


    @Test(description = "Успешная авторизация")
    public void successfulLoginTest() {
        loginSteps.login("sim28frvr@gmail.com", "123321qaz")
                .checkEntriesPageOpened();
    }


    @Test(description = "Неудачная авторизация")
    public void failedLoginTest() {
        loginSteps.login("sim28frvr@gmail.com", "123321")
                        .checkFiledLogin();
    }
}