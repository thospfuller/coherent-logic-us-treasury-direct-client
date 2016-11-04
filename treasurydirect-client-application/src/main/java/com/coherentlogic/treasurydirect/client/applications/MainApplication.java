package com.coherentlogic.treasurydirect.client.examples;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import com.coherentlogic.coherent.data.adapter.application.AbstractApplication;
import com.coherentlogic.coherent.data.adapter.application.GroovyEngine;
import com.coherentlogic.coherent.data.adapter.application.GroovyExampleBean;
import com.coherentlogic.coherent.data.adapter.core.builders.AbstractQueryBuilder;
import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.coherentlogic.treasurydirect.client.core.factories.QueryBuilderFactory;
import com.coherentlogic.treasurydirect.client.factories.DistributedCacheEnabledQueryBuilderFactory;

/**
 * The front-end for the FRED Client that allows users to directly work with the
 * {@link com.coherentlogic.fred.client.core.builders.QueryBuilder}. 
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.coherentlogic.treasurydirect.client")
public class MainApplication extends AbstractApplication {

    private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

    @Autowired
    private QueryBuilderFactory queryBuilderFactory;

    @Autowired
    private DistributedCacheEnabledQueryBuilderFactory distributedCacheEnabledQueryBuilderFactory;

    public static void main (String[] unused) throws InterruptedException {

        try {

            SpringApplicationBuilder builder =
                new SpringApplicationBuilder (MainApplication.class);

            builder
                .web(false)
                .headless(false)
                .registerShutdownHook(true)
                .run(unused);

        } catch (Throwable thrown) {
            log.error("ExampleApplication.main caught an exception.", thrown);
        }

        Thread.sleep(Long.MAX_VALUE);

        System.exit(-9999);
    }

    @Override
    protected String getDefaultExampleKey() {
        return "Securities Example (1)";
    }

    @Override
    protected void loadResources(
        ApplicationContext applicationContext,
        Map<String, GroovyExampleBean<? extends TypedFactory<AbstractQueryBuilder<String, Object>>>>
            groovyExampleBeanMap,
        GroovyEngine groovyEngine
    ) throws Exception {

        ClassPathResource securitiesExample1Resource = (ClassPathResource)
            applicationContext.getBean("securitiesExample1Resource");

        StringWriter securitiesExample1StringWriter = new StringWriter ();

        InputStream securitiesExample1In = securitiesExample1Resource.getInputStream();

        IOUtils.copy(securitiesExample1In, securitiesExample1StringWriter);

        String securitiesExample1Example = securitiesExample1StringWriter.toString();

        groovyExampleBeanMap.put(
            "Securities Example (1)",
            new GroovyExampleBean<TypedFactory<AbstractQueryBuilder<String,Object>>> (
                securitiesExample1Example,
                queryBuilderFactory,
                groovyEngine
            )
        );

        // ---------------------

        ClassPathResource securitiesExample2Resource = (ClassPathResource)
            applicationContext.getBean("securitiesExample2Resource");

        StringWriter securitiesExample2StringWriter = new StringWriter ();

        InputStream securitiesExample2In = securitiesExample2Resource.getInputStream();

        IOUtils.copy(securitiesExample2In, securitiesExample2StringWriter);

        String securitiesExample2Example = securitiesExample2StringWriter.toString();

        groovyExampleBeanMap.put(
            "Securities Example (2)",
            new GroovyExampleBean<TypedFactory<AbstractQueryBuilder<String,Object>>> (
                securitiesExample2Example,
                queryBuilderFactory,
                groovyEngine
            )
        );

        // ---------------------

        ClassPathResource securitiesMultipleResultsWithDataFrameExampleResource = (ClassPathResource)
            applicationContext.getBean("securitiesMultipleResultsWithDataFrameExampleResource");

        StringWriter securitiesMultipleResultsWithDataFrameExampleStringWriter = new StringWriter ();

        InputStream securitiesMultipleResultsWithDataFrameExampleIn =
            securitiesMultipleResultsWithDataFrameExampleResource.getInputStream();

        IOUtils.copy(
            securitiesMultipleResultsWithDataFrameExampleIn, securitiesMultipleResultsWithDataFrameExampleStringWriter);

        String securitiesMultipleResultsWithDataFrameExample =
            securitiesMultipleResultsWithDataFrameExampleStringWriter.toString();

        groovyExampleBeanMap.put(
            "Securities Example (3)",
            new GroovyExampleBean<TypedFactory<AbstractQueryBuilder<String,Object>>> (
                securitiesMultipleResultsWithDataFrameExample,
                queryBuilderFactory,
                groovyEngine
            )
        );

        // ---------------------

        ClassPathResource debtsMultipleResultsWithDataFrameExampleResource = (ClassPathResource)
            applicationContext.getBean("debtsMultipleResultsWithDataFrameExampleResource");

        StringWriter debtsMultipleResultsWithDataFrameExampleStringWriter = new StringWriter ();

        InputStream debtsMultipleResultsWithDataFrameExampleIn =
            debtsMultipleResultsWithDataFrameExampleResource.getInputStream();

        IOUtils.copy(
            debtsMultipleResultsWithDataFrameExampleIn, debtsMultipleResultsWithDataFrameExampleStringWriter);

        String debtsMultipleResultsWithDataFrameExample =
            debtsMultipleResultsWithDataFrameExampleStringWriter.toString();

        groovyExampleBeanMap.put(
            "Debt Example (1)",
            new GroovyExampleBean<TypedFactory<AbstractQueryBuilder<String,Object>>> (
                debtsMultipleResultsWithDataFrameExample,
                queryBuilderFactory,
                groovyEngine
            )
        );

     // --------------------- Distributed cache enabled below.

        groovyExampleBeanMap.put(
            "Debt Example (2) with distributed cache set on the queryBuilder",
            new GroovyExampleBean<TypedFactory<AbstractQueryBuilder<String,Object>>> (
                debtsMultipleResultsWithDataFrameExample,
                distributedCacheEnabledQueryBuilderFactory,
                groovyEngine
            )
        );
    }
}
