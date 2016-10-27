package com.coherentlogic.treasurydirect.client.core.adapters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coherentlogic.coherent.data.adapter.core.exceptions.ConversionFailedException;
import com.coherentlogic.coherent.data.adapter.core.exceptions.MethodNotSupportedException;
import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.coherentlogic.treasurydirect.client.core.domain.Securities;
import com.coherentlogic.treasurydirect.client.core.domain.Security;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * 
 */
public class SecuritiesAdapter extends AbstractGSONBasedTypeAdapter<Securities> {

    private static final Logger log = LoggerFactory.getLogger(SecuritiesAdapter.class);

    public static final String BEAN_NAME = "securitiesAdapter";

    public SecuritiesAdapter(TypedFactory<Securities> typedFactory) {
        super(typedFactory);
    }

    public SecuritiesAdapter(GsonBuilder gsonBuilder, TypedFactory<Securities> typedFactory) {
        super(gsonBuilder, typedFactory);
    }

    @Override
    public Securities read(JsonReader reader) throws IOException {

    	log.info("read: method begins; reader: " + reader);

        Securities result = new Securities ();

        JsonElement securitiesElement = null;

        try {
            securitiesElement = getGsonBuilder().create().fromJson(reader, JsonArray.class);
        } catch (JsonSyntaxException jsonSyntaxException) {
            try {
                securitiesElement = getGsonBuilder().create().fromJson(reader, JsonObject.class);
            } catch (Throwable thrown) {
                throw new ConversionFailedException("Unable to convert the JSON into either an array or an object.",
                    thrown);
            }
        }

        if (securitiesElement.isJsonArray()) {

            JsonArray securityArray = securitiesElement.getAsJsonArray();

            List<Security> securityList = asSecurityList (securityArray);

            result.setSecurityList(securityList);

        } else {

            List<Security> securityList = new ArrayList<Security> ();

            Security security = asSecurity(securitiesElement.getAsJsonObject());

            securityList.add(security);
        }

        log.info("read: method ends; result: " + result);

        return result;
    }

    Security asSecurity (JsonObject securityObject) {

        Security result = new Security ();

        String cusip = securityObject.get("cusip").toString();

        log.debug("cusip: " + cusip);

        result.setCusip(cusip);

        return result;
    }

    List<Security> asSecurityList (JsonArray securityArray) {

        List<Security> result = new ArrayList<Security> ();

        securityArray.forEach(
            element -> {

                Security security = asSecurity ((JsonObject) element);

                result.add(security);
            }
        );

        return result;
    }
    

    @Override
    public void write(JsonWriter writer, Securities securities) throws IOException {
        throw new MethodNotSupportedException ("The write method is not supported.");
    }
}

//DataEntry result = getEntryFactory().getInstance();
//
//JsonObject dataEntryObject = gsonBuilder.create().fromJson(reader, JsonObject.class);
//
//JsonElement figi = dataEntryObject.get(FIGI);
//
//result.setFigi(getAsString (FIGI, figi));
//
//JsonElement securityType = dataEntryObject.get(SECURITY_TYPE);
//
//result.setSecurityType(getAsString (SECURITY_TYPE, securityType));
//
//JsonElement marketSector = dataEntryObject.get(MARKET_SECTOR);
//
//result.setMarketSector(getAsString (MARKET_SECTOR, marketSector));
//
//JsonElement ticker = dataEntryObject.get(TICKER);
//
//result.setTicker(getAsString (TICKER, ticker));
//
//JsonElement name = dataEntryObject.get(NAME);
//
//result.setName(getAsString (NAME, name));
//
//JsonElement uniqueID = dataEntryObject.get(UNIQUE_ID);
//
//result.setUniqueID(getAsString (UNIQUE_ID, uniqueID));
//
//JsonElement exchangeCode = dataEntryObject.get(EXCH_CODE);
//
//result.setExchangeCode(getAsString (EXCH_CODE, exchangeCode));
//
//JsonElement shareClassFIGI = dataEntryObject.get(SHARE_CLASS_FIGI);
//
//result.setShareClassFIGI(getAsString (SHARE_CLASS_FIGI, shareClassFIGI));
//
//JsonElement compositeFigi = dataEntryObject.get(COMPOSIT_FIGI);
//
//result.setCompositeFIGI(getAsString (COMPOSIT_FIGI, compositeFigi));
//
//JsonElement uniqueIDFutOptElement = dataEntryObject.get(UNIQUE_ID_FUT_OPT);
//
//result.setUniqueIDForFutureOption(getAsString (UNIQUE_ID_FUT_OPT, uniqueIDFutOptElement));
//
//return result;