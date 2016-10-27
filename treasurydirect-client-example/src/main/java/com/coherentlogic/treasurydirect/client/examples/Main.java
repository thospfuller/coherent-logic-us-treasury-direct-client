package com.coherentlogic.treasurydirect.client.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder;
import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder.SecurityType;
import com.coherentlogic.treasurydirect.client.core.domain.Securities;

/**
 * 
 *
 */
@SpringBootApplication
//@EnableAutoConfiguration(exclude = { JacksonAutoConfiguration.class })
@ComponentScan(basePackages="com.coherentlogic.treasurydirect.client")
public class Main implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... unused) throws Exception {

        QueryBuilder queryBuilder = applicationContext.getBean(QueryBuilder.class);

        System.out.println("########################### BACK! ############################### ");

        Securities securities = queryBuilder.TA_WS().securities(SecurityType.FRN).doGetAsSecurities();

        System.out.println("securities: " + securities);
    }

    public static void main(String[] unused) throws InterruptedException {

        try {

            SpringApplicationBuilder builder = new SpringApplicationBuilder (Main.class);

            builder
                .web(false)
                .headless(false)
                .registerShutdownHook(true)
                .run(unused);

        } catch (Throwable thrown) {
            log.error("Main.main caught an exception.", thrown);
            thrown.printStackTrace(System.err);
        }

        Thread.sleep(Long.MAX_VALUE);

        System.exit(-9999);
    }
}
