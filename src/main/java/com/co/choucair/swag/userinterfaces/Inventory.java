package com.co.choucair.swag.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Inventory {

    public static final Target BANNER_PRODUCTS = Target.the("products banner")
            .locatedBy("//div[@class=\"product_label\" and contains(text(), \"Products\")]");

}
