package com.codes.pricecalculator.utils;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class ConfigLoader {

    public static PriceConfig loadConfig() {

        JSONObject config = new JSONObject();
        try {
            String path = "src/main/resources/price-config.json";
            String stringConfig = Files.readString( Paths.get( path ), StandardCharsets.US_ASCII);
            config = new JSONObject( stringConfig );
            return new PriceConfig( config );
        } catch ( Exception e ) {
            System.out.println( "error parsing config" );
            e.printStackTrace();
            System.exit( 0 );
        }
        return new PriceConfig( config );
    }
}
