package com.co.choucair.swag.task;

import com.co.choucair.swag.models.LoginLombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.co.choucair.swag.userinterfaces.CheckoutInfo.*;

public class TypePersonalCheckoutInformation implements Task {

    protected LoginLombokData loginLombokData;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(loginLombokData.getFirstName()).into(FIELD_FIRST_NAME),
                Enter.theValue(loginLombokData.getLastName()).into(FIELD_LAST_NAME),
                Enter.theValue(loginLombokData.getPostalCode()).into(POSTAL_CODE),
                Click.on(BTN_CONTINUE)
        );
    }

    public static TypePersonalCheckoutInformation TypeCheckoutInfo(LoginLombokData loginLombokData){
        return Instrumented.instanceOf(TypePersonalCheckoutInformation.class).withProperties(loginLombokData);
    }
}
