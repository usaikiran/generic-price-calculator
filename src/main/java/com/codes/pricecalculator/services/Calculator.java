package com.codes.pricecalculator.services;

import com.codes.pricecalculator.exceptions.NotFoundException;
import com.codes.pricecalculator.models.PriceTag;
import com.codes.pricecalculator.utils.ConfigLoader;
import com.codes.pricecalculator.utils.PriceConfig;

import java.util.Date;

public class Calculator {

    private static final PriceConfig priceConfig = ConfigLoader.fetchConfig();

    public Double calculate( String component, String part, final Date date ) {
        return priceConfig.getPartDetails( component, part ).stream()
                .filter( p -> p.getFrom().before( date ) && p.getTo().after( date ) || p.getFrom().equals( date ) || p.getTo().equals( date ) )
                .findFirst().map( PriceTag::getPrice )
                .orElseThrow( () -> new NotFoundException( "config for "+component+", "+part+", "+date+" not found" ) );
    }
}
