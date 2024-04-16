package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable {
    private String name;
    private BigDecimal price;

    public Egg(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
