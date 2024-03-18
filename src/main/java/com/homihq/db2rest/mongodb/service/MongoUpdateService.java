package com.homihq.db2rest.mongodb.service;

import com.homihq.db2rest.core.service.UpdateService;

import java.util.Map;

public class MongoUpdateService implements UpdateService {
    @Override
    public int patch(String schemaName, String collectionName, Map<String, Object> data, String filter) {
        return 0;
    }
}
