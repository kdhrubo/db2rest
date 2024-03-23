package com.homihq.db2rest.mongodb.config;

import com.homihq.db2rest.core.DbOperationService;
import com.homihq.db2rest.mongodb.DefaultMongodbOperationService;
import com.homihq.db2rest.mongodb.MongodbDialect;
import com.homihq.db2rest.mongodb.rsql.RsqlMongodbAdapter;
import com.homihq.db2rest.mongodb.rsql.argconverters.NoOpConverter;
import com.homihq.db2rest.mongodb.rsql.argconverters.StringToQueryValueConverter;
import com.homihq.db2rest.mongodb.rsql.visitor.ComparisonToCriteriaConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@Configuration
@ConditionalOnProperty(prefix = "db2rest.datasource", name = "type", havingValue = "mongo")
public class MongodbConfiguration {

    @Bean
    public MongodbDialect d1Dialect() {
        return new MongodbDialect();
    }

    @Bean
    public DbOperationService defaultMongodbOperationService(MongoTemplate mongoTemplate) {
        return new DefaultMongodbOperationService(mongoTemplate);
    }

    @Bean
    public RsqlMongodbAdapter rsqlMongoAdapter(List<StringToQueryValueConverter> converters) {
        return new RsqlMongodbAdapter(comparisonToCriteriaConverter(converters));
    }

    @Bean
    public ComparisonToCriteriaConverter comparisonToCriteriaConverter(List<StringToQueryValueConverter> converters) {
        return new ComparisonToCriteriaConverter(converters);
    }

    @Bean
    public NoOpConverter noOpConverter() {
        return new NoOpConverter();
    }

}
