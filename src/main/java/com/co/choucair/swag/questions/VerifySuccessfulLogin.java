package com.co.choucair.swag.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class VerifySuccessfulLogin implements Question<String> {
    protected Target element;

    public VerifySuccessfulLogin(Target element) {
        this.element = element;
    }

    @Override
    public String answeredBy(Actor actor) {
        return element.resolveFor(actor).getText();
    }

    public static Question<String> login(Target element) {
        return new VerifySuccessfulLogin(element);
    }

    /*public void algo(DataTable table) {
        List<LoginLombokData> loginDataList = LoginLombokData.setLoginData(table);

        for (List<LoginLombokData> data: loginDataList) {
            Check.whether(login(Target element)) // Verifica si el banner de productos es visible
                    .ifSo(() -> {
                        OnStage.theActorInTheSpotlight().should(
                                GivenWhenThen.seeThat(VerifySuccessfulLogin.login(BANNER_PRODUCTS), containsString(loginData.getExpectedTitle()))
                        );
                    })
                    .otherwise(() -> {
                        OnStage.theActorInTheSpotlight().should(
                                GivenWhenThen.seeThat(VerifySuccessfulLogin.login(MSG_ERROR), containsString("Epic sadface"))
                        );
                    });
        }
    }*/

}
