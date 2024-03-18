package com.homihq.db2rest.mongodb.service;

import com.homihq.db2rest.core.DbOperationService;
import com.homihq.db2rest.core.service.ReadService;
import com.homihq.db2rest.rest.read.dto.ReadContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class MongoReadService implements ReadService {

    private final DbOperationService dbOperationService;

    @Override
    public Object findAll(ReadContext readContext) {
        log.info("ReadContext - {}", readContext);
        return dbOperationService.read(readContext.getTableName());
    }
}
