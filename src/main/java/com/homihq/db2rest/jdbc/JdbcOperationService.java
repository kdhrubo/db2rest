package com.homihq.db2rest.jdbc;

import com.homihq.db2rest.core.DbOperationService;
import com.homihq.db2rest.rest.create.dto.CreateResponse;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Map;

public interface JdbcOperationService extends DbOperationService {

    @Override
    default Map<String, Object> findOne(Query query, String collectionName) {
        return Map.of();
    }

    @Override
    default CreateResponse create(Map<String, Object> data, String collectionName) {
        return null;
    }
}
