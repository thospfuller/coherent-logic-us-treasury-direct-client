package com.coherentlogic.treasurydirect.client.core.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.coherentlogic.treasurydirect.client.core.domain.Debt;

/**
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class DebtFactory implements TypedFactory<Debt> {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Debt getInstance() {
        return applicationContext.getBean(Debt.class);
    }
}
