package com.coherentlogic.treasurydirect.client.examples;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.coherentlogic.coherent.data.adapter.core.cache.MapCompliantCacheServiceProvider;
import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.coherentlogic.treasurydirect.client.core.builders.QueryBuilder;
import com.coherentlogic.treasurydirect.client.core.configuration.GlobalConfiguration;
import com.coherentlogic.treasurydirect.client.core.domain.Debts;
import com.coherentlogic.treasurydirect.client.core.domain.Securities;
import com.coherentlogic.treasurydirect.client.core.extractors.DebtsExtractor;
import com.coherentlogic.treasurydirect.client.core.extractors.SecuritiesExtractor;

@org.springframework.context.annotation.Configuration
public class ApplicationGlobalConfiguration {

    public static final String DISTRIBUTED_CACHE_SERVICE_PROVIDER = "cacheServiceProvider",
        DISTRIBUTED_CACHE_ENABLED_QUERY_BUILDER = "distributedCacheEnabledQueryBuilder";

    @Bean(name=DISTRIBUTED_CACHE_SERVICE_PROVIDER)
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MapCompliantCacheServiceProvider<String, Object> getMapCompliantCacheServiceProvider () {

        org.infinispan.configuration.global.GlobalConfiguration globalConfiguration =
            new GlobalConfigurationBuilder().transport().defaultTransport().build();

        EmbeddedCacheManager manager = new DefaultCacheManager(globalConfiguration);

        Configuration dcc = manager.getDefaultCacheConfiguration();

        Configuration configuration = new ConfigurationBuilder()
            .read(dcc)
            .clustering()
            .cacheMode(CacheMode.DIST_SYNC)
            .l1()
            .lifespan(60000L)
            .build();

        String newCacheName = "treasuryDirectCache";

        manager.defineConfiguration(newCacheName, configuration);

        Cache<String, Object> cache = manager.getCache(newCacheName);

        return new MapCompliantCacheServiceProvider<String, Object> (cache);
    }

    @Bean(name=DISTRIBUTED_CACHE_ENABLED_QUERY_BUILDER)
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public QueryBuilder getDistributedCacheEnabledQueryBuilder (
        @Qualifier(DISTRIBUTED_CACHE_SERVICE_PROVIDER) MapCompliantCacheServiceProvider<String, Object>
            cacheServiceProvider,
        @Qualifier(GlobalConfiguration.TREASURY_DIRECT_REST_TEMPLATE) RestTemplate restTemplate,
        @Qualifier(SecuritiesExtractor.BEAN_NAME) ResponseExtractor<Securities> securitiesExtractor,
        @Qualifier(DebtsExtractor.BEAN_NAME) ResponseExtractor<Debts> debtsExtractor
    ) {
        return new QueryBuilder (restTemplate, cacheServiceProvider, securitiesExtractor, debtsExtractor);
    }
}
