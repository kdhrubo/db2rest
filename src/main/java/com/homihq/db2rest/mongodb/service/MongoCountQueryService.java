package com.homihq.db2rest.mongodb.service;

import com.homihq.db2rest.core.service.CountQueryService;
import com.homihq.db2rest.rest.read.dto.CountResponse;
import com.homihq.db2rest.rest.read.dto.ReadContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MongoCountQueryService implements CountQueryService {
    @Override
    public CountResponse count(ReadContext readContext) {
        return null;
    }
}
