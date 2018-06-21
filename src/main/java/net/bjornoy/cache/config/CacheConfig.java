package net.bjornoy.cache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    private final String name;
    private final Long ttl;

    public CacheConfig(@Value("${cache.name}") String name,
                       @Value("${cache.ttl}") Long ttl) {
        this.name = name;
        this.ttl = ttl;
    }

    @Bean
    public CacheManager cacheManager() {
        Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
                .expireAfterWrite(ttl, TimeUnit.SECONDS)
                .maximumSize(100);

        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager(name);
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }

}
