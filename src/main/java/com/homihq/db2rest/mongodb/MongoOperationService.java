package com.homihq.db2rest.mongodb;

import com.homihq.db2rest.core.DbOperationService;
import com.homihq.db2rest.core.model.DbTable;
import com.homihq.db2rest.rest.create.dto.CreateBulkResponse;
import com.homihq.db2rest.rest.create.dto.CreateResponse;
import com.homihq.db2rest.rest.read.dto.CountResponse;
import com.homihq.db2rest.rest.read.dto.ExistsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class MongoOperationService implements DbOperationService {

    private final MongoTemplate mongoTemplate;

    @Override
    public int update(Map<String, Object> paramMap, String sql) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> read(Map<String, Object> paramMap, String sql) {
        return null;
    }

    @Override
    public Map<String, Object> findOne(String sql, Map<String, Object> paramMap) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> findOne(Query query, String collectionName) {
        return mongoTemplate.findOne(query, LinkedHashMap.class, collectionName);
    }

    @Override
    public ExistsResponse exists(Map<String, Object> paramMap, String sql) {
        return null;
    }

    @Override
    public CountResponse count(Map<String, Object> paramMap, String sql) {
        return null;
    }

    @Override
    public Object queryCustom(boolean single, String sql, Map<String, Object> params) {
        return null;
    }

    @Override
    public int delete(Map<String, Object> params, String sql) {
        return 0;
    }

    @Override
    public CreateResponse create(Map<String, Object> data, String sql, DbTable dbTable) {
        return null;
    }

    @Override
    public CreateResponse create(Map<String, Object> data, String collectionName) {
        var document = new Document();
        var objectId = new ObjectId();
        document.append("_id", objectId);

        data.forEach(document::append);
        mongoTemplate.save(document, collectionName);
        return new CreateResponse(1, objectId.toHexString());
    }

    @Override
    public CreateBulkResponse batchUpdate(List<Map<String, Object>> dataList, String sql, DbTable dbTable) {
        return null;
    }
}
