package com.homihq.db2rest.jdbc.rsql.operator.handler;

import com.homihq.db2rest.core.Dialect;
import com.homihq.db2rest.core.model.DbColumn;

import java.util.Map;

public class LikeOperatorHandler implements OperatorHandler {

   private static final String OPERATOR = " like ";

    @Override
    public String handle(Dialect dialect, DbColumn column, String value, Class type, Map<String, Object> paramMap) {
        //value is always string for like operator
        String vo = "%" + value + "%";

        if(dialect.supportAlias()) {

            paramMap.put(column.getAliasedNameParam(), vo);
            return column.getAliasedName() + OPERATOR + PREFIX + column.getAliasedNameParam();
        }
        else{
            paramMap.put(column.name(), vo);
            return column.name() + OPERATOR + PREFIX + column.name();
        }

    }

}
