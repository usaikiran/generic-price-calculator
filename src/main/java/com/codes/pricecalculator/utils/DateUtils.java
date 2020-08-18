package com.codes.pricecalculator.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String dateFormat = "hh:mm:ss dd/MM/yyyy";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( dateFormat );

    public static Date convertToDate( String stringDate ) {
        try {
            return simpleDateFormat.parse( stringDate );
        } catch ( Exception err ) {
            System.out.println( "error parsing date "+stringDate+", expected format : "+dateFormat );
            System.exit( 0 );
        }
        return null;
    }
}
