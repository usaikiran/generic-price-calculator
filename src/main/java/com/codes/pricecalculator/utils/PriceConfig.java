package com.codes.pricecalculator.utils;

import com.codes.pricecalculator.models.PriceTag;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.codes.pricecalculator.utils.DateUtils.convertToDate;

public class PriceConfig  {

    JSONObject jsonObject;

    public PriceConfig( JSONObject jsonObject ) {
        this.jsonObject = jsonObject;
    }

    public List<String> getComponents() {
        return new ArrayList<>( jsonObject.keySet() );
    }

    public List<String> getComponentParts( String component ) {

        List<String> componentParts = new ArrayList<>();
        if ( jsonObject.has( component ) ) {
            componentParts = new ArrayList<>( jsonObject.getJSONObject( component ).keySet() );
        }
        return componentParts;
    }

    public List<PriceTag> getPartDetails( String component, String part ) {

        List<PriceTag> priceTags = new ArrayList<>();
        if( jsonObject.has( component ) && jsonObject.getJSONObject( component ).has( part ) ) {
            JSONArray array = jsonObject.getJSONObject( component ).getJSONArray( part );
            for ( int i=0; i<array.length(); i++ ) {
                priceTags.add( new PriceTag( array.getJSONObject( i ).getString( "price" ),
                        convertToDate( array.getJSONObject( i ).getString( "from" ) ),
                        convertToDate( array.getJSONObject( i ).getString( "to" ) ) ) );
            }
        }
        return priceTags;
    }
}
