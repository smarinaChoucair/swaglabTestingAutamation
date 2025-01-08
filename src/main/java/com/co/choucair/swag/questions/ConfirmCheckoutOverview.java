package com.co.choucair.swag.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ConfirmCheckoutOverview implements Question<String>{
    protected Target element;

    public ConfirmCheckoutOverview(Target element) {
        this.element = element;
    }

    @Override
    public String answeredBy(Actor actor) {
        return element.resolveFor(actor).getText();
    }

    public static Question<String> confirmCheckout(Target element){
        return new ConfirmCheckoutOverview(element);
    }

}

