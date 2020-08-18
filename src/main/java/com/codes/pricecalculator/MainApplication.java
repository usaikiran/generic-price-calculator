package com.codes.pricecalculator;

import com.codes.pricecalculator.exceptions.NotFoundException;
import com.codes.pricecalculator.services.Calculator;
import com.codes.pricecalculator.utils.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class MainApplication {

    private static final Calculator calculator = new Calculator();

    public static void main( String[] args ) throws IOException {

        if( args.length==0 ) {
            System.out.println( "expected input file" );
            System.exit( 0 );
        } else if ( !Files.exists( Paths.get( args[0] ) ) ) {
            System.out.println( "invalid input, no such file found" );
            System.exit( 0 );
        }

        String path = args[0];
        String stringConfig = Files.readString( Paths.get( path ), StandardCharsets.US_ASCII);
        JSONObject jsonObject = new JSONObject( stringConfig );
        JSONArray array = jsonObject.getJSONArray( "inputs" );

        try {
            double sum = 0.0;
            for ( int i = 0; i < array.length(); i++ ) {
                sum += calculator.calculate( array.getJSONObject( i ).getString( "component" ),
                        array.getJSONObject( i ).getString( "part" ),
                        DateUtils.convertToDate( array.getJSONObject( i ).getString( "date" ) ) );
            }
            System.out.println( "Total cost : "+sum );
        } catch ( NotFoundException exception ) {
            System.out.println( exception.getMessage() );
        }
    }
}
