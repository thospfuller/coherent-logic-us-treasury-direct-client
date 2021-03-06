package com.coherentlogic.treasurydirect.client.core.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.coherentlogic.treasurydirect.client.core.adapters.DebtsAdapter;
import com.coherentlogic.treasurydirect.client.core.adapters.SecuritiesAdapter;
import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder;
import com.coherentlogic.treasurydirect.client.core.domain.Debt;
import com.coherentlogic.treasurydirect.client.core.domain.Debts;
import com.coherentlogic.treasurydirect.client.core.domain.Securities;
import com.coherentlogic.treasurydirect.client.core.domain.Security;
import com.coherentlogic.treasurydirect.client.core.extractors.DebtsExtractor;
import com.coherentlogic.treasurydirect.client.core.extractors.SecuritiesExtractor;
import com.coherentlogic.treasurydirect.client.core.factories.DebtsFactory;
import com.coherentlogic.treasurydirect.client.core.factories.SecuritiesFactory;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

@Configuration
public class GlobalConfiguration {

    public static final String
        TREASURY_DIRECT_XSTREAM_MARSHALLER = "treasuryDirectXStreamMarshaller",
        TREASURY_DIRECT_REST_TEMPLATE = "treasuryDirectRestTemplate",
        TREASURY_DIRECT_QUERY_BUILDER = "treasuryDirectQueryBuilder",
        GSON_BUILDER = "gsonBuilder",
        VERSION = "version";

    @Bean(name=QueryBuilder.BEAN_NAME)
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public QueryBuilder getQueryBuilder (
        @Qualifier(TREASURY_DIRECT_REST_TEMPLATE) RestTemplate restTemplate,
        @Qualifier(SecuritiesExtractor.BEAN_NAME) ResponseExtractor<Securities> securitiesExtractor,
        @Qualifier(DebtsExtractor.BEAN_NAME) ResponseExtractor<Debts> debtsExtractor
    ) {
        return new QueryBuilder (restTemplate, securitiesExtractor, debtsExtractor);
    }

    @Bean(name=SecuritiesExtractor.BEAN_NAME)
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ResponseExtractor<Securities> getSecuritiesExtractor (
        GsonBuilder gsonBuilder,
        SecuritiesAdapter securitiesAdapter
    ) {
        return new SecuritiesExtractor (gsonBuilder, securitiesAdapter);
    }

    @Bean(name=DebtsExtractor.BEAN_NAME)
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ResponseExtractor<Debts> getDebtsExtractor (
        GsonBuilder gsonBuilder,
        DebtsAdapter debtsAdapter
    ) {
        return new DebtsExtractor (gsonBuilder, debtsAdapter);
    }

    @Bean(name=TREASURY_DIRECT_REST_TEMPLATE)
    public RestTemplate getRestTemplate () {

        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>> ();

        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();

        messageConverters.add(gsonHttpMessageConverter);

        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }

    @Bean(name=SecuritiesExtractor.BEAN_NAME)
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ResponseExtractor<Securities> getSecuritiesExtractor (
        @Qualifier(GSON_BUILDER) GsonBuilder gsonBuilder,
        @Qualifier(SecuritiesAdapter.BEAN_NAME) TypeAdapter<Securities> securitiesAdapter
    ) {
        return new SecuritiesExtractor(gsonBuilder, securitiesAdapter);
    }

    /**
     * @TODO Check singleton scope.
     */
    @Bean(name=GSON_BUILDER)
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public GsonBuilder getGsonBuilder () {
        return new GsonBuilder ();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SecuritiesAdapter getSecuritiesAdapter (
        @Qualifier(GSON_BUILDER) GsonBuilder gsonBuilder,
        SecuritiesFactory securitiesFactory
    ) {
        return new SecuritiesAdapter (gsonBuilder, securitiesFactory);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DebtsAdapter getDebtsAdapter (
        @Qualifier(GSON_BUILDER) GsonBuilder gsonBuilder,
        DebtsFactory debtsFactory
    ) {
        return new DebtsAdapter (gsonBuilder, debtsFactory);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Securities getSecurities () {
        return new Securities ();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Security getSecurity () {
        return new Security ();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Debts getDebts () {
        return new Debts ();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Debt getDebt () {
        return new Debt ();
    }
}
