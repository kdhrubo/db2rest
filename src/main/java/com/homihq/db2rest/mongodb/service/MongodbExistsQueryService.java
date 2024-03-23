package com.homihq.db2rest.mongodb.service;

import com.homihq.db2rest.core.service.ExistsQueryService;
import com.homihq.db2rest.rest.read.dto.ExistsResponse;
import com.homihq.db2rest.rest.read.dto.ReadContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MongodbExistsQueryService implements ExistsQueryService {
    @Override
    public ExistsResponse exists(ReadContext readContext) {
        return null;
    }
}
