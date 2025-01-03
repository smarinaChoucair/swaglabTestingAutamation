package com.co.choucair.swag.stepdefinitions;

import com.co.choucair.swag.models.LoginLombokData;
import com.co.choucair.swag.questions.VerifySuccessfulLogin;
import com.co.choucair.swag.task.Login;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.swag.userinterfaces.Inventory.*;
import static com.co.choucair.swag.utils.Constantes.*;
import static org.hamcrest.Matchers.containsString;

public class LoginOnSwagSiteStepdefinitions {

    @Given("that the user was on the website")
    public void thatTheUserWasOnTheWebsite() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(
                Open.url(URL_SWAGLABS)
        );
    }

    @When("attemps to login with credentials")
    public void attempsToLoginWithTheCorrectCredentials(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.login(LoginLombokData.setLoginData(table).get(0))
        );
    }

    @Then("^he will see the title (.*) on screen$")
    public void heWillSeeTheTitleProductsOnScreen(String title) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(VerifySuccessfulLogin.login(BANNER_PRODUCTS), containsString(title))
        );
    }

}
