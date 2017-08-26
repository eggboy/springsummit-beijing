package io.pivotal.spring.summit.cachedemo.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.session.data.gemfire.config.annotation.web.http.EnableGemFireHttpSession;

@Profile("geode")
@Configuration
@EnableGemFireHttpSession
@ImportResource(value = "gemfire-client.xml")
@SuppressWarnings("unused")
@EnableCaching
public class GemfireCacheConfig  {
}
