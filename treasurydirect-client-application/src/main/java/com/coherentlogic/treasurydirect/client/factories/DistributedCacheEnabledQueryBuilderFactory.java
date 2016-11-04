package com.coherentlogic.treasurydirect.client.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.coherentlogic.coherent.data.adapter.core.builders.AbstractQueryBuilder;
import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.coherentlogic.coherent.data.adapter.core.listeners.QueryBuilderEvent;
import com.coherentlogic.coherent.data.adapter.core.listeners.QueryBuilderEventListener;
import com.coherentlogic.treasurydirect.client.applications.ApplicationGlobalConfiguration;
import com.coherentlogic.treasurydirect.client.applications.MainApplication;
import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder;

/**
 * Factory used to obtain instances of {@link QueryBuilder}.
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Component
public class DistributedCacheEnabledQueryBuilderFactory implements TypedFactory<AbstractQueryBuilder<String, Object>> {

    private static final Logger log = LoggerFactory.getLogger(DistributedCacheEnabledQueryBuilderFactory.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public QueryBuilder getInstance() {

        QueryBuilder result = (QueryBuilder) applicationContext.getBean(
            ApplicationGlobalConfiguration.DISTRIBUTED_CACHE_ENABLED_QUERY_BUILDER
        );

        result.addQueryBuilderEventListener(new QueryBuilderEventListener<String, Object> () {
            @Override
            public void onEvent(QueryBuilderEvent<String, Object> event) {
                log.info("event: " + event);
            }
        });

        return result;
    }
}