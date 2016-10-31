package com.coherentlogic.treasurydirect.client.core.extractors;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;

import com.coherentlogic.treasurydirect.client.core.domain.Debts;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

/**
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class DebtsExtractor implements ResponseExtractor<Debts> {

    private static final Logger log = LoggerFactory.getLogger(DebtsExtractor.class);

    public static final String BEAN_NAME = "debtsExtractor";

    private final GsonBuilder gsonBuilder;

    public DebtsExtractor (GsonBuilder gsonBuilder, TypeAdapter<Debts> debtsAdapter) {
        this.gsonBuilder = gsonBuilder;
        gsonBuilder.registerTypeAdapter(Debts.class, debtsAdapter);
    }

    @Override
    public Debts extractData(ClientHttpResponse response) throws IOException {

        InputStream in = response.getBody();

        String json = IOUtils.toString(in);

        log.info("json: " + json);

        Debts result = gsonBuilder.create().fromJson(json, Debts.class);

        return result;
    }
}
