package com.homihq.db2rest.mongodb.service;

import com.homihq.db2rest.core.DbOperationService;
import com.homihq.db2rest.core.Dialect;
import com.homihq.db2rest.core.service.BulkCreateService;
import com.homihq.db2rest.rest.create.dto.CreateBulkResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
@Slf4j
@RequiredArgsConstructor
public class MongodbBulkCreateService implements BulkCreateService {
    private final DbOperationService dbOperationService;

    private final Dialect dialect;
    @Override
    public CreateBulkResponse saveBulk(String schemaName, String tableName, List<String> includedColumns,
                                       List<Map<String, Object>> dataList, boolean tsIdEnabled) {
        return null;
    }
}
