package com.homihq.db2rest.mongodb.service;

import com.homihq.db2rest.core.service.CustomQueryService;
import com.homihq.db2rest.rest.read.dto.QueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MongoCustomQueryService implements CustomQueryService {
    @Override
    public Object find(QueryRequest queryRequest) {
        return null;
    }
}
