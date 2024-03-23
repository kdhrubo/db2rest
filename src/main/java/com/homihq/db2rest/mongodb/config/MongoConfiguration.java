package com.homihq.db2rest.mongodb.config;

import com.homihq.db2rest.core.DbOperationService;
import com.homihq.db2rest.d1.D1Dialect;
import com.homihq.db2rest.mongodb.MongoDialect;
import com.homihq.db2rest.mongodb.MongoOperationService;
import com.homihq.db2rest.mongodb.rsql.RsqlMongoAdapter;
import com.homihq.db2rest.mongodb.rsql.argconverters.EntityFieldTypeConverter;
import com.homihq.db2rest.mongodb.rsql.argconverters.FieldSpecificConverter;
import com.homihq.db2rest.mongodb.rsql.argconverters.NoOpConverter;
import com.homihq.db2rest.mongodb.rsql.argconverters.OperatorSpecificConverter;
import com.homihq.db2rest.mongodb.rsql.argconverters.StringToQueryValueConverter;
import com.homihq.db2rest.mongodb.rsql.visitor.ComparisonToCriteriaConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.List;

@Configuration
@ConditionalOnProperty(prefix = "db2rest.datasource", name = "type", havingValue = "mongo")
public class MongoConfiguration {

    @Bean
    public MongoDialect d1Dialect() {
        return new MongoDialect();
    }

    @Bean
    public DbOperationService mongoOperationService(MongoTemplate mongoTemplate) {
        return new MongoOperationService(mongoTemplate);
    }

    @Bean
    public RsqlMongoAdapter rsqlMongoAdapter(List<StringToQueryValueConverter> converters) {
        return new RsqlMongoAdapter(comparisonToCriteriaConverter(converters));
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
