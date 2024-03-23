package com.homihq.db2rest.rest;

import com.homihq.db2rest.core.service.*;
import com.homihq.db2rest.core.service.ProcedureService;
import com.homihq.db2rest.mongodb.MongodbDialect;
import com.homihq.db2rest.rest.create.BulkCreateController;
import com.homihq.db2rest.rest.create.CreateController;
import com.homihq.db2rest.rest.create.bulk.DataProcessor;
import com.homihq.db2rest.rest.delete.DeleteController;
import com.homihq.db2rest.rest.read.*;
import com.homihq.db2rest.rest.rpc.FunctionController;
import com.homihq.db2rest.rest.rpc.ProcedureController;
import com.homihq.db2rest.rest.update.UpdateController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RestApiConfiguration {
    //CREATE API
    @Bean
    public BulkCreateController bulkCreateController(BulkCreateService bulkCreateService, List<DataProcessor> dataProcessors) {
        return new BulkCreateController(bulkCreateService, dataProcessors);
    }

    @Bean
    public CreateController createController(CreateService createService) {
        return new CreateController(createService);
    }

    //READ API
    @Bean
    public CountQueryController countQueryController(CountQueryService countQueryService) {
        return new CountQueryController(countQueryService);
    }

    @Bean
    public ExistsQueryController existsQueryController(ExistsQueryService existsQueryService) {
        return new ExistsQueryController(existsQueryService);
    }

    @Bean
    public CustomQueryController customQueryController(CustomQueryService customQueryService) {
        return new CustomQueryController(customQueryService);
    }

    @Bean
    public FindOneController findOneController(FindOneService findOneService) {
        return new FindOneController(findOneService);
    }

    @Bean
    public ReadController readController(ReadService readService) {
        return new ReadController(readService);
    }


    //UPDATE API
    @Bean
    public UpdateController updateController(UpdateService updateService) {
        return new UpdateController(updateService);
    }

    //DELETE API
    @Bean
    public DeleteController deleteController(DeleteService deleteService) {
        return new DeleteController(deleteService);
    }

    //RPC
    @Bean
    @ConditionalOnMissingBean(MongodbDialect.class)
    public FunctionController functionController(FunctionService functionService) {
        return new FunctionController(functionService);
    }

    @Bean
    @ConditionalOnMissingBean(MongodbDialect.class)
    public ProcedureController procedureController(ProcedureService procedureService) {
        return new ProcedureController(procedureService);
    }
}
