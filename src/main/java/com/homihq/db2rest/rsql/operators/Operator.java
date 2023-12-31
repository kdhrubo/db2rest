package com.homihq.db2rest.rsql.operators;

import com.homihq.db2rest.rest.read.model.RCondition;

import java.util.List;

public interface Operator {

    RCondition handle(String columnName, String value, Class type);

    default RCondition handle(String columnName, List<String> value, Class type) {
        return handle(columnName, value.get(0), type);
    }

    default Object parseValue(String value, Class type) {

        if (String.class == type) {
            return value;
        }
        else if (Boolean.class == type || boolean.class == type) {
            return Boolean.valueOf(value);
        }
        else if (Integer.class == type || int.class == type) {
            return Integer.valueOf(value);
        }

        else {
            return value;
        }

    }

}
