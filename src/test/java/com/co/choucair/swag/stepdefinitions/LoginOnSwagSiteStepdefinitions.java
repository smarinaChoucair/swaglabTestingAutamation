package com.co.choucair.swag.stepdefinitions;

import com.co.choucair.swag.models.LoginLombokData;
import com.co.choucair.swag.questions.ConfirmCartAdition;
import com.co.choucair.swag.questions.ValidateSuccesfulBuy;
import com.co.choucair.swag.questions.VerifySuccessfulLogin;
import com.co.choucair.swag.task.AddProductToCart;
import com.co.choucair.swag.task.ClickToCheckout;
import com.co.choucair.swag.task.TypeLoginCredentials;
import com.co.choucair.swag.task.TypePersonalCheckoutInformation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.swag.userinterfaces.Cart.*;
import static com.co.choucair.swag.userinterfaces.CheckoutOverview.*;
import static com.co.choucair.swag.userinterfaces.Finish.*;
import static com.co.choucair.swag.userinterfaces.Products.*;
import static com.co.choucair.swag.utils.Constantes.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class LoginOnSwagSiteStepdefinitions {

    //@Login
    @Given("that the user was on the website")
    public void thatTheUserWasOnTheWebsite() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(
                Open.url(URL_SWAGLABS)
        );
    }

    @When("attemps to login with the correct credentials")
    public void attempsToLoginWithTheCorrectCredentials(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TypeLoginCredentials.login(LoginLombokData.setLoginData(table).get(0))
        );
    }

    @Then("^he will see the title (.*) on screen$")
    public void heWillSeeTheTitleProductsOnScreen(String title) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerifySuccessfulLogin.login(BANNER_PRODUCTS), containsString(title))
        );
    }

    //@Buy
    @When("^adds some (.*) to the cart$")
    public void addsSomeProductToTheCart(String product){
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductToCart.addToCart()
        );
    }

    @When("^checks that exactly (.*) is on the cart$")
    public void checksThatExactlyProductIsOnTheCart(){
        OnStage.theActorInTheSpotlight().should(
            seeThat(ConfirmCartAdition.confirmAdition(SELECTED_PRODUCT_NAME_CART), containsString((PRODUCTO)))
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickToCheckout.toCheckout()
        );
    }

    @When("fills the checkout personal information fields")
    public void fillsTheCheckoutPersonalInformationFields(DataTable table){
        OnStage.theActorInTheSpotlight().attemptsTo(
                TypePersonalCheckoutInformation.TypeCheckoutInfo(LoginLombokData.setLoginData(table).get(0))
        );
    }

    @Then("^he will see the title (.*) on screen$")
    public void heWillSeeTheTitleMessageOnScreen(String message){
        seeThat(ValidateSuccesfulBuy.validateBuy(CONFIRMATION_TITLE),containsString(message));
    }

}
