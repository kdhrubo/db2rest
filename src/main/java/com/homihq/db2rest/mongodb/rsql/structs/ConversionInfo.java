package com.homihq.db2rest.mongodb.rsql.structs;

import com.homihq.db2rest.mongodb.rsql.operator.Operator;

public record ConversionInfo(String pathToField, String argument, Class<?> targetEntityClass, Operator operator) {}
