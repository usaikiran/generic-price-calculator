package com.codes.pricecalculator.models;

import java.util.Date;

public class PriceTag {

    double price;
    Date from;
    Date to;

    public double getPrice() {
        return price;
    }

    public PriceTag( String price, Date from, Date to ) {
        this.price = Double.parseDouble( price );
        this.from = from;
        this.to = to;
    }

    public void setPrice( double price ) {
        this.price = price;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom( Date from ) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo( Date to ) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "PriceTag{"+
                "price="+price+
                ", from="+from+
                ", to="+to+
                '}';
    }
}
