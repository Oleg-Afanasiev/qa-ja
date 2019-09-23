package com.academy.automationpractice.bdd.stepdefs;

import com.academy.automationpractice.ddt.framework.page.AccountPage;
import com.academy.automationpractice.ddt.framework.page.HomePage;
import com.academy.automationpractice.ddt.framework.page.LoginPage;
import com.academy.automationpractice.ddt.framework.page.WomenPage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

import static com.academy.automationpractice.bdd.TestManagerContainer.manager;

public class StepDefinitions {

    @Before
    public void setUp(Scenario scenario) throws IOException {
    }

    @Given("^I am on home page$")
    public void goToHomePage() {
        manager.goTo().home();
    }

    @Then("^I click on signIn link$")
    public void clickSignInLink() {
        new HomePage(manager.getDriver())
                .clickSignIn();
    }

    @When("^I fill login '(.*?)'$")
    public void fillLogin(String login) {
        new LoginPage(manager.getDriver())
                .inputEmail(login);
    }

    @And("^I fill password '(.*?)'$")
    public void fillPassword(String password) {
        new LoginPage(manager.getDriver())
                .inputPassword(password);
    }

    @And("^click signIn button$")
    public void i_click_on_the_button() throws Throwable {
        new LoginPage(manager.getDriver())
                .clickSignIn(true);
    }

    @Then("^I should see '(.*?)' link$")
    public void i_should_see_the_button(String userName) throws Throwable {
        Assert.assertEquals(
                new AccountPage(manager.getDriver()).getUserNameCapture(),
                userName);
    }

    @Then("^I should make logout$")
    public void i_should_see_the_button() throws Throwable {
        new AccountPage(manager.getDriver())
                .clickLogout();
    }

    @Given("^Я нахожусь на домашней странице$")
    public void goToHomePage2() {
        manager.goTo().home();
    }

    @Then("^Я нажимаю ссылку signIn$")
    public void clickSignInLink2() {
        new HomePage(manager.getDriver())
                .clickSignIn();
    }

    @When("Ввожу логин {string}")
    public void fillLogin2(String login) {
        new LoginPage(manager.getDriver())
                .inputEmail(login);
    }

    @And("^Ввожу пароль '(.*?)'$")
    public void fillPassword2(String password) {
        new LoginPage(manager.getDriver())
                .inputPassword(password);
    }

    @And("^нажимаю отправить$")
    public void i_click_on_the_button2() throws Throwable {
        new LoginPage(manager.getDriver())
                .clickSignIn(false);
    }

    @Then("^должен увидеть сообщение об ошибке '(.*?)'$")
    public void i_should_see_the_button2(String msg) throws Throwable {
        Assert.assertEquals(
                new LoginPage(manager.getDriver()).getErrorMessage(),
                msg);
    }

    @Then("^I go on women page$")
    public void goOnWomenPage(){
        new HomePage(manager.getDriver()).clickWomenPageLink();
    }
    @Then("^I click on dresses link$")
    public void clickDressLink (){
        new WomenPage(manager.getDriver()).clickToDressesLink();
    }
    @Then("^I click on to list link$")
    public void clickToListLink(){
        new WomenPage(manager.getDriver()).clickToList();
    }
    @And("^I sort product by '(.*?)'$")
    public void sortProductBy(String sortBy){
        new WomenPage(manager.getDriver()).sortProductBy(sortBy);
    }
    @And("^I check actual product list and expected product list$")
    public void checkSortBy (){
        manager.women().verifySort();
    }

    @After
    public void tearDown(Scenario scenario){
    }
}
