package com.homihq.db2rest.mongodb;

import com.homihq.db2rest.rest.create.dto.CreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class DefaultMongodbOperationService implements MongodbOperationService {

    private final MongoTemplate mongoTemplate;

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> findOne(Query query, String collectionName) {
        return mongoTemplate.findOne(query, LinkedHashMap.class, collectionName);
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

}
