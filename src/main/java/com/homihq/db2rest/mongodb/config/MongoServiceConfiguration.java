package com.homihq.db2rest.mongodb.config;

import com.homihq.db2rest.core.DbOperationService;
import com.homihq.db2rest.core.Dialect;
import com.homihq.db2rest.core.service.BulkCreateService;
import com.homihq.db2rest.core.service.CountQueryService;
import com.homihq.db2rest.core.service.CreateService;
import com.homihq.db2rest.core.service.CustomQueryService;
import com.homihq.db2rest.core.service.DeleteService;
import com.homihq.db2rest.core.service.ExistsQueryService;
import com.homihq.db2rest.core.service.FindOneService;
import com.homihq.db2rest.core.service.ReadService;
import com.homihq.db2rest.core.service.UpdateService;
import com.homihq.db2rest.mongodb.MongoDialect;
import com.homihq.db2rest.mongodb.rsql.RsqlMongoAdapter;
import com.homihq.db2rest.mongodb.service.MongoBulkCreateService;
import com.homihq.db2rest.mongodb.service.MongoCountQueryService;
import com.homihq.db2rest.mongodb.service.MongoCreateService;
import com.homihq.db2rest.mongodb.service.MongoCustomQueryService;
import com.homihq.db2rest.mongodb.service.MongoDeleteService;
import com.homihq.db2rest.mongodb.service.MongoExistsQueryService;
import com.homihq.db2rest.mongodb.service.MongoFindOneService;
import com.homihq.db2rest.mongodb.service.MongoReadService;
import com.homihq.db2rest.mongodb.service.MongoUpdateService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(MongoDialect.class)
public class MongoServiceConfiguration {
    @Bean
    public CreateService createService(DbOperationService dbOperationService, Dialect dialect) {
        return new MongoCreateService(dbOperationService, dialect);
    }

    @Bean
    public BulkCreateService bulkCreateService(DbOperationService dbOperationService, Dialect dialect) {
        return new MongoBulkCreateService(dbOperationService, dialect);
    }

    @Bean
    public CountQueryService countQueryService() {
        return new MongoCountQueryService();
    }

    @Bean
    public ExistsQueryService existsQueryService() {
        return new MongoExistsQueryService();
    }

    @Bean
    public FindOneService findOneService(DbOperationService dbOperationService, RsqlMongoAdapter rsqlMongoAdapter) {
        return new MongoFindOneService(dbOperationService, rsqlMongoAdapter);
    }

    @Bean
    public CustomQueryService customQueryService() {
        return new MongoCustomQueryService();
    }

    @Bean
    public ReadService readService() {
        return new MongoReadService();
    }

    @Bean
    public UpdateService updateService() {
        return new MongoUpdateService();
    }

    @Bean
    public DeleteService deleteService() {
        return new MongoDeleteService();
    }
}
