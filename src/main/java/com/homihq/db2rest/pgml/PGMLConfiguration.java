package com.homihq.db2rest.pgml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.postgresml.PostgresMlEmbeddingClient;
import org.springframework.ai.postgresml.PostgresMlEmbeddingOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ConditionalOnProperty(name = "spring.ai.postgresml.enabled", havingValue = "true")
@Slf4j
public class PGMLConfiguration {

    @Bean
    public PostgresMlEmbeddingClient embeddingClient(JdbcTemplate jdbcTemplate, PostgresMlEmbeddingOptions options) {
       log.info("**** Creating PGML Embedding client ****");

        PostgresMlEmbeddingClient embeddingClient = new PostgresMlEmbeddingClient(jdbcTemplate);
        embeddingClient.afterPropertiesSet();
        return embeddingClient;
    }
}
