package com.coherentlogic.treasurydirect.client.core.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.coherentlogic.treasurydirect.client.core.domain.Security;

/**
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class SecurityFactory implements TypedFactory<Security> {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Security getInstance() {
        return applicationContext.getBean(Security.class);
    }
}
