package com.co.choucair.swag.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ConfirmCartAdition implements Question {
    protected Target element;

    public ConfirmCartAdition(Target element) {
        this.element = element;
    }

    @Override
    public String answeredBy(Actor actor) {
        return element.resolveFor(actor).getText();
    }

    public static Question<String> confirmAdition(Target element){
        return new ConfirmCartAdition(element);
    }

}
