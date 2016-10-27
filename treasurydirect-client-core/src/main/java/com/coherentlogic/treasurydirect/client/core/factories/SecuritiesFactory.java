package com.coherentlogic.treasurydirect.client.core.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.coherentlogic.treasurydirect.client.core.domain.Securities;

/**
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Component
public class SecuritiesFactory implements TypedFactory<Securities> {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Securities getInstance() {
        return applicationContext.getBean(Securities.class);
    }
}
