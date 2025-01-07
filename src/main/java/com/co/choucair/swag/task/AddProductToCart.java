package com.co.choucair.swag.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;

import static com.co.choucair.swag.userinterfaces.Products.*;
import static com.co.choucair.swag.utils.Constantes.*;

public class AddProductToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        PRODUCTO = OnStage.theActorInTheSpotlight().asksFor(Text.of(SELECTED_PRODUCT_NAME));
        actor.attemptsTo(
                Click.on(SELECTED_PRODUCT_BTN),
                Click.on(CART_LINK)
        );
    }

    public static AddProductToCart addToCart() {
        return Instrumented.instanceOf(AddProductToCart.class).withProperties();
    }
}
