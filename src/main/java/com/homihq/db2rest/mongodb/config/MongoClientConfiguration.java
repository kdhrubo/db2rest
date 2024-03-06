package com.homihq.db2rest.mongodb.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "db2rest.datasource", name = "type", havingValue = "mongo")
public class MongoClientConfiguration {

    private final MongoDBProperties mongoDBProperties;

    @Bean
    public ConnectionString connectionString() {
        return new ConnectionString(getConnectionString());
    }

    @Bean
    public MongoClientSettings mongoClientSettings() {
        return MongoClientSettings.builder()
                .applyConnectionString(connectionString())
                .build();
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoClientSettings());
    }

    private String getConnectionString() {
        return "mongodb+srv://" +
                mongoDBProperties.getUserName() + ":" +
                mongoDBProperties.getPassword() + "@" +
                mongoDBProperties.getHost() + ":" +
                mongoDBProperties.getPort() + "/" +
                mongoDBProperties.getDatabase() +
                "?retryWrites=true&w=majority";
    }
}
