package steps;

import io.qameta.allure.Step;
import pages.EntriesPage;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;
    private EntriesPage entriesPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        entriesPage = new EntriesPage();
    }

    @Step
    public LoginSteps login(String username, String password){
        loginPage
                .open()
                .login(username, password);
        return this;
    }

    @Step("Check Entries page opened after login")
    public LoginSteps checkEntriesPageOpened(){
        entriesPage.isCreateButtonVisible();
        return this;
    }

    @Step("Check Login failed is visible after wrong password")
    public LoginSteps checkFiledLogin(){
        entriesPage.isFailLoginVisible();
        return  this;
    }
}
