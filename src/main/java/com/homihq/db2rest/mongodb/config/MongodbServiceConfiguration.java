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
import com.homihq.db2rest.mongodb.MongodbDialect;
import com.homihq.db2rest.mongodb.rsql.RsqlMongodbAdapter;
import com.homihq.db2rest.mongodb.service.MongodbBulkCreateService;
import com.homihq.db2rest.mongodb.service.MongodbCountQueryService;
import com.homihq.db2rest.mongodb.service.MongodbCreateService;
import com.homihq.db2rest.mongodb.service.MongodbCustomQueryService;
import com.homihq.db2rest.mongodb.service.MongodbDeleteService;
import com.homihq.db2rest.mongodb.service.MongodbExistsQueryService;
import com.homihq.db2rest.mongodb.service.MongodbFindOneService;
import com.homihq.db2rest.mongodb.service.MongodbReadService;
import com.homihq.db2rest.mongodb.service.MongodbUpdateService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(MongodbDialect.class)
public class MongodbServiceConfiguration {
    @Bean
    public CreateService createService(DbOperationService dbOperationService, Dialect dialect) {
        return new MongodbCreateService(dbOperationService, dialect);
    }

    @Bean
    public BulkCreateService bulkCreateService(DbOperationService dbOperationService, Dialect dialect) {
        return new MongodbBulkCreateService(dbOperationService, dialect);
    }

    @Bean
    public CountQueryService countQueryService() {
        return new MongodbCountQueryService();
    }

    @Bean
    public ExistsQueryService existsQueryService() {
        return new MongodbExistsQueryService();
    }

    @Bean
    public FindOneService findOneService(DbOperationService dbOperationService,
                                         RsqlMongodbAdapter rsqlMongodbAdapter) {
        return new MongodbFindOneService(dbOperationService, rsqlMongodbAdapter);
    }

    @Bean
    public CustomQueryService customQueryService() {
        return new MongodbCustomQueryService();
    }

    @Bean
    public ReadService readService() {
        return new MongodbReadService();
    }

    @Bean
    public UpdateService updateService() {
        return new MongodbUpdateService();
    }

    @Bean
    public DeleteService deleteService() {
        return new MongodbDeleteService();
    }
}
