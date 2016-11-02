package com.coherentlogic.treasurydirect.client.core.adapters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.adapter.core.exceptions.ConversionFailedException;
import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.coherentlogic.treasurydirect.client.core.domain.Debt;
import com.coherentlogic.treasurydirect.client.core.domain.Debts;
import com.coherentlogic.treasurydirect.client.core.factories.DebtsFactory;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

/**
 * Unit test for the {@link DebtsAdapter} class.
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class DebtsAdapterTest {

    private DebtsAdapter debtsAdapter;

    @Before
    public void setUp() throws Exception {

        GsonBuilder gsonBuilder = new GsonBuilder ();

        TypedFactory<Debts> debtsFactory = mock (TypedFactory.class);

        when(debtsFactory.getInstance()).thenReturn(new Debts ());

        debtsAdapter = new DebtsAdapter(gsonBuilder, new DebtsFactory());
    }

    @After
    public void tearDown() throws Exception {
        debtsAdapter = null;
    }

    void reviewDebt(Debt debt) {
        assertEquals("October 28, 2016 EDT", debt.getEffectiveDate());
        assertEquals("5510526280153.27", debt.getGovernmentHoldings());
        assertEquals("14309982958438.22", debt.getPublicDebt());
        assertEquals("19820509238591.49", debt.getTotalDebt());
    }

    // http://www.treasurydirect.gov/TA_WS/securities/912796CJ6/02/11/2014?format=xhtml 
    @Test
    public void testReadDebtsJsonReaderForResultOfSize1() throws IOException {

        File jsonFile = new File ("src/test/resources/debtsSingleResultExample.json");

        FileInputStream fis = new FileInputStream (jsonFile);

        String json = IOUtils.toString(fis);

        Debts debts = debtsAdapter.fromJson(json);

        Debt result = debts.getDebtList().get(0);

        reviewDebt(result);
    }

    // http://www.treasurydirect.gov/NP_WS/debt/search?startdate=2014-01-01&enddate=2014-02-01&format=json
    @Test
    public void testReadDebtsJsonReaderForResultOfSizeMany() throws IOException {

        File jsonFile = new File ("src/test/resources/DebtsMultipleResultsExample.json");

        FileInputStream fis = new FileInputStream (jsonFile);

        String json = IOUtils.toString(fis);

        Debts debts = debtsAdapter.fromJson(json);

        // Second to last debt is the same as that which is used in testReadJsonReaderForResultOfSize1.
        Debt result = debts.getDebtList().get(20);

        reviewDebt(result);
    }

    @Test(expected=ConversionFailedException.class)
    public void testReadPassingAnArray() throws IOException {

        JsonReader reader = mock (JsonReader.class);

        when (reader.peek()).thenReturn(JsonToken.BEGIN_ARRAY);

        debtsAdapter.read(reader);
    }

    @Test(expected=ConversionFailedException.class)
    public void testRead() throws IOException {

        JsonReader reader = mock (JsonReader.class);

        when (reader.peek()).thenReturn(JsonToken.BOOLEAN);

        debtsAdapter.read(reader);
    }

    /**
     * The code for this part of the adapter is generated so we will, for now, only test one part of it -- we can
     * generate the test logic for the entire method later.
     */
    @Test(expected=ConversionFailedException.class)
    public void testAsDebtWhereTheEffectiveDateMemberIsMissing () {

        JsonObject debtObject = new JsonObject();

        debtsAdapter.asDebt(debtObject);
    }
}
