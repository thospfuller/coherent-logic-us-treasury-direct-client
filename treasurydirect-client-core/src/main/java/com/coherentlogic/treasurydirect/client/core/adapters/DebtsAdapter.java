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
 * An adapter that converts debt-related JSON into an instance of {@link Debts}.
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class DebtsAdapter extends AbstractGSONBasedTypeAdapter<Debts> {

    private static final Logger log = LoggerFactory.getLogger(DebtsAdapter.class);

    public static final String BEAN_NAME = "debtsAdapter", ENTRIES = "entries";

    public static final String
        EFFECTIVE_DATE = "effectiveDate",
        GOVERNMENT_HOLDINGS = "governmentHoldings",
        PUBLIC_DEBT = "publicDebt",
        TOTAL_DEBT = "totalDebt";

    public DebtsAdapter(TypedFactory<Debts> typedFactory) {
        super(typedFactory);
    }

    public DebtsAdapter(GsonBuilder gsonBuilder, TypedFactory<Debts> typedFactory) {
        super(gsonBuilder, typedFactory);
    }

    /**
     * Method converts debt-related JSON into an instance of Debts and returns the result.
     *
     * Single debt JSON:
     *
     * {
     *     "effectiveDate":"October 28, 2016 EDT",
     *     "governmentHoldings":5510526280153.27,
     *     "publicDebt":14309982958438.22,
     *     "totalDebt":19820509238591.49
     * }
     *
     * Multiple debts JSON:
     *
     * {
     *     "entries":
     *         [
     *             {
     *                 "effectiveDate":"January 31, 2014 EST",
     *                 "governmentHoldings":4984876805567.80,
     *                 "publicDebt":12308142849415.81,
     *                 "totalDebt":17293019654983.61
     *             },
     *             {
     *                 "effectiveDate":"January 30, 2014 EST",
     *                 ...
     *             }
     *         ]
     * }
     *
     * @see http://www.treasurydirect.gov/NP_WS/debt/current?format=json
     * @see http://www.treasurydirect.gov/NP_WS/debt/search?startdate=2014-01-01&enddate=2014-02-01&format=json
     */
    @Override
    public Debts read(JsonReader reader) throws IOException {

        log.info("read: method begins; reader: " + reader);

        Debts result = new Debts ();

        JsonElement debtsElement = null;

        JsonToken token = reader.peek ();

        if (JsonToken.BEGIN_ARRAY.equals(token)) {
            throw new ConversionFailedException("Unable to convert the JSON into an instance of Debts due to "
                + "the resultant json starting with an array token and this is not expected.");
            //debtsElement = getGsonBuilder().create().fromJson(reader, JsonArray.class);
        } else if (JsonToken.BEGIN_OBJECT.equals(token)) {
            debtsElement = getGsonBuilder().create().fromJson(reader, JsonObject.class);
        } else {
            throw new ConversionFailedException("Unable to convert the JSON into either an array or an object due to "
                + "an unsupported token type (token: " + token + ").");
        }

        List<Debt> debtList = new ArrayList<Debt> ();

        asDebtList (debtsElement.getAsJsonObject(), debtList);

        result.setDebtList(debtList);

        log.info("read: method ends; result: " + result);

        return result;
    }

    /**
     * Method creates a new instance of {@link Debt}, maps the debtObject parameters to the debt object, and returns the
     * result.
     *
     * Note that the debtObject should have the following format:
     *
     * {
     *     "effectiveDate":"January 31, 2014 EST",
     *     "governmentHoldings":4984876805567.80,
     *     "publicDebt":12308142849415.81,
     *     "totalDebt":17293019654983.61
     * }
     */
    Debt asDebt (JsonObject debtObject) {

        Debt result = new Debt ();

        asDebt (debtObject, result);

        return result;
    }

    /**
     * Method maps the properties of the single debtObject, below, into the debt object.
     *
     * {
     *     "effectiveDate":"January 31, 2014 EST",
     *     "governmentHoldings":4984876805567.80,
     *     "publicDebt":12308142849415.81,
     *     "totalDebt":17293019654983.61
     * }
     */
    void asDebt (JsonObject debtObject, Debt debt) {

        String effectiveDate = debtObject.get(EFFECTIVE_DATE).toString();

        log.debug("effectiveDate: " + effectiveDate);

        debt.setEffectiveDate(effectiveDate);

        String governmentHoldings = debtObject.get(GOVERNMENT_HOLDINGS).toString();

        log.debug("governmentHoldings: " + governmentHoldings);

        debt.setGovernmentHoldings(governmentHoldings);

        String publicDebt = debtObject.get(PUBLIC_DEBT).toString();

        log.debug("publicDebt: " + publicDebt);

        debt.setPublicDebt(publicDebt);

        String totalDebt = debtObject.get(TOTAL_DEBT).toString();

        log.debug("totalDebt: " + totalDebt);

        debt.setTotalDebt(totalDebt);
    }

    /**
     * Method converts the debtArray, as below, into an instance of one or more {@link Debt} objects, and adds the
     * results to the debtList.
     *
     * [
     *     {
     *         "effectiveDate":"January 31, 2014 EST",
     *         "governmentHoldings":4984876805567.80,
     *         "publicDebt":12308142849415.81,
     *         "totalDebt":17293019654983.61
     *     },
     *     {
     *         "effectiveDate":"January 30, 2014 EST",
     *         ...
     *     }
     * ]
     */
    void asDebtList (JsonArray debtArray, List<Debt> debtList) {

        for (JsonElement debtElement : debtArray) {

            if (debtElement.isJsonObject()) { // expect objects in the entries array.

                JsonObject debtObject = debtElement.getAsJsonObject();

                Debt debt = asDebt (debtObject);

                debtList.add(debt);

            } else
                throw new ConversionFailedException("Expected an instance of JsonObject for the debtElement: " +
                    debtElement);
        }
    }

    /**
     * Method converts a list of entries of debt data OR a single instance of debt data and adds the result(s) to the
     * debtList.
     *
     * For example, the debtObject may look like EITHER:
     *
     * {
     *     "effectiveDate":"October 28, 2016 EDT",
     *     "governmentHoldings":5510526280153.27,
     *     "publicDebt":14309982958438.22,
     *     "totalDebt":19820509238591.49
     * }
     *
     * OR
     *
     * {
     *     "entries":
     *         [
     *             {
     *                 "effectiveDate":"January 31, 2014 EST",
     *                 "governmentHoldings":4984876805567.80,
     *                 "publicDebt":12308142849415.81,
     *                 "totalDebt":17293019654983.61
     *             },
     *             {
     *                 "effectiveDate":"January 30, 2014 EST",
     *                 ...
     *             }
     *         ]
     * }
     *
     * -- any other format is not supported.
     */
    void asDebtList (JsonObject debtObject, List<Debt> debtList) {

        if (debtObject.has(ENTRIES)) {

            JsonElement entriesElement = debtObject.get(ENTRIES);

            if (entriesElement.isJsonArray()) {

                JsonArray entriesArray = entriesElement.getAsJsonArray();

                asDebtList(entriesArray, debtList);
            } else
                throw new ConversionFailedException("Expected an instance of JsonArray for the entriesElement: " +
                    entriesElement);
        } else {

            // If there are no entries then the debtObject should be convertible to a single instance of Debt, otherwise
            // something is amiss with the JSON and we have a problem or we may not have accounted for converting the
            // JSON possibly.

            Debt result = asDebt(debtObject);

            debtList.add(result);
        }
    }

    /**
     * Method converts the debtArray into list of {@link Debt} objects -- for example, the debtArray should contain the
     * following:
     *
     * [
     *     {"effectiveDate":"January 31, 2014 EST",
     *      "governmentHoldings":4984876805567.80,
     *      "publicDebt":12308142849415.81,
     *      "totalDebt":17293019654983.61
     *     },
     *     ....
     * ]
     */
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

    /**
     * Method is not supported.
     */
    @Override
    public void write(JsonWriter writer, Debts debts) throws IOException {
        throw new MethodNotSupportedException ("The write method is not supported.");
    }
}
