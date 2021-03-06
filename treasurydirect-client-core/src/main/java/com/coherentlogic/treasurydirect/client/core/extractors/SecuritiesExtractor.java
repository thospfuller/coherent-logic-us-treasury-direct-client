package com.coherentlogic.treasurydirect.client.core.extractors;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;

import com.coherentlogic.treasurydirect.client.core.domain.Securities;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

/**
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class SecuritiesExtractor implements ResponseExtractor<Securities> {

    private static final Logger log = LoggerFactory.getLogger(SecuritiesExtractor.class);

    public static final String BEAN_NAME = "securitiesExtractor";

    private final GsonBuilder gsonBuilder;

    public SecuritiesExtractor (GsonBuilder gsonBuilder, TypeAdapter<Securities> securitiesAdapter) {
        this.gsonBuilder = gsonBuilder;
        gsonBuilder.registerTypeAdapter(Securities.class, securitiesAdapter);
    }

    @Override
    public Securities extractData(ClientHttpResponse response) throws IOException {

        InputStream in = response.getBody();

        String json = IOUtils.toString(in);

        log.debug("json: " + json);

        Securities result = gsonBuilder.create().fromJson(json, Securities.class);

        return result;
    }
}
