package com.homihq.db2rest.mongodb.service;

import com.homihq.db2rest.core.service.DeleteService;

public class MongodbDeleteService implements DeleteService {
    @Override
    public int delete(String schemaName, String tableName, String filter) {
        return 0;
    }
}
