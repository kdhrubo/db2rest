package com.homihq.db2rest.rest.read.model;

import lombok.Data;

@Data
public class RJoin {

    String schemaName;
    String tableName;
    String alias;

    String left;
    String right;
    String rightTable;
    String rightTableAlias;

    String type;

    public String getJoin() {

        return type + " JOIN " +  tableName + " " + alias +
            " ON " + alias + "." +   right + " = " + rightTableAlias + "." + left;
    }


}
