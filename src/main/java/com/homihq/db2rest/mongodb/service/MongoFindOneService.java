package com.homihq.db2rest.mongodb.service;

import com.homihq.db2rest.core.DbOperationService;
import com.homihq.db2rest.core.service.FindOneService;
import com.homihq.db2rest.mongodb.rsql.RsqlMongoAdapter;
import com.homihq.db2rest.rest.read.dto.ReadContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class MongoFindOneService implements FindOneService {

    private final DbOperationService dbOperationService;

    private final RsqlMongoAdapter rsqlMongoAdapter;

    @Override
    public Map<String, Object> findOne(ReadContext readContext) {
        Query query = Query.query(rsqlMongoAdapter.getCriteria(readContext.getFilter(), Document.class));
        var fields = readContext.getFields();
        if (StringUtils.isNotBlank(fields)) {
            query.fields().include(fields.split(","));
        }
        return dbOperationService.findOne(query, readContext.getTableName());
    }
}
