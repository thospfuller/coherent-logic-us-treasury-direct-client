package com.coherentlogic.treasurydirect.client.core.adapters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coherentlogic.coherent.data.adapter.core.exceptions.ConversionFailedException;
import com.coherentlogic.coherent.data.adapter.core.exceptions.MethodNotSupportedException;
import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.coherentlogic.treasurydirect.client.core.domain.Debt;
import com.coherentlogic.treasurydirect.client.core.domain.Debts;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * 
 */
public class DebtsAdapter extends AbstractGSONBasedTypeAdapter<Debts> {

    private static final Logger log = LoggerFactory.getLogger(DebtsAdapter.class);

    public static final String BEAN_NAME = "debtsAdapter";

    public DebtsAdapter(TypedFactory<Debts> typedFactory) {
        super(typedFactory);
    }

    public DebtsAdapter(GsonBuilder gsonBuilder, TypedFactory<Debts> typedFactory) {
        super(gsonBuilder, typedFactory);
    }

    @Override
    public Debts read(JsonReader reader) throws IOException {

        log.info("read: method begins; reader: " + reader);

        Debts result = new Debts ();

        JsonElement debtsElement = null;

        JsonToken token = reader.peek ();

        if (JsonToken.BEGIN_ARRAY.equals(token)) {
            debtsElement = getGsonBuilder().create().fromJson(reader, JsonArray.class);
        } else if (JsonToken.BEGIN_OBJECT.equals(token)) {
            debtsElement = getGsonBuilder().create().fromJson(reader, JsonObject.class);
        } else {
            throw new ConversionFailedException("Unable to convert the JSON into either an array or an object due to "
                + "an unsupported token type (token: " + token + ").");
        }

        List<Debt> debtList = null;

        if (debtsElement.isJsonArray()) {

            JsonArray debtArray = debtsElement.getAsJsonArray();

            debtList = asDebtList (debtArray);

            result.setDebtList(debtList);

        } else {

            debtList = new ArrayList<Debt> ();

            Debt debt = asDebt(debtsElement.getAsJsonObject());

            debtList.add(debt);
        }

        result.setDebtList(debtList);

        log.info("read: method ends; result: " + result);

        return result;
    }

    Debt asDebt (JsonObject securityObject) {

        Debt result = new Debt ();

        String effectiveDate = securityObject.get("effectiveDate").toString();

        log.debug("effectiveDate: " + effectiveDate);

        result.setEffectiveDate(effectiveDate);

        String governmentHoldings = securityObject.get("governmentHoldings").toString();

        log.debug("governmentHoldings: " + governmentHoldings);

        result.setGovernmentHoldings(governmentHoldings);

        String publicDebt = securityObject.get("publicDebt").toString();

        log.debug("publicDebt: " + publicDebt);

        result.setPublicDebt(publicDebt);

        String totalDebt = securityObject.get("totalDebt").toString();

        log.debug("totalDebt: " + totalDebt);

        result.setTotalDebt(totalDebt);

        return result;
    }

    List<Debt> asDebtList (JsonArray debtArray) {

        List<Debt> result = new ArrayList<Debt> ();

        debtArray.forEach(
            element -> {

                Debt debt = asDebt ((JsonObject) element);

                result.add(debt);
            }
        );

        return result;
    }

    @Override
    public void write(JsonWriter writer, Debts debts) throws IOException {
        throw new MethodNotSupportedException ("The write method is not supported.");
    }
}
