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
import com.coherentlogic.treasurydirect.client.core.domain.Securities;
import com.coherentlogic.treasurydirect.client.core.domain.Security;
import com.coherentlogic.treasurydirect.client.core.factories.SecuritiesFactory;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

/**
 * Unit test for the {@link SecuritiesAdapter} class.
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class SecuritiesAdapterTest {

    private SecuritiesAdapter securitiesAdapter;

    @Before
    public void setUp() throws Exception {

        GsonBuilder gsonBuilder = new GsonBuilder ();

        TypedFactory<Securities> securitiesFactory = mock (TypedFactory.class);

        when(securitiesFactory.getInstance()).thenReturn(new Securities ());

        securitiesAdapter = new SecuritiesAdapter(gsonBuilder, new SecuritiesFactory());
    }

    @After
    public void tearDown() throws Exception {
        securitiesAdapter = null;
    }

    void reviewSecurity (Security security) {
        assertEquals("912796CJ6", security.getCusip ());
        // TODO: Check the other properties.
        assertEquals("foo45", security.getXmlFilenameSpecialAnnouncement());
    }

    // http://www.treasurydirect.gov/TA_WS/securities/912796CJ6/02/11/2014?format=xhtml 
    @Test
    public void testReadSecuritiesJsonReaderForResultOfSize1() throws IOException {

        File jsonFile = new File ("src/test/resources/securitiesSingleResultExample.json");

        FileInputStream fis = new FileInputStream (jsonFile);

        String json = IOUtils.toString(fis);

        Securities securities = securitiesAdapter.fromJson(json);

        Security result = securities.getSecurityList().get(0);

        reviewSecurity(result);
    }

    @Test
    public void testReadSecuritiesJsonReaderForResultOfSizeMany() throws IOException {

        File jsonFile = new File ("src/test/resources/securitiesMultipleResultsExample.json");

        FileInputStream fis = new FileInputStream (jsonFile);

        String json = IOUtils.toString(fis);

        Securities securities = securitiesAdapter.fromJson(json);

        // Second to last security is the same as that which is used in testReadJsonReaderForResultOfSize1.
        Security result = securities.getSecurityList().get(33);

        reviewSecurity(result);
    }

    @Test(expected=ConversionFailedException.class)
    public void testRead() throws IOException {

        JsonReader reader = mock (JsonReader.class);

        when (reader.peek()).thenReturn(JsonToken.BOOLEAN);

        securitiesAdapter.read(reader);
    }

    @Test(expected=ConversionFailedException.class)
    public void testAsSecurityWhereIssueDateMemberIsMissing() {

        JsonObject securityObject = new JsonObject();

        securitiesAdapter.asSecurity(securityObject);
    }
}
