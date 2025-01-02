package com.co.choucair.swag.stepdefinitions;

import com.co.choucair.swag.models.LoginLombokData;
import com.co.choucair.swag.questions.VerifySuccessfulLogin;
import com.co.choucair.swag.task.ClickLoginBtn;
import com.co.choucair.swag.task.TypeCredentials;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.swag.userinterfaces.Inventory.*;
import static com.co.choucair.swag.userinterfaces.LoginPage.*;
import static com.co.choucair.swag.utils.Constantes.*;
import static org.hamcrest.Matchers.containsString;

public class LoginOnSwagSiteStepdefinitions {

    @Given("that the user was on the website")
    public void thatTheUserWasOnTheWebsite() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(
                Open.url(URL_SWAGLABS)
        );
    }

    @When("attemps to login with the correct credentials")
    public void attempsToLoginWithTheCorrectCredentials(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TypeCredentials.login(LoginLombokData.setLoginData(table).get(0))
        );
    }

    @When("click in the login button")
    public void clickInTheLoginButton(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickLoginBtn.login()
        );
    }

    @Then("^he will see the title (.*) on screen$")
    public void heWillSeeTheTitleProductsOnScreen(String title) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(VerifySuccessfulLogin.login(BANNER_PRODUCTS), containsString(title))
        );
    }

    //Unhappy Path

    @When("attemps to login with the wrong username, but correct pass")
    public void attempsToLoginWithTheWrongUsernameButCorrectPass(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TypeCredentials.login(LoginLombokData.setLoginData(table).get(0))
        );
    }

    @When("attemps to login with the correct username, but wrong pass")
    public void attempsToLoginWithTheCorrectUsernameButWrongPass(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TypeCredentials.login(LoginLombokData.setLoginData(table).get(0))
        );
    }

    @When("attemps to login with no credentials")
    public void attempsToLoginWithNoCredentials() {
    }

    @Then("^he will see the error message (.*) on screen")
    public void heWillSeeTheMessageOfErrorOnScreen(String error) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(VerifySuccessfulLogin.login(MSG_ERROR), containsString(error))
        );
    }

}
