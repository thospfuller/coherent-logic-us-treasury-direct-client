package com.coherentlogic.treasurydirect.client.core.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.coherentlogic.coherent.data.adapter.core.builders.AbstractQueryBuilder;
import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder;

/**
 * Factory used to obtain instances of {@link QueryBuilder}.
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Component
public class QueryBuilderFactory implements TypedFactory<AbstractQueryBuilder<String, Object>> {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public QueryBuilder getInstance() {
        return applicationContext.getBean(QueryBuilder.class);
    }
}
