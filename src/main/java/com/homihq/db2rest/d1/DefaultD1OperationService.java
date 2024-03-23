package com.homihq.db2rest.d1;

import com.homihq.db2rest.core.model.DbTable;
import com.homihq.db2rest.d1.model.D1PostResponse;
import com.homihq.db2rest.exception.GenericDataAccessException;
import com.homihq.db2rest.rest.create.dto.CreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
public class DefaultD1OperationService implements D1OperationService {

    private final D1RestClient d1RestClient;

    @Override
    public int update(Map<String, Object> paramMap, String sql) {

        D1PostResponse response =
                d1RestClient.callD1(sql,
                        paramMap.values().stream().toList());

        log.info("Response - {}", response);

        if (!response.success()) throw new GenericDataAccessException("Error updating data from D1 service.");

        return 1;
    }

    @Override
    public List<Map<String, Object>> read(Map<String, Object> paramMap, String sql) {
        log.info("SQL - {}", sql);

        D1PostResponse response =
                d1RestClient.callD1(sql,
                        paramMap == null ? List.of() :
                                paramMap.values().stream().toList());

        log.info("response - {}", response);

        if (!response.success()) throw new GenericDataAccessException("Error reading data from D1 service.");

        return response.result().get(0).results();
    }

    @Override
    public int delete(Map<String, Object> paramMap, String sql) {
        D1PostResponse response =
                d1RestClient.callD1(sql,
                        paramMap.values().stream().toList());

        log.info("Response - {}", response);

        if (!response.success()) throw new GenericDataAccessException("Error deleting data from D1 service.");

        return 1;
    }

    @Override
    public CreateResponse create(Map<String, Object> paramMap, String sql, DbTable dbTable) {

        D1PostResponse response =
                d1RestClient.callD1(sql,
                        paramMap.values().stream().toList());

        log.info("Response - {}", response);

        if (!response.success()) throw new GenericDataAccessException("Error reading data from D1 service.");

        return new CreateResponse(1, null);
    }

}
