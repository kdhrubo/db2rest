package com.homihq.db2rest.mongodb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mongodb")
@Data
public class MongoDBProperties {

    private String host;

    private String port;

    private String database;

    private String userName;

    private String password;
}
