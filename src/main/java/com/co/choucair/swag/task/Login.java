package com.co.choucair.swag.task;

import com.co.choucair.swag.models.LoginLombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.choucair.swag.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    protected LoginLombokData loginLombokData;

    public Login(LoginLombokData loginLombokData){
        this.loginLombokData = loginLombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(FIELD_USER, isVisible()).forNoMoreThan(20).seconds(),
            Enter.theValue(loginLombokData.getUser()).into(FIELD_USER),
            Enter.theValue(loginLombokData.getPass()).into(FIELD_PASS), Click.on(BTN_LOGIN)
        );
    }

    public static Login login(LoginLombokData loginLombokData){
        return Instrumented.instanceOf(Login.class).withProperties(loginLombokData);
    }
}