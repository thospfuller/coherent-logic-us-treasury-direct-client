package com.coherentlogic.treasurydirect.client.core.builders;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import com.coherentlogic.treasurydirect.client.core.domain.Debts;
import com.coherentlogic.treasurydirect.client.core.domain.Securities;
import com.coherentlogic.treasurydirect.client.core.factories.QueryBuilderFactory;

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

    @Autowired
    private QueryBuilderFactory queryBuilderFactory;

    private QueryBuilder queryBuilder;

    @Before
    public void setUp () {
        queryBuilder = queryBuilderFactory.getInstance();
    }

    @After
    public void tearDown () {
        this.queryBuilder = null;
    }

    // TODO: set up this test too: http://www.treasurydirect.gov/TA_WS/securities/912796CJ6/02/11/2014?format=json

    @Test
    public void testDoGetAsSecurities () {

        Securities securities = queryBuilder.securities(SecurityType.FRN).doGetAsSecurities();

        assertNotNull(securities);
        assertTrue(30 < securities.getSecurityList().size());
    }

    /**
     * http://www.treasurydirect.gov/NP_WS/debt/current
     */
    @Test
    public void testDoGetAsDebts () {

        Debts debts = queryBuilder.debt().current().doGetAsDebts();

        assertNotNull("debts", debts);
        assertNotNull("debtList", debts.getDebtList());

        assertTrue(1 == debts.getDebtList().size());
    }

    /**
     * http://www.treasurydirect.gov/NP_WS/debt/search?startdate=2014-01-01&enddate=2014-02-01
     */
    @Test
    public void testDebtSearchExample () {

        Debts debts = queryBuilder.debt().search().withStartDate("2014-01-01").withEndDate("2014-02-01").doGetAsDebts();

        assertNotNull("debts", debts);
        assertNotNull("debtList", debts.getDebtList());

        assertTrue(21 == debts.getDebtList().size());
    }
}
