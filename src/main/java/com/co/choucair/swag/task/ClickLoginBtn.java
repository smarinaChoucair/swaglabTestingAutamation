package com.co.choucair.swag.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.co.choucair.swag.userinterfaces.LoginPage.BTN_LOGIN;

public class ClickLoginBtn implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_LOGIN)
        );
    }

    public static ClickLoginBtn login(){
        return new ClickLoginBtn();
    }
}
