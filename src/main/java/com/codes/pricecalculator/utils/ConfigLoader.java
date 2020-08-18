package com.codes.pricecalculator.utils;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class ConfigLoader {

    private static final String path = "src/main/resources/price-config.json";
    private static PriceConfig priceConfig;

    public static PriceConfig fetchConfig() {

        if( priceConfig==null ) {
            loadConfig( path );
        }
        return priceConfig;
    }

    public static void loadConfig( String path ) {

        JSONObject config = new JSONObject();
        try {
            String stringConfig = Files.readString( Paths.get( path ), StandardCharsets.US_ASCII);
            config = new JSONObject( stringConfig );

            priceConfig = new PriceConfig( config );
        } catch ( Exception e ) {
            System.out.println( "error parsing config" );
            e.printStackTrace();
            System.exit( 0 );
        }
    }
}
