package com.coherentlogic.treasurydirect.client.core.builders;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder.SecurityType;
import com.coherentlogic.treasurydirect.client.core.domain.Securities;

/**
 * @see <a href="https://www.treasurydirect.gov/webapis/webapisindex.htm">TreasuryDirect.gov Web APIs</a>
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)//classes={GlobalConfiguration.class})
//@ComponentScan(basePackages="com.coherentlogic.treasurydirect.client")
public class QueryBuilderTest extends AbstractJUnit4SpringContextTests {

	@Configuration
	@ComponentScan(basePackages="com.coherentlogic.treasurydirect.client")
	static class Foo {}
	
//    @Autowired
//    private ApplicationContext applicationContext;

    @Autowired
    private QueryBuilder queryBuilder;

    @Before
    public void setUp () {
//    	queryBuilder = applicationContext.getBean(QueryBuilder.class);
    }

    @After
    public void tearDown () {
        this.queryBuilder = null;
    }

    @Test
    public void testDoGetAsSecurities () {
        Securities securities = queryBuilder.securities(SecurityType.FRN).doGetAsSecurities();
        
        System.out.println(securities);
    }
}
